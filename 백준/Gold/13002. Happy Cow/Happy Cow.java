

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] dp;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N][N];

		int result = find(0, N-1, 1);
		System.out.println(result);
	}

	public static int find(int left, int right, int day) {
		if (left > right) {
			return 0;
		}

		if (dp[left][right] > 0) {
			return dp[left][right];
		}

		int max = 0;
		max = Math.max(find(left + 1, right, day + 1) + data[left] * day,
			find(left, right - 1, day + 1) + data[right] * day);

		return dp[left][right] = max;
	}
}
