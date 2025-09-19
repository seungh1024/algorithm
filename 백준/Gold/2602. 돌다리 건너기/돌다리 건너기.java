

import java.io.*;
import java.util.*;

public class Main {
	public static char[] data;
	public static char[][] bridge;
	public static int N, M;
	public static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = br.readLine().toCharArray();
		char[] up = br.readLine().toCharArray();
		char[] down = br.readLine().toCharArray();
		N = up.length;
		M = data.length;

		bridge = new char[2][N];
		bridge[0] = up;
		bridge[1] = down;

		dp = new int[2][N][M];



		for (int i = 0; i < N; i++) {
			if (data[0] == bridge[0][i]) {
				dp[0][i][0] = 1;
			}
			if (data[0] == bridge[1][i]) {
				dp[1][i][0] = 1;
			}
			for (int j = 1; j < M; j++) {
				for (int p = 0; p < 2; p++) {

					if (bridge[p][i] == data[j]) {
						int cnt = 0;
						int q = (p+1)%2;
						for (int k = 0; k < i; k++) {
							cnt += dp[q][k][j - 1];
						}
						dp[p][i][j] = cnt;
					}
				}


			}
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += dp[0][i][M - 1];
			sum += dp[1][i][M - 1];
		}
		System.out.println(sum);
	}
}
