

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[N+1];
		dp[N-1] = 0;

		// System.out.println(Arrays.toString(data));
		for (int i = N - 2; i >= 0; i--) {

			int sum = 0;
			for (int j = i; j < N; j++) {
				if (j == i) {
					sum += data[j];
				} else {
					sum += data[j]+1;
				}
				if(sum > M) break;

				int v = M-sum;
				if (dp[i] == 0) {
					dp[i] = v * v + dp[j + 1];
				} else {
					dp[i] = Math.min(dp[i], v * v + dp[j + 1]);
				}
				if (j == N - 1) {
					dp[i] = 0;
				}
				// System.out.println("i = "+i + ", j = "+j + ", v = "+v);
			}
		}

		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[0]);
	}

}
