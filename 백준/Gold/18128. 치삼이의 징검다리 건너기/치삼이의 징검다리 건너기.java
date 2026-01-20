

import java.io.*;
import java.util.*;

public class Main {
	public static int N, W;
	public static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
	public static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
	public static int[][] data;
	public static int[] wx,wy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		wx = new int[W];
		wy = new int[W];
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			wx[i] = Integer.parseInt(st.nextToken());
			wy[i] = Integer.parseInt(st.nextToken());
		}
		data = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 1; j <= N; j++) {
				data[i][j] = input[j-1] - '0';
			}
		}


		int time = find();
		System.out.println(time);
	}

	public static boolean check() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][N + 1];
		visited[1][1] = true;
		q.offer(new int[] {1, 1});
		// for (int i = 1; i <= N; i++) {
		// 	System.out.println(Arrays.toString(data[i]));
		// }
		// System.out.println("---------");
		while (!q.isEmpty()) {
			int[] now = q.poll();

			if(now[0] == N && now[1] == N) {
				return true;
			}

			for (int d = 0; d < 8; d++) {
				int nx = now[0]+dx[d];
				int ny = now[1]+dy[d];

				if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && !visited[nx][ny] && data[nx][ny] == 2) {
					visited[nx][ny] = true;
					q.offer(new int[] {nx, ny});
				}
			}
		}

		return false;
	}

	public static int find() {
		int time = 0;
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][N + 1];
		for (int i = 0; i < W; i++) {
			q.offer(new int[] {wx[i], wy[i]});
			visited[wx[i]][wy[i]] = true;
			if (data[wx[i]][wy[i]] == 1) {
				
				data[wx[i]][wy[i]] = 2;
			}
		}
		visited[1][1] = true;
		visited[N][N] = true;
		data[1][1] = 2;
		data[N][N] = 2;

		while (!q.isEmpty()) {
			if ((data[1][2] == 2 || data[2][1] == 2 || data[2][2] == 2) && (data[N][N-1] == 2 || data[N-1][N] == 2 || data[N-1][N-1] == 2)) {
				if (check()) {
					return time;
				}
			}
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int[] now = q.poll();

				for (int d = 0; d < 4; d++) {
					int nx = now[0]+dx[d];
					int ny = now[1]+dy[d];
					if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && !visited[nx][ny]) {
						visited[nx][ny] = true;
						if (data[nx][ny] == 1) {

							data[nx][ny] = 2;
						}
						q.offer(new int[] {nx, ny});
					}
				}
			}
			time++;

		}

		return -1;
	}
}
