

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static long[] data;
	public static long[] arr;
	public static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new long[N+1];
		arr = new long[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Long.parseLong(st.nextToken());
			arr[i] = i;
		}

		dp = new long[2001][2001];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}

		System.out.println(find(1, N, 1));
	}

	public static long find(int left, int right, int day) {
		if(left > right)
			return 0;

		if(dp[left][right] != -1) {
			return dp[left][right];
		}

		return dp[left][right] = Math.max(data[left] * day + find(left + 1, right, day + 1),  data[right] * day + find(left, right - 1, day + 1));
	}

}

