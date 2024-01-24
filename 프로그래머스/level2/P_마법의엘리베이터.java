package algo_202401;

import java.util.*;

public class P_마법의엘리베이터 {
	public static void main(String[] args) {
		P_마법의엘리베이터 test = new P_마법의엘리베이터();
		int storey = 2554;
		int answer = test.solution(storey);
		int result = 16;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	public int solution(int storey) {
		int answer = 0;

		Deque<Integer> deque = new ArrayDeque<>();

		int divideNumber = 10;
		while(divideNumber <= storey){
			divideNumber*=10;
		}
		divideNumber/=10;
		while(divideNumber > 0){
			deque.offerFirst(storey/divideNumber);
			storey %= divideNumber;
			divideNumber /= 10;
		}

		while(!deque.isEmpty()){
			int now = deque.pollFirst();

			if(now > 5){
				if(!deque.isEmpty()){
					int next = deque.pollFirst();
					next++;
					deque.offerFirst(next);

				}else{
					deque.offerFirst(1);
				}
				answer += (10-now);

			}else if(now < 5){
				answer += now;
			}else if(now == 5){
				if(!deque.isEmpty()){
					int next = deque.pollFirst();
					if(next >= 5){
						next++;
						answer += (10-now);
					}else{
						answer += now;
					}
					deque.offerFirst(next);
				}else{
					answer += now;
				}
			}
			// System.out.println("now: "+now + ", answer: "+answer);
		}



		return answer;
	}
}
