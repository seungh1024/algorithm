package algo_202401;

import java.util.*;

public class P_귤고르기 {
	public static void main(String[] args) {
		P_귤고르기 test = new P_귤고르기();
		int k = 6;
		int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
		int answer = test.solution(k, tangerine);
		int result = 3;
		if (result == answer) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	public int solution(int k, int[] tangerine) {
		int answer = 0;

		Map<Integer,Integer> map = new HashMap<>();
		for(int t : tangerine){
			Integer num = map.get(t);
			if(num == null){
				map.put(t,1);
			}else{
				map.put(t,num+1);
			}
		}

		Queue<Integer> pq = new PriorityQueue<>((o1,o2) -> {
			return o2 - o1;
		});

		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			pq.offer(entry.getValue());
		}

		while(k > 0){
			answer++;
			k-=pq.poll();
		}

		return answer;
	}
}
