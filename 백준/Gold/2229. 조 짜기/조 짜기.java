

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int max = data[i];
			int min = data[i];
			for (int j = i + 1; j <= N; j++) {

				max = Math.max(max, data[j]);
				min = Math.min(min, data[j]);
				dp[j] = Math.max(dp[j], dp[i - 1] + max - min);
			}
		}
		System.out.println(dp[N]);
	}
}
