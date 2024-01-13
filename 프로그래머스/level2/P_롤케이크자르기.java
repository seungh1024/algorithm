package algo_202401;

import java.util.*;

public class P_롤케이크자르기 {
	public static void main(String[] args) {
		P_롤케이크자르기 test = new P_롤케이크자르기();
		int[] topping = {1,2,1,3,1,4,1,2};
		int result = 2;
		int answer = test.solution(topping);
		if (result == answer) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(int[] topping) {
		int answer = 0;
		int length = topping.length;
		if(length == 1){
			return 0;
		}
		int[] left = new int[10001];
		int[] right = new int[10001];
		left[topping[0]]++;
		int leftSize = 1;
		int rightSize = 0;
		for(int i = 1; i < length; i++){
			if(right[topping[i]] == 0){
				rightSize++;
			}
			right[topping[i]]++;
		}

		for(int i = 1; i < length; i++){
			if(leftSize == rightSize){
				answer++;
			}
			if(left[topping[i]] == 0){
				leftSize++;
			}
			left[topping[i]]++;

			right[topping[i]]--;
			if(right[topping[i]] == 0){
				rightSize--;
			}
		}
		return answer;
	}
}
