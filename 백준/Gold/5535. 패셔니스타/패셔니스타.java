

import java.io.*;
import java.util.*;

public class Main {
	public static int D, N;
	public static int[] T;
	public static int[][] dp;
	public static Data[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		T = new int[D+1];
		for (int i = 1; i <= D; i++) {
			T[i] = Integer.parseInt(br.readLine());
		}

		data = new Data[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			data[i] = new Data(a, b, c);
		}

		dp = new int[D+1][101];
		for (int i = 0; i <= D; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 1; i <= N; i++) {
			Data d = data[i];
			if (d.a <= T[1] && T[1] <= d.b) {
				dp[1][d.c] = 0;
			}
		}
		for (int i = 2; i <= D; i++) {
			for (int j = 1; j <= N; j++) {
				Data d = data[j];
				if(d.a > T[i] || d.b < T[i]) continue;

				for (int k = 0; k <= 100; k++) {
					if (dp[i - 1][k] != -1) {
						dp[i][d.c] = Math.max(dp[i][d.c], dp[i - 1][k] + Math.abs(k - d.c));
					}
				}
			}
		}

		int max = 0;
		for (int i = 0; i <= 100; i++) {
			max = Math.max(max, dp[D][i]);
		}

		System.out.println(max);
	}

	public static class Data{
		int a;
		int b;
		int c;

		@Override
		public String toString() {
			return "Data{" +
				"a=" + a +
				", b=" + b +
				", c=" + c +
				'}';
		}

		public Data(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}
