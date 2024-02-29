package algo_202402;

import java.util.*;

public class R_P_도넛과막대그래프 {
	public int[] solution(int[][] edges) {
		int size = 1_000_001;
		int[] outCount = new int[size]; // 현재 노드에서 다음 노드로 가는 길 개수
		int[] inCount = new int[size]; // 현재 노드로 들어오는 길 개수
		boolean[] check = new boolean[size]; // 노드의 존재 유무 체크
		List<Integer>[] list = new ArrayList[size];
		for(int i = 1; i < size; i++){
			list[i] = new ArrayList<>();
		}

		for(int[] edge : edges){
			int from = edge[0];
			int to = edge[1];
			list[from].add(to);
			outCount[from]++;
			inCount[to]++;
			check[from] = true;
			check[to] = true;
		}

		int max = 0;
		int start = 0;
		for(int i = 1; i < size; i++){
			if(inCount[i] == 0 && outCount[i] >= 2){
				max = outCount[i];
				start = i;
				break;
			}
		}



		// 정점으로부터 들어가는 점 제거
		for(int next : list[start]){
			inCount[next]--;
		}

		int doughnut = 0;
		int stick = 0;
		int eight = 0;
		for(int i = 1; i < size; i++){
			if(check[i] && outCount[i] == 0){
				stick++;
			}else if(outCount[i] == 2 && inCount[i] == 2){
				eight++;
			}
		}


		int[] answer = {start,max-stick-eight,stick,eight};

		return answer;
	}
}
