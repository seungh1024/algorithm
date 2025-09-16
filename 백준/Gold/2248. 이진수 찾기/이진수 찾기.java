

import java.io.*;
import java.util.*;

public class Main {
	public static int N,L;
	public static long I;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		I = Long.parseLong(st.nextToken());

		long[][] dp = new long[32][32];
		dp[0][0] = 1;
		for (int i = 1; i < N; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <=N; j++) {
				dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
				// dp[i+1][j+1] += dp[i][j];
				// dp[i+1][j] += dp[i][j];
			}
			// System.out.println(Arrays.toString(dp[i]));
		}

		String s = "";
		for (int i = N-1; i >= 0; i--) {
			long sum = 0;
			for (int j = 0; j <= L; j++) {
				sum += dp[i][j];
			}

			if (sum < I) {
				s += 1;
				L--;
				I-=sum;
			} else {
				s+=0;

			}
		}
		System.out.println(s);
	}
}
