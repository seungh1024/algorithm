

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static char[][] data;
	public static int sx, sy;
	public static int[] dx = {0, 1, -1};
	public static int[] dy = {1, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new char[N][M];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				data[i][j] = input[j];
				if (data[i][j] == 'R') {
					data[i][j] = '.';
					sx = i;
					sy = j;
				}
			}
		}

		int[][] dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], Integer.MIN_VALUE);
		}
		dp[sx][sy] = 0;
		for (int j = 0; j < M; j++) {
			for (int i = 0; i < N; i++) {
				if (dp[i][j] >= 0) {
					for (int d = 0; d < 3; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
							if (data[nx][ny] == 'C') {
								dp[nx][ny] = Math.max(dp[nx][ny],dp[i][j]+1);
							} else if (data[nx][ny] != '#') {
								dp[nx][ny] = Math.max(dp[nx][ny], dp[i][j]);
							}
						}
					}
				}
			}
		}

		int result = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (data[i][j] == 'O') {

					result = Math.max(result, dp[i][j]);
				}
			}
		}

		System.out.println(result);
	}
}
