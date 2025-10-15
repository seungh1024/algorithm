

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[]dp = new int[N+1];

		int[] data = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());

		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			int temp = data[i] == 1 ? 1 : -1;
			dp[i] = Math.max(dp[i - 1] + temp, temp);
			max = Math.max(max, dp[i]);
		}

		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int temp = data[i] == 1 ? -1 : 1;
			dp[i] = Math.max(dp[i - 1] + temp, temp);
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);



	}
}
