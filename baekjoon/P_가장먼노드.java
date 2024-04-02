package algo_202403;

import java.util.*;

public class P_가장먼노드 {
	public static int N;
	public static List<Integer>[] list;
	public static boolean[] visited;

	public int solution(int n, int[][] edge) {
		int answer = 0;
		N = n;
		list = new ArrayList[n+1];
		for(int i = 1; i <= n; i++){
			list[i] = new ArrayList<>();
		}

		for(int[] input : edge){
			int from = input[0];
			int to = input[1];
			list[from].add(to);
			list[to].add(from);
		}

		answer = find();

		return answer;
	}

	public static int find(){
		int result = 0;

		visited = new boolean[N+1];
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		visited[1] = true;

		while(!q.isEmpty()){
			int size = q.size();
			for(int s = 0; s < size; s++){
				int now = q.poll();

				for(int next : list[now]){
					if(!visited[next]){
						q.offer(next);
						visited[next] = true;
					}
				}
			}
			if(!q.isEmpty()){
				result = q.size();
			}
		}


		return result;
	}
}
