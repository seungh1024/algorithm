

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 2]; // 값 기준 DP (인덱스 아님)
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;

		for (int i = 0; i < N; i++) {
			int v = Integer.parseInt(st.nextToken());
			dp[v] = dp[v - 1] + 1;
			if (dp[v] > max) max = dp[v];
		}

		System.out.println(N - max);
	}
}
