package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_2194_유닛이동시키기 {
	public static int N,M,A,B, K;
	public static boolean[][] data;
	public static int sx,sy, ex, ey;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		data = new boolean[N+1][M+1];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			data[x][y] = true; //벽
		}

		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		ex = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken());

		find();
	}

	public static void find() {
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(sx, sy, A, B));

		boolean[][] visited = new boolean[N+1][M+1];
		visited[sx][sy] = true;

		int cnt = 0;
		boolean flag = false;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Data now = q.poll();

				if (now.ulx == ex && now.uly == ey) {
					flag = true;
					break;
				}
				// System.out.println("now = "+now);
				for (int d = 0; d < 4; d++) {
					int nx = now.ulx+dx[d];
					int ny = now.uly+dy[d];

					Data next = new Data(nx, ny, A, B);
					// System.out.println("next = "+next);
					// System.out.println(next.isPossible(N,M));
					if (next.isPossible(N, M) && !visited[nx][ny]) {
						visited[nx][ny] = true;
						q.offer(next);
					}
				}
			}
			if (flag) {
				break;
			}
			cnt++;
		}
		if (flag) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}
	}

	public static class Data{
		int ulx, uly;
		int urx, ury;
		int dlx, dly;
		int drx, dry;

		public Data(int x, int y, int a, int b) {
			a--;
			b--;
			this.ulx = x;
			this.uly = y;
			this.urx = x;
			this.ury = y+b;
			this.dlx = x+a;
			this.dly = y;
			this.drx = x+a;
			this.dry = y+b;
		}

		public boolean isPossible(int n, int m) {
			if (check(ulx, uly, n, m) && check(urx, ury, n, m) && check(dlx, dly, n, m) && check(drx, dry, n, m)) {
				for (int i = ulx; i <= dlx; i++) {
					for (int j = uly; j <= ury; j++) {
						if (data[i][j]) {
							return false;
						}
					}
				}
				return true;
			}
			return false;
		}

		private boolean check(int x, int y, int n, int m) {
			if (x > 0 && x <= n && y > 0 && y <= m) {
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "Data{" +
				"ulx=" + ulx +
				", uly=" + uly +
				", urx=" + urx +
				", ury=" + ury +
				", dlx=" + dlx +
				", dly=" + dly +
				", drx=" + drx +
				", dry=" + dry +
				'}';
		}
	}
}
