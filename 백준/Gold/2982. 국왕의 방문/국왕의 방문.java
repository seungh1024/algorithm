import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int A,B,K, G;
	public static List<Data>[] list;
	public static int[][] wait;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());

		wait = new int[N + 1][N + 1];
		int[] arr = new int[G];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < G; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list[from].add(new Data(to, cost));
			list[to].add(new Data(from, cost));
		}

		int value = 0;
		for (int i = 1; i < G; i++) {
			int last = arr[i-1];
			int now = arr[i];

			for (Data next : list[last]) {
				if (next.to == now) {
					value += next.cost;
					break;
				}
			}
			wait[last][now] = value;
			wait[now][last] = value;
		}

		// for (int i = 0; i <= N; i++) {
		// 	System.out.println(Arrays.toString(wait[i]));
		// }

		find();
	}

	public static void find() {
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		pq.offer(new Data(A, K));
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[A] = K;
		boolean[] visited = new boolean[N + 1];

		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if(visited[now.to]) continue;
			visited[now.to] = true;

			// System.out.println("now = "+now);

			if (now.to == B) {
				System.out.println(now.cost - K);
				break;
			}

			for (Data next : list[now.to]) {
				if (!visited[next.to]) {
					// System.out.println("next = "+next);
					// System.out.println("wait = "+wait[now.to][next.to]);
					if (wait[now.to][next.to] > now.cost && now.cost + next.cost > wait[now.to][next.to]) {
						int value = wait[now.to][next.to] - now.cost;
						if (distance[next.to] > distance[now.to] + next.cost + value) {
							distance[next.to] = distance[now.to] + next.cost + value;
							pq.offer(new Data(next.to, distance[next.to]));
						}
					}else {
						if (distance[next.to] > distance[now.to] + next.cost) {
							distance[next.to] = distance[now.to] + next.cost;
							pq.offer(new Data(next.to, distance[next.to]));
						}
					}
				}
			}
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