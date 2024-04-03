package algo_202403;

import java.util.*;

public class P_합승택시요금 {
	public static List<Data>[] list;
	public int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 0;
		list = new ArrayList[n+1];
		for(int i = 1 ; i <= n; i++){
			list[i] = new ArrayList<>();
		}
		for(int[] f : fares){
			int from = f[0];
			int to = f[1];
			int cost = f[2];
			list[from].add(new Data(to,cost));
			list[to].add(new Data(from,cost));
		}
		int[] A = new int[n+1];
		int[] B = new int[n+1];
		int[] S = new int[n+1];
		find(A,a,n);
		find(B,b,n);
		find(S,s,n);
		int min = Integer.MAX_VALUE;
		for(int i = 1; i <= n; i++){
			int sum = A[i]+B[i]+S[i];
			if(sum < 0 ) continue;
			// System.out.println("A = "+A[i] + ", B = "+B[i] + ", S = "+S[i]);
			min = Math.min(min,sum);
		}
		// min = Math.min(min, A[s]+B[s]);
		// min = Math.min(min,S[b] + A[b]);
		// min = Math.min(min,S[a] + B[a]);
		answer = min;
		return answer;
	}

	public static void find(int[] array, int start, int n){
		boolean[] visited = new boolean[n+1];
		Queue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(start,0));
		Arrays.fill(array,Integer.MAX_VALUE);
		array[start] = 0;

		while(!pq.isEmpty()){
			Data now = pq.poll();

			// if(array[now.to] < now.cost) continue;
			if(visited[now.to]) continue;
			visited[now.to] = true;


			for(Data next : list[now.to]){
				if(!visited[next.to] && array[next.to] > array[now.to] + next.cost){
					array[next.to] = array[now.to] + next.cost;
					pq.offer(new Data(next.to,array[next.to]));
				}
			}
		}
		// System.out.println(Arrays.toString(array));
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

		@Override
		public String toString(){
			return "to = "+to + ", cost = "+cost;
		}
	}
}
