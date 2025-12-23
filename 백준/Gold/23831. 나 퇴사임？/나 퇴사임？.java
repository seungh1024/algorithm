

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int A, B;
	public static int[][] data;
	public static int[][][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		data = new int[N][4];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][2][A+1][101];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k <= A; k++) {
					Arrays.fill(dp[i][j][k], -1);
				}
			}
		}

		int result = find(0, 0, 0,  0);
		System.out.println(result);

	}

	public static int find(int idx, int a, int b, int flag) {
		// System.out.println("idx = "+idx +", a = "+a +", b = "+b + ", score = "+score + ", last = "+last);
		if (idx >= N) {
			if (b >= B) {
				return 0;
			}
			return -100000;
		}

		// System.out.println(dp[idx][a][b]);
		if( dp[idx][flag][a][b]!= -1) {
			return dp[idx][flag][a][b];
		}
		// dp[idx][a][b] = score;

		// System.out.println("?");
		int max = -100000;
		max = Math.max(max, find(idx + 1, a, b + 1, 0) + data[idx][0]);
		max = Math.max(max, find(idx + 1, a, b + 1 , 0)+ data[idx][1]);
		if (flag == 0) {
			max = Math.max(max, find(idx + 1, a, b, 1)+ data[idx][2]);
		}
		if (a + 1 <= A) {
			max = Math.max(max, find(idx + 1, a+1, b  , 0)+ data[idx][3]);
		}

		return dp[idx][flag][a][b] = max;
	}
}
