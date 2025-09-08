

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static char[][] data;
	public static int[] dx = {1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new char[N + 1][M + 1];
		int x = 0;
		int y = 0;
		for (int i = 1; i <= N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				data[i][j] = input[j-1];
				if (data[i][j] == 'R') {
					x= i;
					y = j;

				}
			}
		}

		int[][] dp = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dp[i], -1);
		}
		dp[x][y] = 0;
		for (int j = 1; j <= M; j++) {
			for (int i = 1; i <= N; i++) {
				if (data[i][j] == '#' || dp[i][j] == -1) {
					continue;
				}
				if (data[i][j] == 'C') {
					dp[i][j]++;
				}
				for (int d = 0; d < 3; d++) {
					int nx = i+dx[d];
					int ny = j + 1;
					if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
						dp[nx][ny] = Math.max(dp[nx][ny], dp[i][j]);
					}
				}
			}
		}

		int max = -1;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (data[i][j] == 'O') {
					max = Math.max(max, dp[i][j]);
				}
			}
			// System.out.println(Arrays.toString(dp[i]));
		}
		System.out.println(max);
	}
}
