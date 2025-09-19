

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			data = new int[N];
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			dp = new int[N][N];
			int result = find(0, N - 1, 0);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static int find(int left, int right, int turn) {
		if (left > right) {
			return 0;
		}

		if (dp[left][right] > 0) {
			return dp[left][right];
		}

		int max = 0;
		if (turn == 0) {
			max = Math.max(find(left + 1, right, 1) + data[left], find(left, right - 1, 1) + data[right]);
		} else {
			max = Math.min(find(left + 1, right, 0), find(left, right - 1, 0));
		}
		return dp[left][right] = max;
	}
}
