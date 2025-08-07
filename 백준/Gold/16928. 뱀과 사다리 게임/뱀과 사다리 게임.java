

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] move;

	public static int[][] data;
	public static Map<Integer,Data> map;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		move = new int[101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			move[from] = to;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			move[from] = to;
		}
		data = new int[11][11];
		int num = 1;
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 10; j++) {
				data[i][j] = num++;
			}
		}
		map = new HashMap<>();
		int x = 1;
		int y = 1;
		for (int i = 1; i <= 100; i++) {
			map.put(i, new Data(x, y));

			y++;
			if (y == 11) {
				x++;
				y = 1;
			}
		}
		// System.out.println(map);

		find();
	}

	public static void find() {
		int[][] visited = new int[11][11];
		for (int i = 0; i <= 10; i++) {
			Arrays.fill(visited[i],Integer.MAX_VALUE);
		}
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(1, 1));

		int result = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Data now = q.poll();
				// System.out.println(now + ", data = "+data[now.x][now.y]);

				if (now.x == 10 && now.y == 10) {
					System.out.println(result);
					return;
				}

				int v = data[now.x][now.y];
				for (int i = 1; i <= 6; i++) {
					if(v+i > 100) continue;
					int n = v+i;
					if (move[v + i] > 0) {
						n = move[v + i];
					}
					Data next = map.get(n);


					if (visited[next.x][next.y] > visited[now.x][now.y] + 1) {
						visited[next.x][next.y] = visited[now.x][now.y] + 1;
						q.offer(new Data(next.x, next.y));
					}

				}

			}
			result++;
		}
	}
	public static class Data{
		int x;
		int y;


		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Data{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
}
