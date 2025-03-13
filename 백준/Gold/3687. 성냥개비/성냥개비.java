import java.io.*;
import java.util.*;

public class Main {
	public static int[] data = {-1, -1, 1, 7, 4, 2, 0, 8, 10};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		long[] dp = new long[101];
		for (int i = 2; i < 9; i++) {
			dp[i] = data[i];
		}
		dp[6] = 6;

		for (int i = 9; i <= 100; i++) {
			dp[i] = dp[i - 2] * 10 + data[2];
			for (int j = 2; j < 8; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] * 10 + data[j]);
			}
		}

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());

			sb.append(dp[N]).append(" ");

			StringBuilder max = new StringBuilder();
			while (N > 0) {
				if (N == 3) {
					sb.append(7);
					break;
				}
				max.append(1);
				N -= 2;
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}