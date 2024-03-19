package algo_202403;

import java.util.*;

public class R_P_표현가능한이진트리 {
	public static int N;
	public int[] solution(long[] numbers) {
		N = numbers.length;
		int[] answer = new int[N];

		for(int i = 0; i < N; i++){
			long number = numbers[i];
			if(number < 4){
				answer[i] = 1;
			}else{
				answer[i] = makeResult(number);
			}

		}

		return answer;
	}

	public static int makeResult(long number){
		int result = 1;
		String binary = Long.toBinaryString(number);
		int length = binary.length();
		int temp = 1;
		while(length >= temp){
			temp *= 2;
		}
		temp --;
		int root = temp/2;
		StringBuilder sb = new StringBuilder();
		String zero = "0";
		for(int i = length; i < temp; i++){
			sb.append(zero);
		}
		binary = sb.toString() + binary;
		char[] data = binary.toCharArray();
		if(data[root] -'0' == 0 || !isValid(root+1,temp,data) || !isValid(0,root,data)){
			return 0;
		}

		return result;
	}

	public static boolean isValid(int left, int right, char[] data){
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		for(int i = left; i < right; i++){
			stack1.push(data[i]-'0');
		}

		while(stack1.size()>=3){
			while(stack1.size()>=3){
				int end = stack1.pop();
				int mid = stack1.pop();
				int start = stack1.pop();
				if(mid == 0 && (start|end) == 1){
					return false;
				}
				stack2.push(mid);
				if(!stack1.isEmpty()){
					stack2.push(stack1.pop()); // 3개씩 묶음 단위의 부모를 그냥 넣어줌
				}
			}
			while(!stack2.isEmpty()){
				stack1.push(stack2.pop());
			}
		}

		return true;
	}
}
