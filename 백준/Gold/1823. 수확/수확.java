import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());


		data = new int[N+1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}


		dp = new int[N + 1][N + 1];

		int left = 1;
		int right = N;

		int result = find(left, right, 1);
		// System.out.println(dp[1][N]);
		System.out.println(result);
	}

	public static int find(int left, int right, int count) {
		if (left > right) {
			return 0;
		}
		if (dp[left][right] > 0) {
			return dp[left][right];
		}

		return dp[left][right] = Math.max(find(left + 1, right, count + 1) + data[left] * count,
			find(left, right - 1, count + 1) + data[right] * count);
	}
}