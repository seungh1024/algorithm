import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, K;
	public static List<Data>[] list;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			if (from < to) {
				list[from].add(new Data(to, cost));
			}
		}

		find();
	}

	public static void find() {
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(1, 0));
		int m = 1;
		int[][] distance = new int[N+1][M+1];
		distance[1][0] = -1;

		int result = 0;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int s = 0; s < size; s++) {
				Data now = q.poll();

				if(distance[now.to][m] > now.cost) continue;
				// distance[now.to] = now.cost;

				// result = Math.max(result,now.cost);
				for (Data next : list[now.to]) {
					if (distance[next.to][m+1] < distance[now.to][m] + next.cost) {
						distance[next.to][m+1] = distance[now.to][m] + next.cost;
						q.offer(new Data(next.to, distance[next.to][m+1]));
					}
				}
			}
			m++;
			if (m == M) {
				break;
			}
		}

		// System.out.println(Arrays.toString(distance));

		for (int i = 0; i <= M; i++) {
			result = Math.max(result, distance[N][i]);
		}
		System.out.println(result);
	}

	public static class Data{
		int to;
		int cost;

		public Data(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}