

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>(N);
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		int i = 19;
		int result = 0;
		while(i>=0){
			int v = 1<<i;
			List<Integer> temp = new ArrayList<>();
			for (int j = 0; j < list.size(); j++) {
				if ((list.get(j) & v) > 0) {
					temp.add(list.get(j));
				}
			}

			if (temp.size() >= K) {
				list = temp;
				result |= v;
			}
			i--;
		}

		System.out.println(result);
	}
}
