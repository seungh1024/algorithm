

import java.io.*;
import java.util.*;

public class Main {
	public static int R, C;
	public static char[][] data;
	public static int sx, sy;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new char[R][C];

		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				data[i][j] = input[j];
				if (data[i][j] == 'J') {
					sx = i;
					sy = j;
					data[i][j] = '.';
				}
			}
		}

		int result = find();
		if (result == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(result);
		}

	}

	public static int find() {
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(sx, sy));
		boolean[][] visited = new boolean[R][C];
		visited[sx][sy] = true;

		Queue<Data> f = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (data[i][j] == 'F') {
					f.offer(new Data(i, j));
				}
			}
		}

		int time = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Data now = q.poll();

				if(data[now.x][now.y] == 'F') continue;

				if (now.x == 0 || now.x == R - 1 || now.y == 0 || now.y == C - 1) {
					return time+1;
				}

				for (int d = 0; d < 4; d++) {
					int nx = now.x+dx[d];
					int ny = now.y + dy[d];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny] && data[nx][ny] == '.') {
						visited[nx][ny] = true;
						q.offer(new Data(nx, ny));
					}
				}
			}

			size = f.size();
			for (int s = 0; s < size; s++) {
				Data now = f.poll();

				for (int d = 0; d < 4; d++) {
					int nx = now.x+dx[d];
					int ny = now.y+dy[d];

					if (nx >= 0 && nx < R && ny >= 0 && ny < C && data[nx][ny] == '.') {
						data[nx][ny] = 'F';
						f.offer(new Data(nx, ny));
					}
				}
			}
			time++;
		}

		return -1;
	}

	public static class Data{
		int x;
		int y;

		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
