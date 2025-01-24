import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			sum += data[i];
		}

		boolean[][] dp = new boolean[sum + 1][sum + 1];
		dp[0][0] = true;

		for (int k = 1; k <= N; k++) {
			for (int i = sum; i >= 0; i--) {
				for (int j = sum; j >= 0; j--) {
					if (i - data[k] >= 0) {
						dp[i][j] |= dp[i-data[k]][j];
					}
					if (j - data[k] >= 0) {
						dp[i][j] |= dp[i][j - data[k]];
					}
				}
			}
		}

		int result = 0;

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= sum; j++) {
				int value = sum - i - j;
				if (dp[i][j] && value <= i && value <= j) {
					result = Math.max(result, value);
				}
			}
		}
		System.out.println(result);

	}
}