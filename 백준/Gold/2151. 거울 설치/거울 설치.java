import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static char[][] data;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static int sx,sy,ex, ey;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		data = new char[N][N];
		boolean flag = false;
		for (int i = 0; i < N; i++) {
			data[i] = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (data[i][j] == '#') {
					if (!flag) {
						sx = i;
						sy = j;
						flag = true;
					} else {
						ex = i;
						ey = j;
					}
				}
			}
		}

		find();

	}

	public static void find() {
		Queue<Data> q = new ArrayDeque<>();
		int[][][] visited = new int[N][N][4];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(visited[i][j], Integer.MAX_VALUE);
			}
		}
		for (int d = 0; d < 4; d++) {
			q.offer(new Data(sx, sy, d));
			visited[sx][sy][d] = 0;
		}



		int result = Integer.MAX_VALUE;
		while(!q.isEmpty()) {

			Data now = q.poll();

			if (now.x == ex && now.y == ey) {
				result = Math.min(result, now.cnt);
				continue;
			}

			int nx = now.x + dx[now.d];
			int ny = now.y + dy[now.d];
			if (nx >= 0 && nx < N && ny >= 0 && ny < N && data[nx][ny] != '*' && visited[nx][ny][now.d] > now.cnt) {
				visited[nx][ny][now.d] = now.cnt;
				q.offer(new Data(nx, ny, now.d, now.cnt));
			}

			if (data[now.x][now.y] == '!') {
				int cnt = now.cnt+1;
				for (int i = 1; i < 4; i += 2) {
					int nd = (now.d + i) % 4;
					nx = now.x + dx[nd];
					ny = now.y + dy[nd];

					if (nx >= 0 && nx < N && ny >= 0 && ny < N && data[nx][ny] != '*' && visited[nx][ny][nd] > cnt) {
						visited[nx][ny][nd] = cnt;
						q.offer(new Data(nx, ny, nd, cnt));
					}
				}
			}
		}

		System.out.println(result);
	}

	public static class Data{
		int x;
		int y;
		int d;
		int cnt;

		public Data(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		public Data(int x, int y, int d, int cnt) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
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