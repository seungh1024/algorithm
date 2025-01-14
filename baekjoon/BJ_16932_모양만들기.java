package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_16932_모양만들기 {
	public static int N, M;
	public static int[][] data;
	public static List<Data> empty; // 0인 곳의 좌표
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static Map<Integer, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new int[N][M];
		empty = new ArrayList<>();
		map = new HashMap<>();
		map.put(0, 0);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] == 0) {
					empty.add(new Data(i, j));
				}
			}
		}

		int visit = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (data[i][j] == 1) {
					int cnt = find(visit, i, j);
					map.put(visit, cnt);
					visit++;
				}
			}
		}
		// System.out.println(map);
		// for (int i = 0; i < N; i++) {
		// 	System.out.println(Arrays.toString(data[i]));
		// }

		int max = 0;
		for (Data now : empty) {
			// System.out.println(now);
			int sum = 1;
			Set<Integer> set = new HashSet<>();
			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && data[nx][ny] != 0) {
					set.add(data[nx][ny]);
				}
			}
			for (int key : set) {
				sum += map.get(key);
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}

	public static int find(int visit, int x, int y) {
		data[x][y] = visit;
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(x,y));

		int cnt = 1;
		while (!q.isEmpty()) {
			Data now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && data[nx][ny] == 1) {
					data[nx][ny] = visit;
					cnt++;
					q.offer(new Data(nx, ny));
				}
			}
		}

		return cnt;
	}

	public static class Data{
		int x, y;

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
