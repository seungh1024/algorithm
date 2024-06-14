package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_17069_파이프옮기기2 {
	public static int N;
	public static int[][] data;
	public static long[][][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] == 1) {
					data[i][j] = -1;
				}
			}
		}

		dp = new long[N][N][3]; //0 = 가로, 1 = 세로, 2 = 대각선
		dp[0][1][0] = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(data[i][j] == -1 ) continue;
				if (dp[i][j][0] > 0) { // 가로인 경우
					if (j + 1 < N && data[i][j+1] != -1) { // 가로 이동
						dp[i][j+1][0] += dp[i][j][0];
						if (i + 1 < N && data[i+1][j+1] != -1 && data[i+1][j] != -1 && data[i][j+1] != -1) { // 대각선 이동
							dp[i+1][j+1][2] += dp[i][j][0];
						}
					}
				}
				if (dp[i][j][1] > 0) { // 세로인 경우
					if (i + 1 < N && data[i+1][j] != -1) {
						dp[i+1][j][1] += dp[i][j][1];
						if (j + 1 < N && data[i+1][j+1] != -1 && data[i+1][j] != -1 && data[i][j+1] != -1) {
							dp[i+1][j+1][2] += dp[i][j][1];
						}
					}
				}
				if (dp[i][j][2] > 0) { // 대각인 경우
					if (j + 1 < N && data[i][j+1] != -1) {
						dp[i][j+1][0] += dp[i][j][2];
					}
					if (i + 1 < N && data[i+1][j] != -1) {
						dp[i+1][j][1] += dp[i][j][2];
					}
					if (i + 1 < N && j + 1 < N && data[i+1][j+1] != -1 && data[i+1][j] != -1 && data[i][j+1] != -1) {
						dp[i+1][j+1][2] += dp[i][j][2];
					}
				}
			}
		}

		// StringBuilder sb = new StringBuilder();
		// sb.append("======== 가로 ==========").append("\n");
		// for (int i = 0; i < N; i++) {
		// 	for (int j = 0; j < N; j++) {
		// 		sb.append(dp[i][j][0]).append(" ");
		// 	}
		// 	sb.append("\n");
		// }
		// sb.append("========= 세로 ==========").append("\n");
		// for (int i = 0; i < N; i++) {
		// 	for (int j = 0; j < N; j++) {
		// 		sb.append(dp[i][j][1]).append(" ");
		// 	}
		// 	sb.append("\n");
		// }
		// sb.append("======== 대각 ===========").append("\n");
		// for (int i = 0; i < N; i++) {
		// 	for (int j = 0; j < N; j++) {
		// 		sb.append(dp[i][j][2]).append(" ");
		// 	}
		// 	sb.append("\n");
		// }
		// System.out.println(sb);
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}
}
