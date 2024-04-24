package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_14940_쉬운최단거리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] data = new int[N][M];
		int x = 0;
		int y = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if(data[i][j] == 2){
					x = i;
					y = j;
				}
			}
		}

		Queue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(x,y,0));
		boolean[][] visited = new boolean[N][M];
		// visited[x][y] = true;
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		int[][] answer = new int[N][M];

		while (!pq.isEmpty()) {
			Data now = pq.poll();
			// System.out.println(now);

			if(visited[now.x][now.y]) continue;
			visited[now.x][now.y] = true;
			answer[now.x][now.y] = now.cost;

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && data[nx][ny] == 1) {
					pq.offer(new Data(nx,ny,now.cost+1));
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (data[i][j] == 1 && answer[i][j] == 0) {
					sb.append(-1);
				} else {
					sb.append(answer[i][j]);
				}
				sb.append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	public static class Data implements Comparable<Data> {
		int x;
		int y;
		int cost;

		public Data(int x, int y, int cost) {

			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data data) {
			return this.cost-data.cost;
		}

		@Override
		public String toString() {
			return "x = " + x + ", y = "+y + ", cost = "+cost;
		}

	}

}
