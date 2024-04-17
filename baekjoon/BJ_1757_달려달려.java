package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_1757_달려달려 {
	public static int N,M;
	public static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N+1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[M+1][N+1];
		dp[1][1] = data[0];

		for (int j = 0; j < N; j++) {
			for (int i = 0; i <= M; i++) {
				if (i >= 0 && i < M) { // 쉬거나 달리는 경우
					// if (dp[i][j] == 9) {
					// 	System.out.println("i = "+i + ", j ="+j);
					// }
					if(i == 0){
						dp[0][j+1] = Math.max(dp[0][j+1],dp[i][j]);
					}
					else if(j + i <= N){
						// if (dp[i][j] == 9) {
						// 	System.out.println("i = " + i + ", j = " + j);
						// 	System.out.println(dp[0][i+j]);
						// }
						dp[0][j+i] = Math.max(dp[0][j+i],dp[i][j]); // 쉬는 경우
					}


					dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + data[j+1]);
				} else if (i == M) { // 쉬어아먄 하는 경우
					if (j + i <= N) {
						dp[0][j+i] = Math.max(dp[0][j+i],dp[i][j]);
					}
				}
			}
		}
		// for (int i = 0; i <= M; i++) {
		// 	System.out.println(Arrays.toString(dp[i]));
		// }
		System.out.println(dp[0][N]);
	}
}
