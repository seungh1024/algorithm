package algo_202402;

import java.util.*;

public class P_디펜스게임 {
	public static void main(String[] args) {
		P_디펜스게임 test = new P_디펜스게임();
		int n = 7;
		int k = 3;
		int[] enemy = {4,2,4,5,3,3,1};
		int answer = test.solution(n, k, enemy);
		int result = 5;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(int n, int k, int[] enemy) {
		int answer = 0;

		Queue<Integer> pq = new PriorityQueue<>((o1,o2)->{
			return o2-o1;
		});
		// Queue<Integer> pq = new ArrayDeque<>();
		int length = enemy.length;


		for(int i = 0; i < length; i++){
			int value = enemy[i];
			n -= value;
			pq.offer(value);
			if(n < 0){
				while(!pq.isEmpty() && k > 0){
					n += pq.poll();
					k--;
					if(n >= 0){
						break;
					}
				}
				// answer = i;
				if(n < 0){
					break;
				}
			}
			answer++;
		}


		return answer;
	}
}
