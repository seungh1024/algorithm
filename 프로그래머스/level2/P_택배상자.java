package algo_202401;

import java.util.*;

public class P_택배상자 {
	public static void main(String[] args) {
		P_택배상자 test = new P_택배상자();
		int[] order = {4,3,1,2,5};
		int answer = test.solution(order);
		int result = 2;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(int[] order) {
		int answer = 0;
		Stack<Integer> left = new Stack<>();
		Stack<Integer> right = new Stack<>();
		int length = order.length;
		for(int i = length; i > 0; i--){
			right.push(i);
		}

		for(int o : order){
			if(!left.isEmpty() && left.peek() == o){
				left.pop();
			}else{
				while(!right.isEmpty() && right.peek() != o){
					left.push(right.pop());
				}
				if(right.isEmpty()){
					break;
				}
				if(right.peek() != o && !left.isEmpty() && left.pop() != o){
					break;
				}else{
					right.pop();
				}
			}



			answer++;
		}

		return answer;
	}
}
