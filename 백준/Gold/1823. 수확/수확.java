import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] dp;
	public static int[] data;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N+1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		dp = new int[N+1][N + 1];

		int result = find(1, N, 1);
		System.out.println(result);
	}

	public static int find(int left, int right, int time) {
		if (left > right) {
			return 0;
		}
		if (dp[left][right] > 0) {
			return dp[left][right];
		}

		return dp[left][right] = Math.max(find(left + 1, right, time + 1) + data[left] * time,
			find(left,right-1,time+1) +data[right]*time);

	}
}