

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static int result = 0;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N][N];
		result = find(0, N - 1, 1, 0);

		System.out.println(result);
	}

	public static int find(int left, int right, int day, int sum) {
		if (left > right) {
			return 0;
		}

		if (dp[left][right] > 0) {
			return dp[left][right];
		}


		int max = 0;
		max = find(left + 1, right, day + 1, sum + data[left] * day) + data[left]*day;
		max = Math.max(find(left, right - 1, day + 1, sum + data[right] * day)+data[right]*day, max);

		return dp[left][right] = max;


	}
}
