package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_2665_미로만들기 {
	public static int N;
	public static int[][] data;
	public static int w;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];

		w = 0;
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				data[i][j] = input[j] - '0';
				if (data[i][j] == 0) {
					w++;
				}
			}
		}

		find();
	}

	public static void find() {
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(0, 0, 0));
		boolean[][][] visited = new boolean[N][N][w+1];
		visited[0][0][0] = true;

		int result = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Data now = q.poll();
			// System.out.println(now);
			if (now.x == N - 1 && now.y == N - 1) {
				result = Math.min(result, now.wall);
				continue;
			}

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
					if (data[nx][ny] == 0 && now.wall+1 <=w && !visited[nx][ny][now.wall + 1]) { // 검은 방인 경우
						visited[nx][ny][now.wall + 1] = true;
						q.offer(new Data(nx, ny, now.wall + 1));
					} else if(data[nx][ny] == 1 && !visited[nx][ny][now.wall]) {
						visited[nx][ny][now.wall] = true;
						q.offer(new Data(nx, ny, now.wall));
					}
				}
			}
		}

		System.out.println(result);
	}

	public static class Data{
		int x;
		int y;
		int wall;

		public Data(int x, int y, int wall) {
			this.x = x;
			this.y = y;
			this.wall = wall;
		}

		@Override
		public String toString() {
			return "Data{" +
				"x=" + x +
				", y=" + y +
				", wall=" + wall +
				'}';
		}
	}
}
