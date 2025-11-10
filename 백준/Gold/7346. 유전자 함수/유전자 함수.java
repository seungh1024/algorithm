

import java.io.*;
import java.util.*;

public class Main {
	public static int[][] score = {
		{5, -1, -2, -1, -3},
		{-1,5,-3,-2,-4},
		{-2,-3,5,-2,-2},
		{-1,-2,-2,5,-1},
		{-3,-4,-2,-1,0}
	};
	public static Map<Character,Integer> map = Map.of('A',0,'C',1,'G',2,'T',3);
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[] A = st.nextToken().toCharArray();
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			char[] B = st.nextToken().toCharArray();
			int[][] dp = new int[N+1][M+1];


			for (int i = 1; i <= N; i++) {
				dp[i][0] = dp[i-1][0] +score[map.get(A[i-1])][4];
			}
			for (int j = 1; j <= M; j++) {
				dp[0][j] = dp[0][j-1]+score[4][map.get(B[j-1])];
			}

			for (int i = 1; i <= N; i++) {
				int a = map.get(A[i - 1]);
				for (int j = 1; j <= M; j++) {
					int b = map.get(B[j- 1]);

					int x = dp[i-1][j-1] + score[a][b];
					int y = dp[i-1][j] + score[a][4];
					int z = dp[i][j-1] + score[4][b];

					dp[i][j] = Math.max(x, Math.max(y, z));

				}
			}

			sb.append(dp[N][M]).append("\n");

		}
		System.out.println(sb);
	}
}
