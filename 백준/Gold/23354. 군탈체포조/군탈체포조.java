

import java.io.*;
import java.util.*;

public class Main {
	public static int[] arr;
	public static List<Data>[] list;
	public static int N;
	public static int[][] data;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		list = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		int idx = 0;
		int x = 0;
		int y = 0;
		List<int[]> dataList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] == 0) {
					dataList.add(new int[] {i, j,idx++});
				} else if (data[i][j] == -1) {
					x=i;
					y=j;
					data[i][j] = 0;
				}
			}

		}
		if (idx == 0) {
			System.out.println(0);
			return;
		}

		dataList.add(new int[] {x, y, idx});
		for (int[] i : dataList) {
			find(i[0], i[1], dataList, i[2]);
		}

		// System.out.println(list[idx]);

		arr = new int[idx];
		result = Integer.MAX_VALUE;
		func(0, idx, new boolean[idx]);
		System.out.println(result);
	}

	public static void func(int idx, int N, boolean[] visited) {
		if (idx == N) {
			// System.out.println(Arrays.toString(arr));
			int sum = 0;
			for (int i = 1; i < N; i++) {
				int from = arr[i-1];
				int to = arr[i];
				for (Data d : list[from]) {
					if (d.to == to) {
						sum += d.cost;
						break;
					}
				}
				// System.out.println("from = "+from +", to = "+to + ", sum = "+sum);
			}

			// System.out.println("first sum = "+sum);
			for (Data d : list[N]) {
				if (d.to == arr[0]) {
					sum += d.cost;
					break;
				}
			}
			for (Data d : list[arr[idx-1]]) {
				if (d.to == N) {
					sum+=d.cost;
					break;
				}
			}

			// System.out.println("sum  = "+sum);
			result = Math.min(result, sum);

			return;
		}

		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			arr[idx] = i;
			func(idx+1,N,visited);
			visited[i] = false;
		}
	}

	public static void find(int x, int y, List<int[]> dataList, int idx) {
		PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
		q.offer(new int[] {x, y,0});
		int[][] visited = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		visited[x][y] = 0;

		// System.out.println(" x = "+x + ", y ="+y + ", dix = "+idx);
		while (!q.isEmpty()) {
			int[] now = q.poll();

			if(visited[now[0]][now[1]] < now[2]) continue;
			// System.out.println("now = " + Arrays.toString(now) + ", now visit = " + visited[now[0]][now[1]]);
			for (int d = 0; d < 4; d++) {
				int nx = now[0]+dx[d];
				int ny = now[1] + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && visited[nx][ny] > visited[now[0]][now[1]] + data[nx][ny]) {
					visited[nx][ny] = visited[now[0]][now[1]] + data[nx][ny];
					// System.out.println("nx = "+nx + ", ny = "+ny + ", next visit = "+visited[nx][ny]);
					q.offer(new int[] {nx, ny,visited[nx][ny]});
				}
			}
		}

		// for (int i = 0; i < N; i++) {
		// 	System.out.println(Arrays.toString(visited[i]));
		// }


		for (int[] next : dataList) {
			int nx=  next[0];
			int ny = next[1];
			int nextIdx = next[2];

			if(nextIdx == idx) continue;

			list[idx].add(new Data(nextIdx, visited[nx][ny]));
			// list[nextIdx].add(new Data(idx, visited[nx][ny]));
		}
	}

	public static class Data{
		int to;
		int cost;

		public Data(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Data{" +
				"to=" + to +
				", cost=" + cost +
				'}';
		}
	}
}
// 5
// 1 3 2 1 9
// 2 1 4 4 3
// 5 3 -1 1 1
// 3 7 2 1 1
// 1 2 3 5 1