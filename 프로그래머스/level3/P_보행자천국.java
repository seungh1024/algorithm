package algo_202403;

public class P_보행자천국 {
	public static int MOD = 20170805;
	public static int[][] dp;

	public int solution(int m, int n, int[][] cityMap) {
		int answer = 0;

		dp = new int[m+2][n+2];
		dp[1][1] = 1;

		for(int i = 1; i <= m; i++){
			for(int j = 1; j <= n; j++){
				if(cityMap[i-1][j-1] == 0){
					dp[i][j] += dp[i-1][j] + dp[i][j-1];
					dp[i][j]%=MOD;
				}else if(cityMap[i-1][j-1] == 2){
					int index = i;
					while(index < m && cityMap[index][j-1] == 2){
						index++;
					}
					if(index < m && cityMap[index][j-1] != 1){
						dp[index+1][j] += dp[i-1][j];
						dp[index+1][j] %=MOD;
					}


					index = j;
					while(index < n && cityMap[i-1][index] == 2){
						index++;
					}
					if(index < n && cityMap[i-1][index] != 1){
						dp[i][index+1] += dp[i][j-1];
						dp[i][index+1]%=MOD;
					}
				}
			}
		}
		answer = dp[m][n];

		return answer;
	}
}
