package algo_202401;

import java.util.*;

public class P_뒤에있는큰수찾기 {
	public static void main(String[] args) {
		P_뒤에있는큰수찾기 test = new P_뒤에있는큰수찾기();
		int[] numbers = {9,1,5,3,6,2};
		int[] answer = test.solution(numbers);
		int[] result = {-1,5,6,6,-1,-1};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int[] solution(int[] numbers) {

		int length = numbers.length;
		int[] answer = new int[length];

		Stack<Integer> stack = new Stack<>();

		stack.push(numbers[length-1]);

		answer[length-1] = -1;
		for(int i = length-2; i >= 0; i--){
			int value = stack.pop();

			if(numbers[i] >= value){
				while(!stack.isEmpty()){
					value = stack.pop();
					if(value > numbers[i]){
						break;
					}
				}
			}

			if(value <= numbers[i]){
				answer[i] = -1;
			}else{
				answer[i] = value;
			}
			stack.push(value);
			stack.push(numbers[i]);
		}


		return answer;
	}
}
