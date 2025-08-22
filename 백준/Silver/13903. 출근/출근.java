

import java.io.*;
import java.util.*;

public class Main {
	public static int R, C;
	public static int[][] data;
	public static int N;
	public static int[] dx;
	public static int[] dy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		N = Integer.parseInt(br.readLine());
		dx = new int[N];
		dy = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			dx[i] = x;
			dy[i] = y;
		}

		find();
	}
	public static void find() {
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visited = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		for (int j = 0; j < C; j++) {
			if (data[0][j] == 1) {
				visited[0][j] = 0;
				q.offer(new int[] {0, j});
			}
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int d = 0; d < N; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if (nx >= 0 && nx < R && ny >= 0 && ny < C && data[nx][ny] == 1
					&& visited[nx][ny] > visited[now[0]][now[1]] + 1) {
					visited[nx][ny] = visited[now[0]][now[1]] + 1;
					q.offer(new int[] {nx, ny});
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int j = 0; j < C; j++) {
			if (visited[R - 1][j] != Integer.MAX_VALUE) {
				min = Math.min(min, visited[R - 1][j]);
			}
		}
		if (min == Integer.MAX_VALUE) {
			min = -1;
		}

		System.out.println(min);
	}
}
