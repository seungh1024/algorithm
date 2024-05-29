package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_1743_음식물피하기 {
	public static int N,M,K;
	public static boolean[][] data;
	public static boolean[][] visited;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		data = new boolean[N+1][M+1];
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			data[r][c] = true;
			list.add(new int[] {r, c});
		}

		int max = 0;
		visited = new boolean[N+1][M+1];
		for (int[] rc : list) {
			int result = find(rc[0], rc[1]);
			max = Math.max(max, result);
		}
		System.out.println(max);
	}

	public static int find(int x, int y) {
		int result = 1;

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now[0]+dx[d];
				int ny = now[1] + dy[d];
				if (nx > 0 && nx <= N && ny > 0 && ny <= M && !visited[nx][ny] && data[nx][ny]) {
					q.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					result++;
				}
			}
		}

		return result;
	}
}
