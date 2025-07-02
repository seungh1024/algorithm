

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int T;
	public static boolean[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = Integer.parseInt(br.readLine());
		data = new boolean[N+1][21];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				int h = Integer.parseInt(st.nextToken());
				data[i][h] = true;
			}
			// System.out.println(Arrays.toString(data[i]));
		}

		find();
	}

	public static void find() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][][] visited = new boolean[N + 1][21][T+1];
		q.offer(new int[] {0,1, 0}); // {x,y,T}

		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int t = now[2];

			if (x == N) {
				min = Math.min(min, t);
				continue;
			}
			// System.out.println("x = "+x +", y = "+y + ", t = "+t);

			if (data[x + 1][y] && !visited[x + 1][y][t]) {
				visited[x+1][y][t] = true;
				q.offer(new int[] {x + 1, y, t});
			}
			if (y + 1 <= 20 && data[x + 1][y + 1] && !visited[x + 1][y + 1][t]) {
				visited[x + 1][y + 1][t] = true;
				q.offer(new int[] {x + 1, y + 1, t});
			}
			if (y - 1 > 0 && data[x + 1][y - 1] && !visited[x + 1][y - 1][t]) {
				visited[x + 1][y - 1][t] = true;
				q.offer(new int[] {x + 1, y - 1, t});
			}
			if (y < 10 && y * 2 <= 20 && data[x + 1][y * 2] && !visited[x + 1][y * 2][t]) {
				visited[x + 1][y * 2][t] = true;
				q.offer(new int[] {x + 1, y * 2, t});
			}
			if (y >= 10 && data[x + 1][20] && !visited[x + 1][20][t]) {
				visited[x+1][20][t] = true;
				q.offer(new int[] {x + 1, 20, t});
			}
			if (t + 1 <= T) {

				for (int j = 1; j <= 20; j++) {
					if (data[x + 1][j] && !visited[x + 1][j][t + 1]) {
						visited[x + 1][j][t + 1] = true;
						q.offer(new int[] {x + 1, j, t + 1});
					}
				}
			}
		}
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}
		System.out.println(min);
	}
}
