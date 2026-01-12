

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] data;
	public static int[][] visited;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				pq.offer(new int[] {i, j, data[i][j]});
			}
		}

		int result = 0;
		visited = new int[N][N];

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if(visited[now[0]][now[1]] != 0) continue;
			result = Math.max(result, findBig(now[0], now[1]));
		}

		System.out.println(result);
	}

	public static int findBig(int x, int y) {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt((int[] o)->o[2]));
		q.offer(new int[]{x,y,data[x][y],1});
		visited[x][y] = 1;

		int cnt = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			cnt = Math.max(cnt, now[3]);
			for (int d = 0; d < 4; d++) {
				int nx = now[0]+dx[d];
				int ny = now[1]+dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && now[2] < data[nx][ny] && visited[nx][ny] < now[3] + 1) {
					visited[nx][ny] = now[3]+1;
					q.offer(new int[] {nx, ny, data[nx][ny], visited[nx][ny]});
				}
			}
		}

		return cnt;
	}

}
