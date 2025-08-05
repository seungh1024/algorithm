

import java.io.*;
import java.util.*;

public class Main {
	public static int N, K;
	public static int[] data;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int v = Integer.parseInt(st.nextToken());
			list.add(v);
		}

		int result = 0;
		for (int i = 19; i >= 0; i--) {
			List<Integer> temp = new ArrayList<>();
			for (int v : list) {
				if ((v & (1 << i)) != 0) {
					temp.add(v);
				}
			}
			if (temp.size() >= K) {
				result += (1<<i);
				list = temp;
			}
		}

		System.out.println(result);
	}
}
