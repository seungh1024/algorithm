

import java.io.*;
import java.util.*;

public class Main {
	public static int N, W;
	public static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
	public static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};
	public static int[][] data,water;
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
		water = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 1; j <= N; j++) {
				data[i][j] = input[j-1] - '0';
			}
			Arrays.fill(water[i], -1);
		}

		find();
		int time = check();
		System.out.println(time);
	}

	public static int check() {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
		boolean[][] visited = new boolean[N + 1][N + 1];
		visited[1][1] = true;
		q.offer(new int[] {1, 1, 0});
		int[][] distance = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}

		while (!q.isEmpty()) {
			int[] now = q.poll();

			if(now[0] == N && now[1] == N) {
				return now[2];
			}
			if(distance[now[0]][now[1]] < now[2]) continue;

			for (int d = 0; d < 8; d++) {
				int nx = now[0]+dx[d];
				int ny = now[1]+dy[d];
				if (nx >= 1 && nx <= N && ny >= 1 && ny <= N &&  data[nx][ny] == 1) {
					int nc = Math.max(now[2], water[nx][ny]);
					if (distance[nx][ny] > nc) {
						distance[nx][ny] = nc;
						q.offer(new int[] {nx, ny,nc});
					}
				}
			}
		}

		return -1;
	}

	public static void find() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N + 1][N + 1];
		for (int i = 0; i < W; i++) {
			q.offer(new int[] {wx[i], wy[i]});
			visited[wx[i]][wy[i]] = true;
			water[wx[i]][wy[i]] = 0;
		}
		water[1][1] = 0;
		water[N][N] = 0;
		visited[1][1] = true;
		visited[N][N] = true;


		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int[] now = q.poll();

				for (int d = 0; d < 4; d++) {
					int nx = now[0]+dx[d];
					int ny = now[1]+dy[d];
					if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && !visited[nx][ny]) {
						visited[nx][ny] = true;
						water[nx][ny] = water[now[0]][now[1]] + 1;
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}
	}
}
