

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
			sb.append("Case #").append(t).append(": ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			list = new ArrayList[M];
			for (int i = 0; i < M; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				list[x].add(new Data(y, z));
				list[y].add(new Data(x, z));
			}


			sb.append(find()).append("\n");

		}
		System.out.println(sb);
	}

	public static String find() {
		PriorityQueue<Data> pq = new PriorityQueue<>(
			Comparator.comparingInt((Data o) -> o.z).thenComparingInt(o -> o.v));
		pq.offer(new Data(0, 0));
		int[] distance = new int[M];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		boolean[] visited = new boolean[M];
		int[] last = new int[M];

		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if(visited[now.f]) continue;
			visited[now.f] = true;

			if (now.f == M - 1) {
				break;
			}

			for (Data next : list[now.f]) {
				if (!visited[next.f] && distance[next.f] > distance[now.f] + next.z) {
					distance[next.f] = distance[now.f] + next.z;
					last[next.f] = now.f;
					pq.offer(new Data(next.f, distance[next.f], next.z));
				}
			}
		}

		// System.out.println(Arrays.toString(distance));

		if (distance[M - 1] == Integer.MAX_VALUE) {
			return "-1";
		}

		Stack<Integer> stack = new Stack<>();
		int start = M-1;
		while (start != 0) {
			stack.push(start);
			start = last[start];
		}
		stack.push(0);
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}

		return sb.toString();
	}

	public static class Data{
		int f;
		int z;
		int v;

		public Data(int f, int z) {
			this.f = f;
			this.z = z;
		}

		public Data(int f, int z, int v) {
			this.f = f;
			this.z = z;
			this.v = v;
		}

		@Override
		public String toString() {
			return "Data{" +
				"f=" + f +
				", z=" + z +
				", v=" + v +
				'}';
		}
	}
}
// 7 5
// 0 1 2
// 1 3 4
// 0 2 1
// 0 4 3
// 3 2 3
// 3 4 4
// 2 4 2