package algo_202402;

public class P_3xn타일링 {
	public static void main(String[] args) {
		P_3xn타일링 test = new P_3xn타일링();
		int n = 4;
		int answer = test.solution(n);
		int result = 11;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	private final static int MOD_NUM = 1_000_000_007;
	public int solution(int n) {
		int answer = 0;

		if(n % 2 != 0){
			return 0;
		}
		if(n == 2){
			return 3;
		}
		// n = 5000;
		long[] dp = new long[n+1];
		dp[0] = 1;
		dp[2] = 3;

		for(int i = 4; i <= n; i+=2){
			if(dp[i-2]*4< dp[i-4]){
				dp[i] = (dp[i-2]*4 - dp[i-4] + MOD_NUM)%MOD_NUM;
			}else{
				dp[i] = (dp[i-2]*4 - dp[i-4])%MOD_NUM;
			}


		}
		// System.out.println(Arrays.toString(dp));
		return (int)dp[n];
	}
}
