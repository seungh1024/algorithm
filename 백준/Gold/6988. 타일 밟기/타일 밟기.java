

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] temp = new int[1_000_001];
		Arrays.fill(temp, -1);
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			temp[data[i]] = i;
		}

		long[][] dp = new long[N][N];

		long result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int idx = -1;
				long v = data[i] - (data[j] - data[i]);
				if (v >= 0) {
					idx = temp[(int)v];
				}
				if (idx == -1) {
					dp[i][j] = data[i] + data[j];
				} else {
					dp[i][j] = dp[idx][i] + data[j];
					result = Math.max(result, dp[i][j]);
				}
			}
		}

		System.out.println(result);


	}
}
