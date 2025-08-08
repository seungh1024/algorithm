

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] dp = new int[27][K];
		
		for (int i = 0; i < N; i++) {
			int max = 0;

			char[] data = br.readLine().toCharArray();
			for (int j = 0; j < K; j++) {
				dp[data[j]-'a'][j]++;
				max = Math.max(max, dp[data[j] - 'a'][j]);
			}
			for (int j = 0; j < K; j++) {
				dp[data[j]-'a'][j] = max;
			}
		}
		
		int result = 0;
		for (int i = 0; i < 27; i++) {
			for (int j = 0; j < K; j++) {
				result = Math.max(dp[i][j], result);
			}
		}

		System.out.println(N-result);
		
	}
}
