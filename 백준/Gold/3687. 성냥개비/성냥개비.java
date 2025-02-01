import java.io.*;

public class Main {
	public static int[] big = {-1, -1, 1, 7, 4, 2, 0, 8,10};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		long[] dp = new long[101];
		for (int i = 2; i < 9; i++) {
			dp[i] = big[i];
		}
		dp[6] = 6;
		
		for (int i = 9; i <= 100; i++) {
			dp[i] = dp[i - 2] * 10 + big[2];
			for (int j = 2; j < 8; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] * 10 + big[j]);
			}
		}

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			sb.append(dp[N]);
			sb.append(" ");

			StringBuilder max = new StringBuilder();
			int size = N/2;
			for (int i = 1; i < size; i++) {
				max.append("1");
			}
			if (N % 2 == 0) {
				sb.append(1).append(max);
			} else {
				sb.append(7).append(max);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}