package algo_202404;

import java.util.*;

public class P_최고의집합 {
	public int[] solution(int n, int s) {
		int[] answer = new int[n];
		int value = s/n;
		int mod = s%n;

		if(value == 0){
			return new int[]{-1};
		}

		Arrays.fill(answer,value);
		int index = n-1;
		while(mod-->0){
			answer[index--] ++;
		}

		return answer;
	}
}
