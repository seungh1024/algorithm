package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_4781_사탕가게 {
	public static int N;
	public static int M;
	public static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			String[] split = st.nextToken().split("\\.");
			// System.out.println(Arrays.toString(split));
			M = Integer.parseInt(split[0])*100 + Integer.parseInt(split[1]);
			if(N == 0 && M == 0){
				System.out.println(sb);
				return;
			}

			dp = new int[10001];
			Data[] data = new Data[N+1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int cal = Integer.parseInt(st.nextToken());
				split = st.nextToken().split("\\.");
				int cost = Integer.parseInt(split[0])*100 + Integer.parseInt(split[1]);
				data[i] = new Data(cal, cost);
			}
			// System.out.println(Arrays.toString(data));

			for (int i = 1; i <= N; i++) {
				Data now = data[i];
				for (int j = 1; j <= M; j++) {
					if (now.cost <= j) {
						dp[j] = Math.max(dp[j], dp[j - now.cost] + now.cal);
					}
					dp[j] = Math.max(dp[j], dp[j-1]);
				}
			}

			sb.append(dp[M]).append("\n");
		}
	}

	public static class Data{
		int cal;
		int cost;

		public Data(int cal, int cost){
			this.cal = cal;
			this.cost = cost;
		}

		public String toString() {
			return "cal = "+cal +", cost = "+cost;
		}
	}
}
