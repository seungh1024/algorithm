

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] data;
	public static List<Data> list;
	public static boolean[] visited;
	public static int[] index;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static int result = Integer.MAX_VALUE;
	public static int[][] dis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] == -1) {
					data[i][j] = 0;
					list.add(0,new Data(i, j));
				} else if (data[i][j] == 0) {
					list.add(new Data(i, j));
				}
			}
		}

		visited = new boolean[list.size()];
		index = new int[list.size()];
		dis = new int[list.size()][list.size()];
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int v = getValue(list.get(i), list.get(j));
				// System.out.println(list.get(i));
				// System.out.println(list.get(j));
				// System.out.println("i = " + i + ", j = " + j + ", v = " + v);
				dis[i][j] = v;
				dis[j][i] = v;
			}
			// System.out.println(Arrays.toString(dis[i]));
		}

		find(1);
		System.out.println(result);
	}

	public static int getValue(Data start, Data end) {
		PriorityQueue<Data> q = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		q.offer(start);
		int[][] check = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(check[i], Integer.MAX_VALUE);
		}
		check[start.x][start.y] = 0;

		while (!q.isEmpty()) {
			Data now = q.poll();

			if (now.x == end.x && now.y == end.y) {
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = now.x + dx[d];
				int ny = now.y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && check[nx][ny] > now.cost + data[nx][ny]) {
					check[nx][ny] = now.cost + data[nx][ny];
					q.offer(new Data(nx, ny, check[nx][ny]));
				}
			}

		}

		return check[end.x][end.y];
	}

	public static void find(int idx) {
		if (idx == list.size()) {
			int sum = 0;
			for (int i = 1; i < list.size(); i++) {
				int from = index[i];
				int to = index[i-1];
				sum += dis[from][to];
			}
			int from = index[list.size()-1];
			int to = 0;
			sum += dis[from][to];
			// System.out.println(Arrays.toString(index));
			// System.out.println(sum);
			result = Math.min(result, sum);

			return;
		}

		for (int i = 1; i < list.size(); i++) {
			if(visited[i]) continue;
			visited[i] = true;
			index[idx] = i;
			find(idx + 1);
			visited[i] = false;
		}
	}

	public static class Data{
		int x;
		int y;
		int cost;

		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public Data(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Data{" +
				"x=" + x +
				", y=" + y +
				", cost=" + cost +
				'}';
		}
	}
}
