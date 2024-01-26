package algo_202401;

import java.util.*;

public class P_배달 {
	public static void main(String[] args) {
		P_배달 test = new P_배달();
		int N = 5;
		int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
		int K = 3;
		int answer = test.solution(N, road, K);
		int result = 4;

		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static List<Data>[] list;
	public int solution(int N, int[][] road, int K) {
		int answer = 0;

		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++){
			list[i] = new ArrayList<>();
		}

		for(int[] r : road){
			list[r[0]].add(new Data(r[1],r[2]));
			list[r[1]].add(new Data(r[0],r[2]));
		}

		answer = find(N,K);

		return answer;
	}

	public static int find(int N, int K){
		int result = 0;
		int start = 1;
		boolean[] visited = new boolean[N+1];
		Queue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(1,0));
		int[] distance = new int[N+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;

		while(!pq.isEmpty()){
			Data now = pq.poll();

			if(visited[now.to]) continue;
			visited[now.to] = true;
			distance[now.to] = now.cost;

			// System.out.println("to: "+now.to + ", cost: " + now.cost);


			for(Data next : list[now.to]){
				if(!visited[next.to] && distance[now.to]+next.cost <= distance[next.to]){
					pq.offer(new Data(next.to, distance[now.to]+next.cost));
				}
			}
		}

		for(int i = 1; i <= N; i++){
			if(distance[i] <=K){
				result++;
			}
		}
		// System.out.println(Arrays.toString(distance));

		return result;
	}

	public static class Data implements Comparable<Data>{
		int to;
		int cost;

		public Data(int to, int cost){
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data d){
			return this.cost-d.cost;
		}
	}
}
