package algo_202401;

import java.util.*;

public class P_k진수에서소수개수구하기 {
	public static void main(String[] args) {
		P_k진수에서소수개수구하기 test = new P_k진수에서소수개수구하기();
		int n = 437674;
		int k = 3;
		int result = 3;
		int answer = test.solution(n, k);
		if (result == answer) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(int n, int k) {
		int answer = 0;

		String changedNumber = changeNumber(n,k);

		String[] data = changedNumber.split("0");

		StringTokenizer st = new StringTokenizer(changedNumber,"0");

		while(st.hasMoreTokens()){
			String s = st.nextToken();

			if(s.equals("1")){ // 1은 소수 아니니 continue
				continue;
			}
			if(isCorrect(s)){ // 소수면 ++
				answer++;
			}
		}
		return answer;
	}


	public static String changeNumber(int n, int k){
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		while(n >= k){
			stack.push(n%k);
			n/=k;
		}
		sb.append(n);
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}

		return sb.toString();
	}

	public static boolean isCorrect(String s){
		long number = Long.parseLong(s);
		int check = (int)Math.sqrt(number);

		for(int i = 2; i <= check; i++){
			if(number % i == 0){
				return false;
			}
		}
		return true;
	}

}
