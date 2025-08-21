

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int result = Integer.MAX_VALUE;
		List<Integer> G = new ArrayList<>();
		List<Integer> L = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int p = Integer.parseInt(st.nextToken());
			if (c == 'G') {
				G.add(p);
			} else {
				L.add(p);
			}

			list.add(p);
		}
		// G.add(-1);
		// Collections.sort(G);
		//
		// Collections.sort(L);
		// Collections.sort(list);
		for (int i :list) {
			int cnt = 0;
			int p = i;
			// System.out.println("p = "+p);
			for (int j = 0; j < G.size(); j++) {
				int n = G.get(j);
				// System.out.println("g = "+n);
				if (p < n) {
					cnt++;
				}
			}
			for (int j = 0; j < L.size(); j++) {
				int n = L.get(j);
				// System.out.println("l = "+n);
				if (p > n) {
					cnt++;
				}
			}
			result = Math.min(result, cnt);
		}
		System.out.println(result);


	}
}
