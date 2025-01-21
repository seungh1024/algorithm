import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static List<Data>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}


		for (int i = 0; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list[A].add(new Data(B, C, 0));
			list[B].add(new Data(A, C, 0));
		}

		int max = find(Comparator.comparingLong(d -> d.way));
		// System.out.println("max = " + max);

		int min = find(Comparator.comparingLong(d -> -d.way));
		// System.out.println("min = " + min);
		System.out.println(max*max-min*min);
	}

	public static int find(Comparator<Data> comparator) {
		PriorityQueue<Data> pq = new PriorityQueue<>(comparator);
		pq.offer(new Data(0, 1, 0));
		boolean[] visited = new boolean[N + 1];

		int cnt = 0;
		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if(visited[now.to]) continue;
			visited[now.to] = true;
			// System.out.println(now);

			if (now.way == 0) {
				cnt++;
			}

			for (Data next : list[now.to]) {
				if (!visited[next.to]) {
					pq.offer(next);
				}
			}
		}

		return cnt;
	}

	public static class Data{
		int to;
		int way;
		long cost;

		public Data(int to, int way, long cost) {
			this.to = to;
			this.way = way;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Data{" +
				"to=" + to +
				", way=" + way +
				", cost=" + cost +
				'}';
		}
	}
}