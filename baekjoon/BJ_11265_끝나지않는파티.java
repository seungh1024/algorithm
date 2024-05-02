package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_11265_끝나지않는파티 {
	public static List<Party>[] list;
	public static int N,M;
	public static int[][] time;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		time = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int input = Integer.parseInt(st.nextToken());
				if(i == j) continue;
				list[i].add(new Party(j,input));
			}
			Arrays.fill(time[i], Integer.MAX_VALUE);
		}


		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			if (time[A][B] <= C) {
				sb.append("Enjoy other party");
			} else {
				int value = find(A,B,C);
				if (value > 0) {
					time[A][B] = value;
					sb.append("Enjoy other party");
				} else {
					sb.append("Stay here");
				}
			}
			sb.append("\n");
		}
		// System.out.println(find(5, 3, 2));
		System.out.println(sb);
	}

	public static int find(int start, int end, int maxCost) {
		boolean[] visited = new boolean[N+1];
		Queue<Party> pq = new PriorityQueue<>();
		pq.offer(new Party(start, 0));
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		while (!pq.isEmpty()) {
			Party now = pq.poll();
			// System.out.println(now);

			// if (now.cost >= maxCost) {
			// 	return false;
			// }
			if (now.to == end) {
				if (now.cost <= maxCost) {
					return now.cost;
				} else {
					return 0;
				}
			}

			if (visited[now.to]) {
				continue;
			}
			visited[now.to] = true;

			for (Party next : list[now.to]) {
				if (!visited[next.to] && distance[next.to] > distance[now.to] + next.cost) {
					distance[next.to] = distance[now.to] + next.cost;
					// System.out.println("next = "+next + ", distance = "+distance[next.to]);
					pq.offer(new Party(next.to, distance[next.to]));
				}
			}
		}

		return 0;
	}

	public static class Party implements Comparable<Party>{
		int to;
		int cost;

		public Party(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Party party) {
			return this.cost - party.cost;
		}

		@Override
		public String toString() {
			return "to = "+to + ", cost = "+cost;
		}
	}
}
