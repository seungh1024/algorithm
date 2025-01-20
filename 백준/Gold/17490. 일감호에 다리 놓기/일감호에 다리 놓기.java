import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static long K;
	public static long[] rock;
	public static List<Data>[] list;
	public static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Long.parseLong(st.nextToken());

		rock = new long[N + 1];
		list = new ArrayList[N + 1];
		st = new StringTokenizer(br.readLine());
		list[0] = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			rock[i] = Long.parseLong(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			list[0].add(new Data(i, rock[i]));
			list[i].add(new Data(0, rock[i]));
			if (i + 1 <= N) {
				list[i].add(new Data(i + 1, 0));
				list[i + 1].add(new Data(i, 0));
			}
		}
		list[N].add(new Data(1, 0));
		list[1].add(new Data(N, 0));
		// System.out.println(list[N]);
		// System.out.println(list[1]);

		visited = new boolean[N + 1][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			int max = Math.max(from, to);
			int min = Math.min(from, to);

			if (max == N && min == 1) {
				visited[max][1] = true;
				visited[min][0] = true;
			} else {
				visited[min][1] = true;
				visited[max][0] = true;
			}

		}

		find();
	}

	public static void find() {
		PriorityQueue<Data> q = new PriorityQueue<>(Comparator.comparingLong(d->d.cost));
		q.offer(new Data(1, 0));
		boolean[] check = new boolean[N + 1];

		int count = 0;
		long cost = 0;
		while (!q.isEmpty()) {
			Data now = q.poll();

			if(check[now.to]) continue;

			check[now.to] = true;

			if (now.to != 0) {
				count++;
			}
			cost += now.cost;

			// System.out.println(now);
			if (count == N) {
				break;
			}


			for (Data next : list[now.to]) {
				if (!check[next.to]) {
					if (next.to == 0) {
						q.offer(next);
						continue;
					}
					if (next.to > now.to ) {
						// System.out.println("next = "+next);
						if (now.to == 1 && next.to == N) {
							if (!visited[N][1]) {
								q.offer(next);
							}
						} else {
							if (!visited[now.to][1]) {
								q.offer(next);
							}
						}
					} else if (next.to < now.to) {
						if (now.to == N && next.to == 1) {
							if (!visited[next.to][0]) {
								q.offer(next);
							}
						} else {
							if (!visited[now.to][0]) {
								q.offer(next);
							}
						}
					}
				}
			}
		}

		if (count == N && cost <= K) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static class Data{
		int to;
		long cost;

		public Data(int to, long cost) {
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