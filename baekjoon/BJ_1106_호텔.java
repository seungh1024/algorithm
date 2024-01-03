package algo_202401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1106_호텔 {
	public static int C,N;
	public static int[][] data;
	public static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		data = new int[N+1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			data[i][0] = a; // 0 = 비용
			data[i][1] = b; // 1 = 사람 수
		}

		dp = new int[C+1];
		for (int j = 1; j <= C; j++) {
			int value = j/data[1][1];
			if(j%data[1][1]>0) value++;
			value *= data[1][0];
			dp[j] = value;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= C; j++) {
				// System.out.println("before: " + Arrays.toString(dp));
				int value = j/data[i][1];
				if (j % data[i][1] > 0) {
					value ++;
				}
				value *= data[i][0];

				// System.out.println("value : " +value);
				if (j >= data[i][1]) {
					dp[j] = Math.min(dp[j], dp[j - data[i][1]] + data[i][0]);
				} else {
					dp[j] = Math.min(dp[j],value);
				}
				// System.out.println("after: " + Arrays.toString(dp));
			}
		}
		System.out.println(dp[C]);

	}
}
