package algo_202404;

import java.util.*;

public class P_공이동시뮬레이션 {
	public long solution(int n, int[] works) {
		long answer = 0;
		long length = works.length;

		Queue<Integer> pq = new PriorityQueue<>((o1,o2)->{
			return o2-o1;
		});

		for(int i = 0; i < length; i++){
			pq.offer(works[i]);
		}

		while(!pq.isEmpty() && n -- > 0){
			int now = pq.poll();
			// System.out.println(now);
			now--;
			if(now > 0){
				pq.offer(now);
			}
		}


		while(!pq.isEmpty()){
			long now = pq.poll();
			answer += (now*now);
		}

		return answer;
	}
}
