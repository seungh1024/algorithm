

import java.io.*;
import java.util.*;

public class Main {
	public static int N,M, K;
	public static int size;
	public static boolean[] visited;
	public static List<Data> list;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();

		size = 5 * K - 4;
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o.cost));
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int v = Integer.parseInt(st.nextToken());
				Data now = new Data(i, j, v);
				pq.offer(now);

			}
		}

		while (!pq.isEmpty() && list.size()<size) {
			list.add(pq.poll());
		}
		while (list.size() < K) {
			list.add(new Data(-1, -1, 0));
		}

		size = list.size();
		visited = new boolean[size];
		find(0,0);
		System.out.println(result);

	}

	public static void find(int idx, int cnt) {
		if (cnt <= K) {
			// System.out.println(Arrays.toString(visited));
			int sum = 0;
			List<Data> temp = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				if (visited[i]) {
					temp.add(list.get(i));
				}
			}

			for (int i = 0; i < temp.size(); i++) {
				Data last = temp.get(i);
				for (int j = i + 1; j < temp.size(); j++) {
					Data now = temp.get(j);
					for (int d = 0; d < 4; d++) {
						int nx = now.x+dx[d];
						int ny = now.y+dy[d];
						if(nx == last.x && ny == last.y) return;
					}
				}
				sum += last.cost;
			}

			result = Math.max(result, sum);
			
		}
		if(cnt == K) return;
		if(idx >= size) return;

		visited[idx] = true;
		find(idx + 1, cnt + 1);
		visited[idx] = false;
		find(idx + 1, cnt);
	}

	public static class Data{
		int x;
		int y;
		int cost;

		@Override
		public String toString() {
			return "Data{" +
				"x=" + x +
				", y=" + y +
				", cost=" + cost +
				'}';
		}

		public Data(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}
}
