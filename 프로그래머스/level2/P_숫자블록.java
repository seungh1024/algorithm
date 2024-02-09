package algo_202402;

import java.util.*;

public class P_숫자블록 {
	public static void main(String[] args) {
		P_숫자블록 test = new P_숫자블록();
		long begin = 1;
		long end = 10;
		int[] answer = test.solution(begin, end);
		int[] result = {0, 1, 1, 2, 1, 3, 1, 4, 3, 5};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int[] solution(long begin, long end) {
		int length = (int)(end-begin)+1;
		int[] answer = new int[length];
		Arrays.fill(answer,1);
		long max = 10_000_000;


		// int index = 0;
		for(long i = begin; i <= end; i++){
			long target = (long)Math.sqrt(i);
			target = Math.min(target,max);

			int index = (int)(i-begin);

			for(long r = 2; r <= target; r++){
				if(i%r == 0){
					if(i/r <= max){
						answer[index] = Math.max(answer[index],(int)(i/r));
						break;
					}else{
						answer[index] = Math.max(answer[index],(int)r);
					}

					// break;
				}
			}


		}

		if(begin == 1) answer[0] = 0;

		return answer;
	}
}
