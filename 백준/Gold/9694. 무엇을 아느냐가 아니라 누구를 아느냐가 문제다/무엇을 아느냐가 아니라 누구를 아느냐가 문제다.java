

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static List<Data>[] list;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			list = new ArrayList[M];
			for (int i = 0; i < M; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				list[from].add(new Data(to, cost));
				list[to].add(new Data(from, cost));
			}

			String result = find();
			sb.append("Case #").append(t).append(": ").append(result).append("\n");
		}

		System.out.println(sb);
	}

	public static String find() {
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
		int[] distance = new int[M];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		pq.offer(new Data(0, 0));
		boolean[] visited = new boolean[M];
		int[] last = new int[M];

		while(!pq.isEmpty()) {
			Data now = pq.poll();

			if (now.to == M - 1) {
				break;
			}
			if(visited[now.to]) continue;
			visited[now.to] = true;

			for(Data next : list[now.to]) {
				if (!visited[next.to] && distance[next.to] > distance[now.to] + next.cost) {
					distance[next.to] = distance[now.to] + next.cost;
					last[next.to] = now.to;
					pq.offer(new Data(next.to, distance[next.to]));
				}
			}
		}

		if(distance[M-1] == Integer.MAX_VALUE) {
			return "-1";
		}

		// System.out.println(Arrays.toString(last));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int idx = M-1;
		while (idx != 0) {
			stack.push(idx);
			idx = last[idx];
		}
		stack.push(0);
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}

		return sb.toString();
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
