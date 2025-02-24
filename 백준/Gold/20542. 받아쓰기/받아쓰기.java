import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[] data1 = br.readLine().toCharArray();
		char[] data2 = br.readLine().toCharArray();

		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= M; j++) {
			dp[0][j] = j;

		}

		for (int i = 1; i <= N; i++) {
			char a = data1[i-1];
			for (int j = 1; j <= M; j++) {
				char b = data2[j - 1];
				if (dp[i][j] == 0) {
					dp[i][j] = Integer.MAX_VALUE;
				}
				if (a == 'i' && (b == 'j' || b == 'l')) {
					b = 'i';
				} else if (a == 'v' && b == 'w') {
					b = 'v';
				}
				if (a == b) {
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
				} else {
					dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]))) + 1;
				}
			}
		}
		System.out.println(dp[N][M]);
	}
}