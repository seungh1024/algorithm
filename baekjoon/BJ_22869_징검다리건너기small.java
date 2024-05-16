package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_22869_징검다리건너기small {
	public static int N,K;
	public static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i < N; i++) {
			int jump = i * (1 + Math.abs(data[i] - data[0]));
			dp[i] = Math.min(dp[i], jump);
		}

		// System.out.println(Arrays.toString(dp));
		for (int i = 1; i < N; i++) {
			if(dp[i] > K) continue;
			for (int j = i + 1; j < N; j++) {
				int jump = (j - i) * (1 + Math.abs(data[j] - data[i]));
				// System.out.println("i = " + i + ", j = "+ j + ", jump = "+jump);
				dp[j] = Math.min(dp[j], jump);
			}
		}
		// System.out.println(Arrays.toString(dp));
		if (dp[N - 1] <= K) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
