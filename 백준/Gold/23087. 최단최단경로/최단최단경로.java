

import java.io.*;
import java.util.*;

public class Main {
	public static int N,M,x, y;
	public static List<Data>[] list;
	public static Map<Long,Long> map;
	public static long[] distance, minCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		map = new HashMap<>();
		long mul = 1_000_000L;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Data(u,v, w, 0));

			long key = (long)u * mul + (long)v;
			map.put(key, map.getOrDefault(key, 0L) + 1);

		}

		long[] result = find();
		if (result == null) {
			System.out.println(-1);
			return;
		}

		System.out.println(result[0]);
		System.out.println(result[1]);
		System.out.println(result[2]);
	}



	public static long[] find() {
		PriorityQueue<Data> pq = new PriorityQueue<>(
			Comparator.comparingLong((Data o) -> o.cost).thenComparingLong(o -> o.cnt));

		pq.offer(new Data(0,x, 0, 0));
		distance = new long[N + 1];
		minCount = new long[N + 1];
		Arrays.fill(distance, Long.MAX_VALUE);
		Arrays.fill(minCount, Long.MAX_VALUE);
		distance[x] = 0;
		minCount[x] = 0;

		long mod = 1_000_000_009;
		long[] totalCount = new long[N + 1];
		totalCount[x] = 1;
		while (!pq.isEmpty()) {
			Data now = pq.poll();

			if (now.to == y) {
				continue;
			}
			if(distance[now.to] < now.cost) continue;
			if(distance[now.to] >= now.cost && minCount[now.to] < now.cnt) continue;

			for (Data next : list[now.to]) {
				if (distance[next.to] > distance[now.to] + next.cost) {
					distance[next.to] = distance[now.to] + next.cost;
					minCount[next.to] = now.cnt+1;
					pq.offer(new Data(now.to, next.to, distance[next.to], now.cnt + 1));

					totalCount[next.to] = 0;
					totalCount[next.to] += totalCount[now.to];
					totalCount[next.to] %= mod;
				} else if (distance[next.to] == distance[now.to] + next.cost && minCount[next.to] > now.cnt + 1) {
					minCount[next.to] = now.cnt + 1;
					pq.offer(new Data(now.to,next.to, distance[next.to], now.cnt + 1));

					totalCount[next.to] = 0;
					totalCount[next.to] += totalCount[now.to];
					totalCount[next.to] %= mod;
				} else if (distance[next.to] == distance[now.to] + next.cost && minCount[next.to] == now.cnt + 1) {
					totalCount[next.to] += totalCount[now.to];
					totalCount[next.to] %= mod;
				}
			}
		}

		long minDistance = distance[y];
		long minSubCount = minCount[y];

		if (minDistance == Long.MAX_VALUE) {
			return null;
		}

		return new long[] {minDistance, minSubCount, totalCount[y]};

	}


	public static class Data{
		int from;
		int to;
		long cost;
		long cnt;

		public Data(int from, int to, long cost, long cnt) {
			this.from = from;
			this.to = to;
			this.cost = cost;
			this.cnt = cnt;
		}

		public Data(int to, long cost, long cnt) {
			this.to = to;
			this.cost = cost;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Data{" +
				"from=" + from +
				", to=" + to +
				", cost=" + cost +
				", cnt=" + cnt +
				'}';
		}
	}
}
