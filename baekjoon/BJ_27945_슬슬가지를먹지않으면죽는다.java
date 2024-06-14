package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_27945_슬슬가지를먹지않으면죽는다 {
	public static int N, M;
	public static List<Data> list;
	public static List<Data>[] road;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		road = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			road[i] = new ArrayList<>();
		}
		Data start = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int day = Integer.parseInt(st.nextToken());

			road[from].add(new Data(to, day));
			road[to].add(new Data(from, day));
			if (day == 1) {
				start = new Data(from,to,day);
			}

		}


		int result = 1;

		if (start != null) {
			result = find(start.to);
		}
		System.out.println(result);
	}

	public static int find(int start) {
		Queue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(start, 0));
		boolean[] visited = new boolean[N+1];
		// visited[start] = true;

		int d = 0;
		int count = 0;
		Set<Integer> set = new TreeSet<>();
		while (!pq.isEmpty()) {
			Data now = pq.poll();
			// System.out.println(now);
			if(visited[now.to]) continue;
			visited[now.to] = true;
			set.add(now.day);
			count++;
			if (count == N) {
				break;
			}

			for (Data next : road[now.to]) {
				if(!visited[next.to]){
					pq.offer(next);
				}
			}
		}

		d = -1;
		for (Integer i : set) {
			if (d + 1 == i) {
				d++;
			} else {
				break;
			}
		}

		return d+1;
	}


	public static class Data implements Comparable<Data> {
		int from;
		int to;
		int day;

		public Data(int from, int to, int day) {
			this.from = from;
			this.to = to;
			this.day =day;
		}

		public Data(int to, int day) {
			this.to = to;
			this.day =day;
		}

		@Override
		public int compareTo(Data d) {
			return this.day - d.day;
		}

		@Override
		public String toString() {
			return "to = "+to +", day = "+day;
		}
	}
}
