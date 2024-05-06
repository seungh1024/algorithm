package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_1948_임계경로 {
	public static int N,M;
	public static List<Data>[] list,rList;
	public static int start,end;
	public static int[] inCount,outCount;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		rList = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
			rList[i] = new ArrayList<>();
		}

		inCount = new int[N+1];
		outCount = new int[N+1];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list[from].add(new Data(to, cost,0)); // 나에게 오는 길들
			rList[to].add(new Data(from, cost, 0)); // reverse
			outCount[from]++;
			inCount[to]++;
		}
		start = 0;
		end = 0;
		for (int i = 1; i <= N; i++) {
			if (inCount[i] == 0) {
				start = i;
			}
			if (outCount[i] == 0) {
				end = i;
			}
		}

		find();
	}

	public static void find() {
		Queue<Data> q = new ArrayDeque<>();
		Data first = new Data(start, 0, 0);
		q.offer(new Data(start, 0,0));

		int[] maxInCost = new int[N+1];

		while (!q.isEmpty()) {
			Data now = q.poll();

			// if (now.to == end) {
			// 	break;
			// }
			// System.out.println(now);

			for (Data data : list[now.to]) {
				inCount[data.to] --;
				if (maxInCost[data.to] < now.cost + data.cost) {
					maxInCost[data.to] = now.cost+data.cost;
				}
				if (inCount[data.to] == 0) {
					Data input = new Data(data.to, maxInCost[data.to], 0);
					q.offer(input);

				}
			}
		}

		// System.out.println(Arrays.toString(maxInCost));
		System.out.println(maxInCost[end]);

		q = new ArrayDeque<>();
		q.offer(new Data(end, 0, 0));
		List<Integer> road = new ArrayList<>();

		boolean[] visited = new boolean[N+1];
		while (!q.isEmpty()) {
			Data now = q.poll();

			if (now.to == start) {
				break;
			}
			if(visited[now.to]) continue;
			visited[now.to] = true;

			for (Data data : rList[now.to]) {
				if (maxInCost[now.to] - data.cost == maxInCost[data.to]) {
					road.add(data.to);
					q.offer(data);
				}
			}
		}

		System.out.println(road.size());
		// System.out.println(road);

	}


	public static class Data {
		int to;
		int cost;
		int count;

		List<Integer> node;
		public Data(int to, int cost, int count) {
			this.to = to;
			this.cost = cost;
			this.count = count;
		}

		@Override
		public String toString() {
			return "to = "+to +", cost = "+cost + ", count = "+count;
		}
	}

}
// 5
// 7
// 1 2 1
// 1 3 3
// 2 3 2
// 2 4 1
// 2 5 3
// 3 5 1
// 4 5 1
// 1 5