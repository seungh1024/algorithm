

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] W = new int[N];
		int[] V = new int[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[1000001];

		for (int i = 0; i < N; i++) {
			int w = W[i];
			int v = V[i];
			for (int j = 1000000; j > 0; j--) {
				if (j - w >= 0) {
					dp[j] = Math.max(dp[j], dp[j - w] + v);
				}
				dp[j] = Math.max(dp[j], dp[j - 1]);
			}
		}
		int idx = 1;
		double result = 0;
		for (int m = 1; m <= M; m++) {
			int K = Integer.parseInt(br.readLine());

			int max = 0;
			for (int i = 0; i <= K; i++) {
				max = Math.max(max, dp[i]);
			}
			// System.out.println("K = "+K + ", max = "+max);
			// System.out.println(Arrays.toString(dp));

			double temp = (double)max/(double)K;
			if (temp > result) {
				idx = m;
				result = temp;
			}
			// System.out.println("m = "+m + ", idx = "+idx + ", temp = "+temp);
		}
		System.out.println(idx);
	}
}
