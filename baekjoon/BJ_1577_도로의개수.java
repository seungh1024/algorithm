package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_1577_도로의개수 {
	public static int N,M,K;
	public static long[][] dp;
	// public static boolean[][][][] check;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dp = new long[N+1][M+1];
		// check = new boolean[N+1][M+1][N+1][M+1];

		K = Integer.parseInt(br.readLine());
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if (a < c || b < d) {
				list.add(new int[] {a, b, c, d});
			} else {
				list.add(new int[] {c, d, a, b});
			}
			// check[a][b][c][d] = true;
			// check[c][d][a][b] = true;
		}

		dp[0][0] = 1;
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= M; j++) {
				boolean flag1 = false;
				boolean flag2 = false;
				for (int[] l : list) {
					if (l[0] == i && l[1] == j && l[2] == i + 1 && l[3] == j) {
						flag1 = true;
					} else if (l[0] == i && l[1] == j && l[2] == i && l[3] == j + 1) {
						flag2 = true;
					}
				}
				if (i + 1 <= N &&!flag1) {
					dp[i+1][j] += dp[i][j];
				}
				if(j + 1 <= M &&!flag2){
					dp[i][j+1] += dp[i][j];
				}
			}
		}
		System.out.println(dp[N][M]);
	}
}
