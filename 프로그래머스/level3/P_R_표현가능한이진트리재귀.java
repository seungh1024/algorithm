package algo_202403;

import java.util.*;

public class P_R_표현가능한이진트리재귀 {
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
		int move = (temp+1)/4;

		int root = temp/2;
		StringBuilder sb = new StringBuilder();
		String zero = "0";
		for(int i = length; i < temp; i++){
			sb.append(zero);
		}
		binary = sb.toString() + binary;
		char[] data = binary.toCharArray();
		if(data[root] == '0'){
			return 0;
		}

		// System.out.println("data = "+data[root] + ", move = "+move);
		if(!find(root,move,data)){
			result = 0;
		}

		// System.out.println(a);

		return result;
	}

	public static boolean find(int root, int move, char[] data){
		if(move == 0){
			return true;
		}

		if(data[root] == '0'){
			if(data[root-move] == '1' || data[root+move] == '1'){
				return false;
			}
		}

		return find(root-move,move/2,data) & find(root+move,move/2,data);
	}
}
