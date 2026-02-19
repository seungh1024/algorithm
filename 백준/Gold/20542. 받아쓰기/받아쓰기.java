

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

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
			char c1 = data1[i-1];
			for (int j = 1; j <= M; j++) {
				char c2 = data2[j-1];
				if (c1 == 'i' && (c2 == 'j' || c2 == 'l')) {
					c2 = 'i';
				} else if (c1 == 'v' && c2 == 'w') {
					c2 = 'v';
				}

				if (c1 == c2) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					int min = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
					dp[i][j] = min + 1;
				}
			}
			// System.out.println("i= " + i);
			// System.out.println(Arrays.toString(dp[i]));
		}

		System.out.println(dp[N][M]);


	}
}
