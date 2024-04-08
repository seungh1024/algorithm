package algo_202403;

import java.util.*;
import java.io.*;

public class BJ_14923_미로탈출 {
	public static int N,M;
	public static int Hx,Hy;
	public static int Ex,Ey;
	public static int[][] data;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Hx = Integer.parseInt(st.nextToken());
		Hy = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Ex = Integer.parseInt(st.nextToken());
		Ey = Integer.parseInt(st.nextToken());

		data = new int[N+1][M+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Point> pq = new PriorityQueue<>();
		pq.offer(new Point(Hx, Hy, 0,true));
		boolean[][][] visited = new boolean[N+1][M+1][2];
		visited[Hx][Hy][0] = true;
		visited[Hx][Hy][1] = true;

		int result = -1;
		while (!pq.isEmpty()) {
			Point now = pq.poll();
			// System.out.println(now);
			if (now.x == Ex && now.y == Ey) {
				result = now.count;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = now.x+dx[d];
				int ny = now.y+dy[d];
				if (nx > 0 && nx <= N && ny > 0 && ny <= M) {
					if (now.magic) {
						if (!visited[nx][ny][0] && data[nx][ny] == 0) {
							pq.offer(new Point(nx, ny, now.count + 1, now.magic));
							visited[nx][ny][0] = true;
						} else if (!visited[nx][ny][1] && data[nx][ny] == 1) {
							pq.offer(new Point(nx, ny, now.count + 1, false));
							visited[nx][ny][1] = true;
						}
					} else {
						if (!visited[nx][ny][1] && data[nx][ny] == 0) {
							pq.offer(new Point(nx, ny, now.count + 1, false));
							visited[nx][ny][1] = true;
						}
					}
				}
			}
		}

		System.out.println(result);

	}

	public static class Point implements Comparable<Point> {
		int x;
		int y;
		int count;
		boolean magic;

		public Point(int x, int y, int count, boolean magic) {
			this.x=x;
			this.y=y;
			this.count = count;
			this.magic = magic;
		}

		@Override
		public int compareTo(Point point) {
			return this.count - point.count;
		}

		@Override
		public String toString() {
			return "x = " + x + ", y = "+ y +", count = " + count;
		}

	}

}
