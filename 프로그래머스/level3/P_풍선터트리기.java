package algo_202403;

import java.util.*;

public class P_풍선터트리기 {
	public int solution(int[] a) {
		int answer = 0;
		int min = Integer.MAX_VALUE;
		int length = a.length;
		int[] count = new int[length];
		for(int i = 0; i < length; i++){
			if(a[i] < min){
				min = a[i];
				count[i]++;
			}
		}

		min = Integer.MAX_VALUE;
		for(int i = length-1; i >=0; i--){
			if(a[i] < min){
				min = a[i];
				count[i]++;
			}
		}

		for(int i = 0; i < length; i++){
			if(count[i] >0){
				answer++;
			}
		}
		return answer;
	}
}
