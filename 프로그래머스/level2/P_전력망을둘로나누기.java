package algo_202401;

import java.util.*;

public class P_전력망을둘로나누기 {
	public static void main(String[] args) {
		P_전력망을둘로나누기 test = new P_전력망을둘로나누기();
		int n = 4;
		int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
		int answer = test.solution(n, wires);
		int result = 0;
		if (result == answer) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static List<Integer>[] list;

	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;

		list = new ArrayList[n+1];
		for(int i = 1; i <= n; i++){
			list[i] = new ArrayList<>();
		}
		for(int[] wire : wires){
			list[wire[0]].add(wire[1]);
			list[wire[1]].add(wire[0]);
		}

		int max = Integer.MAX_VALUE;
		for(int[] wire : wires){
			int result = find(n,wire[0],wire[1]);
			answer = Math.min(answer,result);
		}

		return answer;
	}

	public static int find(int n, int from, int to){
		boolean[] visited = new boolean[n+1];
		visited[from] = true;
		visited[to] = true;

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(from);
		int count = 1;
		while(!q.isEmpty()){
			int now = q.poll();

			for(int next : list[now]){
				if(!visited[next]){
					count++;
					visited[next]=true;
					q.offer(next);
				}
			}
		}

		return Math.abs((n-count) - count);
	}
}
