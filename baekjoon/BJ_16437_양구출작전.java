package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_16437_양구출작전 {
	public static int N;
	public static List<Integer>[] list;
	public static long[] sheep;

	public static int[] count;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		sheep = new long[N + 1];
		count = new int[N+1];
		for (int i = 2; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			long a = Long.parseLong(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list[i].add(to);
			list[to].add(i);
			count[to] ++;
			if (s.equals("S")) {
				sheep[i] = a;
			} else {
				sheep[i] = -a;
			}
		}

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		boolean[] visited = new boolean[N+1];
		visited[1] = true;

		List<Integer> start = new ArrayList<>();
		while (!q.isEmpty()) {
			int now = q.poll();

			int cnt = 0;
			for (int next : list[now]) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
					cnt++;
				}
			}

			if (cnt == 0) {
				start.add(now);
			}
		}

		find(start);

	}

	public static void find(List<Integer> start) {
		Queue<Data> q = new ArrayDeque<>();

		for (int i : start) {
			long cost = sheep[i];
			if (cost < 0) {
				cost = 0;
			}
			q.offer(new Data(i,cost,i));
		}

		long sum = 0;
		while (!q.isEmpty()) {
			Data now = q.poll();
			// System.out.println("now = "+now);


			for (int next : list[now.to]) {
				count[next] --;
				if(now.last == next) continue;
				sheep[next] += now.cost;
				if(count[next] > 0)continue;
				// System.out.println(Arrays.toString(sheep));
				long cost = sheep[next];
				if (cost < 0) {
					cost = 0;
				}
				q.offer(new Data(next, cost, now.to));
			}
		}

		System.out.println(sheep[1]);

	}

	public static class Data{
		int to;
		long cost;
		int last;

		public Data(int to, long cost, int last) {
			this.to = to;
			this.cost = cost;
			this.last = last;
		}

		@Override
		public String toString() {
			return "Data{" +
				"to=" + to +
				", cost=" + cost +
				", last=" + last +
				'}';
		}
	}

}
