package algo_202401;

import java.util.*;

public class P_숫자카드나누기 {
	public static void main(String[] args) {
		P_숫자카드나누기 test = new P_숫자카드나누기();
		int[] arrayA = {10,20};
		int[] arrayB = {5,17};
		int answer = test.solution(arrayA, arrayB);
		int result = 10;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;
		int length = arrayA.length;
		Arrays.sort(arrayA);
		Arrays.sort(arrayB);

		for(int r = arrayA[0]; r > 1; r--){
			boolean check = false;
			for(int i = 0; i < length; i++){
				if(!(arrayA[i]%r == 0 && arrayB[i]%r > 0)){
					check = true;
					break;
				}
			}
			if(!check){
				answer = r;
				break;
			}
		}

		for(int r = arrayB[0]; r > 1; r--){
			boolean check = false;
			for(int i = 0; i < length; i++){
				if(!(arrayB[i]%r == 0 && arrayA[i]%r > 0)){
					check = true;
					break;
				}
			}
			if(!check){
				answer = Math.max(answer,r);
				break;
			}
		}

		return answer;
	}
}
