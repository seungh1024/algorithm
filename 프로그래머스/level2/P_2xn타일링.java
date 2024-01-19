package algo_202401;

public class P_2xn타일링 {
	public static void main(String[] args) {
		P_2xn타일링 test = new P_2xn타일링();
		int n = 4;
		int answer = test.solution(n);
		int result = 5;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(int n) {
		int answer = 0;
		if(n <= 3){
			return n;
		}
		int mod = 1000000007;
		int[] dp = new int[n+1];
		for(int i = 1; i <= 3; i++){
			dp[i] = i;
		}
		for(int i = 4; i <= n; i++){
			dp[i] = (dp[i-1]+dp[i-2])%mod;
		}
		answer = dp[n];
		return answer;
	}

}
