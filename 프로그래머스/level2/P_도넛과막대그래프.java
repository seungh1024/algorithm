package algo_202402;

import java.util.Arrays;

public class P_도넛과막대그래프 {
	public static void main(String[] args) {
		P_도넛과막대그래프 test = new P_도넛과막대그래프();
		int[][] edges = {{2,3},{4,3},{1,1},{2,1}};
		int[] answer = test.solution(edges);
		int[] result = {2,1,1,0};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	private static int[] parent;
	public int[] solution(int[][] edges) {
		int size = 1_000_001;
		int[] count = new int[size];
		int start = 0;
		int max = 0;
		int[] next = new int[size];
		parent = new int[size];
		for(int[] edge: edges){
			count[edge[0]]++;
			if(count[edge[0]] > max){
				start = edge[0];
				max = count[edge[0]];
			}
			next[edge[0]] = edge[1];
			next[edge[1]] = -1;
			if(edge[0] == edge[1]){
				next[edge[1]] = edge[1];
			}
			parent[edge[0]] = edge[0];
			parent[edge[1]] = edge[1];
		}

		int line = 0;
		int graph = 0;
		for(int i = 0; i < size; i++){
			if(count[i] == 0 && parent[i] != 0){
				line++;
			}
			if(i != start && count[i] == 2){
				graph++;
			}
		}

		int[] answer = {start,max-line-graph,line,graph};
		return answer; // [정점,도넛(doughnut), 막대(line), 8자(graph)]
	}
}
