package algo_202403;

import java.util.*;

public class R_P_두큐합같게만들기 {
	public int solution(int[] queue1, int[] queue2) {
		int answer = 0;
		long sum1 = 0;
		long sum2 = 0;

		Queue<Integer> q1 = new ArrayDeque<>();
		Queue<Integer> q2 = new ArrayDeque<>();

		int length = queue1.length;
		for(int i = 0; i < length; i++){
			q1.offer(queue1[i]);
			q2.offer(queue2[i]);
			sum1+=queue1[i];
			sum2+=queue2[i];
		}

		int range = 3*length;
		while(true){
			if(answer >= range){
				answer = -1;
				break;
			}
			if(sum1 == sum2){
				break;
			}else if(sum1 > sum2){
				if(q1.isEmpty()){
					answer = -1;
					break;
				}

				int now = q1.poll();
				sum1 -= now;
				sum2 += now;
				q2.offer(now);
			}else if(sum2 > sum1){
				if(q2.isEmpty()){
					answer = -1;
					break;
				}

				int now = q2.poll();
				sum1 += now;
				sum2 -= now;
				q1.offer(now);
			}
			answer++;
		}

		return answer;
	}
}
