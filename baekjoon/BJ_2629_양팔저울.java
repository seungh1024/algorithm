package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_2629_양팔저울 {
	public static int N, M;
	public static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		boolean[] dp = new boolean[15001];

		for (int i = 1; i <= N; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(data[i]);

			for (int j = 1; j <= 15000; j++) {
				if (dp[j]) {
					if (j + data[i] <= 15000) {
						list.add(j + data[i]);
					}
					list.add(Math.abs(j - data[i]));
				}
			}

			for (int idx : list) {
				dp[idx] = true;
			}
		}


		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int input = Integer.parseInt(st.nextToken());

			if (input > 15000) {
				sb.append("N");
			} else if (dp[input]) {
				sb.append("Y");
			} else {
				sb.append("N");
			}
			sb.append(" ");
		}

		System.out.println(sb);

	}
}
