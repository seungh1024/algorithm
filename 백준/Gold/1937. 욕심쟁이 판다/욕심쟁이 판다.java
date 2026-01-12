

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] data;
	public static int[][] dp;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(dp[i][j] != -1) continue;
				// System.out.println("======" + ", i = "+i +", j = "+j);
				result = Math.max(result, find(i, j, 1));
			}
		}

		System.out.println(result);
	}

	public static int find(int x, int y, int cnt) {
		// System.out.println("x = "+x + ", y = "+y + ", cnt = "+cnt +", dp = "+dp[x][y]);
		if(dp[x][y] != -1) return dp[x][y];

		int max = 1;
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && data[nx][ny] > data[x][y]) {
				max = Math.max(max, find(nx, ny, cnt + 1)+1);
			}
		}

		return dp[x][y] = max;


	}

}
