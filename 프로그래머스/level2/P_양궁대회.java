package algo_202402;

import java.util.*;

public class P_양궁대회 {
	public static void main(String[] args) {
		P_양궁대회 test = new P_양궁대회();
		int n = 10;
		int[] info = {0,0,0,0,0,0,0,0,3,4,3};
		int[] answer = test.solution(n, info);
		int[] result = {1,1,1,1,1,1,1,1,0,0,2};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static int[] result;
	public static int max, min;
	public static int MAX_SIZE = 11;

	public int[] solution(int n, int[] info) {
		int[] answer = {-1};
		int[] lion = new int[MAX_SIZE];
		result = new int[MAX_SIZE];
		max = 0;
		min = MAX_SIZE;

		find(n,0,info,lion,MAX_SIZE);

		if(!Arrays.equals(new int[11],result)){
			answer = result;
		}

		return answer;
	}

	public static void find(int n, int index, int[] info, int[] lion, int minValue){
		if(n == 0){
			int ac = 0; // apeach count
			int lc = 0; // lion count
			for(int i = 0; i < MAX_SIZE ; i++){
				if(lion[i] <= info[i] && info[i] > 0){
					ac += (10-i);
				}else if(lion[i] > info[i] && lion[i] > 0){
					lc += (10-i);
				}
			}

			if(lc > ac){

				if(max < Math.abs(lc-ac)){
					max = Math.abs(lc-ac);
					for(int i = 0; i < MAX_SIZE; i++){
						result[i] = lion[i];
					}
					min = minValue;
				}else if(max == Math.abs(lc-ac) && minValue < min){
					for(int i = 0; i < MAX_SIZE; i++){
						result[i] = lion[i];
					}
					min = minValue;
				}
			}
			return;
		}

		if(index >= MAX_SIZE) {
			return;
		}

		if(n >= info[index]+1){
			lion[index] = info[index]+1;
			find(n-info[index]-1,index+1,info,lion,MAX_SIZE-1-index);
			lion[index] = 0;
		}
		if(n > 0){
			lion[index] = n;
			find(0,index+1,info,lion,MAX_SIZE-1-index);
			lion[index] = 0;
		}
		find(n,index+1,info,lion,minValue);

	}
}
