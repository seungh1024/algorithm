package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_2151_거울설치 {
	public static int N;
	public static char[][] data;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static int sx, sy;

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new char[N][N];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				data[i][j] = input[j];
				if (input[j] == '#') {
					sx = i;
					sy = j;
				}
			}
		}

		find();
	}

	public static void find() {
		int[][][] visited = new int[N][N][4];
		Queue<Data> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(visited[i][j],Integer.MAX_VALUE);
			}
		}
		for (int d = 0; d < 4; d++) {
			q.offer(new Data(sx, sy, d, 0));
			visited[sx][sy][d] = 0;
		}

		int result = Integer.MAX_VALUE;
		while(!q.isEmpty()) {
			Data now = q.poll();

			// System.out.println(now);

			int nx = now.x + dx[now.d];
			int ny = now.y + dy[now.d];
			// System.out.println("nx = "+nx + ", ny = "+ny);

			if(nx < 0 || nx >= N|| ny < 0 || ny >= N || data[nx][ny] == '*' || visited[nx][ny][now.d] <= now.cost) continue;
			visited[nx][ny][now.d] = now.cost;

			if(data[nx][ny] == '#') {
				result = Math.min(result, now.cost);
				continue;
			}

			if (data[nx][ny] == '!') {
				int left = (now.d+3)%4;
				int right = (now.d+1)%4;
				q.offer(new Data(nx, ny, left, now.cost + 1));
				q.offer(new Data(nx, ny, right, now.cost + 1));
			}
			q.offer(new Data(nx, ny, now.d, now.cost));

		}

		System.out.println(result);
	}

	public static class Data{
		int x;
		int y;
		int d;
		int cost;

		public Data(int x, int y, int d, int cost) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Data{" +
				"x=" + x +
				", y=" + y +
				", d=" + d +
				", cost=" + cost +
				'}';
		}
	}
}
