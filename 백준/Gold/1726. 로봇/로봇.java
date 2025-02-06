import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[][] data;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static int ex,ey, ed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int sx = Integer.parseInt(st.nextToken())-1;
		int sy = Integer.parseInt(st.nextToken())-1;
		int sd = Integer.parseInt(st.nextToken());
		sd = getDirection(sd);

		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken())-1;
		ey = Integer.parseInt(st.nextToken())-1;
		ed = Integer.parseInt(st.nextToken());
		ed = getDirection(ed);

		find(sx, sy, sd);

	}

	public static int getDirection(int d) {
		if (d == 1) {
			d = 0;
		} else if (d == 2) {
			d =2;
		} else if (d == 3) {
			d = 1;
		} else {
			d = 3;
		}

		return d;
	}

	public static void find(int x, int y, int d) {
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(x, y, d));
		boolean[][][] visited = new boolean[N][M][4];
		visited[x][y][d] = true;

		int cnt = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			// System.out.println("cnt = "+cnt);
			for (int s = 0; s < size; s++) {
				Data now = q.poll();
				// System.out.println(now);

				if (now.x == ex && now.y == ey && now.d == ed) {
					System.out.println(cnt);
					return;
				}

				for (int k = 1; k < 4; k++) {
					int nx = now.x + dx[now.d]*k;
					int ny = now.y + dy[now.d]*k;
					// if (now.x == 3 && now.y == 0) {
					// 	System.out.println("nx = "+nx +", ny = "+ny + ", d = "+now.d);
					// }

					if (check(nx, ny)) {
						if (!visited[nx][ny][now.d]) {
							visited[nx][ny][now.d] = true;
							q.offer(new Data(nx, ny, now.d));
						}
					} else {
						break;
					}
				}

				for (int i = 1; i <= 3; i += 2) {
					int nd = (now.d + i) % 4;

					if (!visited[now.x][now.y][nd]) {
						visited[now.x][now.y][nd] = true;
						q.offer(new Data(now.x, now.y, nd));
					}
				}
			}
			cnt++;
		}
	}

	public static boolean check(int x, int y) {
		if (x >= 0 && x < N && y >= 0 && y < M && data[x][y] == 0) {
			return true;
		}
		return false;
	}

	public static class Data{
		int x;
		int y;
		int d;

		public Data(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Data{" +
				"x=" + x +
				", y=" + y +
				", d=" + d +
				'}';
		}
	}
}