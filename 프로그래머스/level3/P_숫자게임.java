package algo_202403;

import java.util.*;

public class P_숫자게임 {
	public int solution(int[] A, int[] B) {
		int answer = 0;
		Arrays.sort(A);
		Arrays.sort(B);

		int ai = 0;
		int bi = 0;
		int length = A.length;
		while(ai < length && bi < length){
			if(A[ai] < B[bi]){
				ai++;
				bi++;
				answer++;
			}else{
				bi++;
			}
		}
		return answer;
	}
}
