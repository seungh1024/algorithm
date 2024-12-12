package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_1941_소문난칠공주 {
	public static char[][] data = new char[5][5];
	public static Point[] point;
	public static boolean[] visited;
	public static int result;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int idx = 0;
		point = new Point[25];
		for (int i = 0; i < 5; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < 5; j++) {
				data[i][j] = input[j];
				point[idx++] = new Point(i, j);
			}
		}

		result = 0;
		visited = new boolean[25];
		find(0,0);
		System.out.println(result);
	}

	public static void find(int idx, int cnt) {
		if (cnt == 7) {
			if (isTeam()) {
				result++;
			}
			return;
		}

		if (idx >= 25) {
			return;
		}

		visited[idx] = true;
		find(idx + 1, cnt + 1);
		visited[idx] = false;
		find(idx+1, cnt);
	}

	public static boolean isTeam() {
		int[][] check = new int[5][5];
		boolean flag = false;
		Queue<Point> q = new ArrayDeque<>();
		for (int i = 0; i < 25; i++) {
			if (visited[i]) {
				int x = point[i].x;
				int y = point[i].y;
				check[x][y] = 1;
				if (!flag) {
					q.offer(point[i]);
					flag = true;
					check[x][y] = 2;
				}
			}
		}


		int s = 0;
		int y = 0;
		while (!q.isEmpty()) {
			Point now = q.poll();

			if (data[now.x][now.y] == 'S') {
				s++;
			} else {
				y++;
			}

			for (int d = 0; d < 4; d++) {
				int nx = now.x+dx[d];
				int ny = now.y+dy[d];
				if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && check[nx][ny] == 1) {
					check[nx][ny] = 2;
					q.offer(new Point(nx, ny));
				}
			}
		}

		if (s >= 4 && s+y == 7) {
			// for (int i = 0; i < 5; i++) {
			// 	System.out.println(Arrays.toString(check[i]));
			// }
			// System.out.println("====");
			return true;
		}

		return false;
	}

	public static class Point{
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
}
