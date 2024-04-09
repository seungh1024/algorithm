package algo_202403;

import java.util.*;

public class P_부대복귀 {
	public static List<Data>[] list;
	public static int[] check;

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {

		list = new ArrayList[n+1];
		for(int i = 1; i <= n; i++){
			list[i] = new ArrayList<>();
		}
		for(int[] r : roads){
			int from = r[0];
			int to = r[1];
			list[from].add(new Data(to,1));
			list[to].add(new Data(from,1));
		}

		int length = sources.length;
		int[] answer = new int[length];
		check = new int[n+1];
		Arrays.fill(check,-1);

		find(n,destination);
		// System.out.println(Arrays.toString(check));
		for(int i = 0; i < length; i++){
			answer[i] = check[sources[i]];
		}

		return answer;
	}

	public static void find(int n, int destination){
		Queue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(destination,0));
		boolean[] visited = new boolean[n+1];

		while(!pq.isEmpty()){
			Data now = pq.poll();
			if(visited[now.to]) continue;
			visited[now.to] = true;
			check[now.to] = now.cost;

			for(Data next : list[now.to]){
				if(!visited[next.to]){
					pq.offer(new Data(next.to,now.cost+next.cost));
				}
			}
		}
	}

	public static class Data implements Comparable<Data>{
		int to;
		int cost;

		public Data(int to , int cost){
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Data data){
			return this.cost - data.cost;
		}

		@Override
		public String toString(){
			return "to = "+to + ", cost = "+cost;
		}
	}
}
