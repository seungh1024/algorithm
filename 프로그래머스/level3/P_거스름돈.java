package algo_202403;

public class P_거스름돈 {
	public int solution(int n, int[] money) {
		int answer = 0;
		int mod = 1_000_000_007;
		int[] dp = new int[n+1];
		dp[0] = 1;

		int length = money.length;
		for(int i = 0; i < length; i++){
			for(int j = money[i]; j <= n; j++){
				dp[j] = (dp[j]+dp[j-money[i]])%mod;
			}
			// System.out.println(Arrays.toString(dp));
		}

		answer = dp[n];
		return answer;
	}
}
