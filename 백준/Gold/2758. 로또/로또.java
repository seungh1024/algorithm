import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[][] dp = new long[11][2001];
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= 2000; j++) {
				if(dp[i][j] == 0) continue;
				int x = j*2;
				for (int k = x; k <= 2000; k++) {
					dp[i + 1][k] += dp[i][j];
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			long result = 0;
			for (int i = 1; i <= m; i++) {
				result += dp[n][i];
			}
			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}