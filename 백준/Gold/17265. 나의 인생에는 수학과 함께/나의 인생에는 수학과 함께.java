

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] data = new char[N+2][N+2];
		for (int i = 2; i < N+2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 2; j < N+2; j++) {
				data[i][j] = st.nextToken().charAt(0);
			}
		}
		int[][][] dp = new int[N + 2][N + 2][2];
		for (int i = 2; i < N + 2; i++) {
			for (int j = 2; j < N + 2; j++) {
				if ((i + j) % 2 == 0) {
					dp[i][j][0] = data[i][j] - '0';
					dp[i][j][1] = dp[i][j][0];
				}
			}
		}


		for (int i = 2; i < N + 2; i++) {
			for (int j = 2; j < N + 2; j++) {
				if (!(i==2 && j == 2)&& (i+j)%2 == 0) {
					// System.out.println(data[i][j]);
					int now = data[i][j] - '0';
					int a = Integer.MIN_VALUE;
					int b = Integer.MIN_VALUE;
					int c = Integer.MIN_VALUE;
					int d = Integer.MIN_VALUE;
					int A = Integer.MAX_VALUE;
					int B = Integer.MAX_VALUE;
					int C = Integer.MAX_VALUE;
					int D = Integer.MAX_VALUE;
					if (i - 2 >= 2) {
						a = calc(dp[i - 2][j][0], now, data[i - 1][j]);
						A = calc(dp[i - 2][j][1], now, data[i - 1][j]);
					}
					if (i - 1 >= 2 && j - 1 >= 2) {
						b = calc(dp[i - 1][j - 1][0], now, data[i - 1][j]);
						B = calc(dp[i - 1][j - 1][1], now, data[i - 1][j]);
						c = calc(dp[i - 1][j - 1][0], now, data[i][j - 1]);
						C = calc(dp[i - 1][j - 1][1], now, data[i][j - 1]);
					}
					if (j - 2 >= 2) {
						d = calc(dp[i][j - 2][0], now, data[i][j - 1]);
						D = calc(dp[i][j - 2][1], now, data[i][j - 1]);

					}
					// if (i == 2 && j == 4) {
					// 	System.out.println("a = " + a + ", b=  " + b + ", c = " + c + ", d = " + d);
					// }
					dp[i][j][0] = Math.max(Math.max(a, b), Math.max(c, d));
					dp[i][j][1] = Math.min(Math.min(A, B), Math.min(C, D));
				}
			}
		}

		System.out.println(dp[N + 1][N + 1][0] +" " + dp[N+1][N+1][1]);

	}

	public static int calc(int a, int b, char c) {
		int result = 0;
		if (c == '+') {
			result = a + b;
		} else if (c == '-') {
			result = a - b;
		} else if (c == '*') {
			result = a * b;
		}

		return result;
	}
}
