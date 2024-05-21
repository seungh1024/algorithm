package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_2229_조짜기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] data = new int[N+1];

		for (int i = 1; i <= N; i++) {
			int input = Integer.parseInt(st.nextToken());
			data[i] = input;
			int min = 10001;
			int max = 0;
			for (int j = i; j > 0; j--) {
				min = Math.min(min, data[j]);
				max = Math.max(max, data[j]);
				dp[i] = Math.max(dp[i], dp[j-1] + max - min);

			}
		}
		System.out.println(dp[N]);
	}
}
