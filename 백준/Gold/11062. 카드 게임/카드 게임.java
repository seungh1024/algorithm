

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			data = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}
			dp = new int[N][N][2];
			int result = find(0, N - 1, 0);
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static int find(int left, int right, int turn) {
		if (left >= right) {
			if (turn == 0) {
				return dp[left][right][turn] = data[left];
			}
			return 0;
		}

		if (dp[left][right][turn] > 0) {
			return dp[left][right][turn];
		}

		int nextTurn = (turn+1)%2;
		int v = 0;
		if (turn == 0) {
			v = Math.max(data[left] + find(left + 1, right, nextTurn), data[right] + find(left, right - 1, nextTurn));
		} else {
			v = Math.min(find(left + 1, right, nextTurn), find(left, right - 1, nextTurn));
		}

		return dp[left][right][turn] = v;
	}
}
