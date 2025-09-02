

import java.io.*;
import java.util.*;

public class Main {
	public static int N,K;
	public static double[][][] dp;
	public static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	public static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		double temp = 1;
		for(int i = 1; i <= K; i++){
			temp*=8;
		}

		dp = new double[N + 1][N + 1][K + 1];
		dp[x][y][0] = 1;

		for(int k = 0; k < K; k++){
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dp[i][j][k] > 0) {
						for (int d = 0; d < 8; d++) {
							int nx = i+dx[d];
							int ny = j + dy[d];
							if (nx > 0 && nx <= N && ny > 0 && ny <= N) {
								dp[nx][ny][k+1] +=dp[i][j][k];
							}
						}
					}
				}
			}
		}


		double cnt = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				cnt+=dp[i][j][K];
			}
		}

		
		System.out.println(cnt/temp);
	}

}
