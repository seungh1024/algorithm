

import java.io.*;
import java.util.*;

public class Main {
	public static int N,M, K;
	public static int[][] data;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		data = new int[N+1][M+2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		find();
	}

	public static void find() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
		pq.offer(new int[] {0, 0,0});

		boolean[][] visited = new boolean[N + 1][M + 2];

		int max = 0;
		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int x = now[0];
			int y = now[1];
			int cost = now[2];

			if (data[x][y] != 0) {
				max = Math.max(max, data[x][y]);
				K--;
			}

			if (K == 0) {
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx <= N && ny >= 0 && ny <= M+1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					pq.offer(new int[] {nx, ny, data[nx][ny]});
				}
			}

		}

		System.out.println(max);
	}
}
