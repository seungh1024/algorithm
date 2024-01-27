package algo_202401;

import java.util.*;

public class P_줄서는방법 {
	public static void main(String[] args) {
		P_줄서는방법 test = new P_줄서는방법();
		int n = 3;
		long k = 5;
		int[] answer = test.solution(n, k);
		int[] result = {3,1,2};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int[] solution(int n, long k) {
		int[] answer = new int[n];
		long[] count = new long[n+1];
		long num = 1;
		for(int i = 2; i <= n-1; i++){
			num *= i;
		}
		int mod = n-1;
		for(int i = 1; i<n; i++){
			count[i] = num;
			num /= mod;
			mod--;
		}
		// System.out.println(Arrays.toString(count));

		boolean[] visited = new boolean[n+1];
		int index = 1;
		while(index <= n){
			int target = 1;
			for(int i = 1; i <= n; i++){
				if(visited[i]) continue;
				target = i;
				if(count[index] < k){
					k-= count[index];

				}else{
					break;
				}
			}
			// System.out.println("target: "+target+ ", k: "+k);
			answer[index-1] = target;
			index++;
			visited[target] = true;

		}



		return answer;
	}
}
