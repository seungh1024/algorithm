package algo_202403;

public class P_정수삼각형 {
	public int solution(int[][] triangle) {
		int answer = 0;
		int N = triangle.length;
		int M = triangle[N-1].length;
		int[][] dp = new int[N][M];
		for(int i = 0; i < N; i++){
			int range = triangle[i].length;
			for(int j = 0; j < range; j++){
				dp[i][j] = triangle[i][j];
			}
		}

		for(int i = 0; i < N-1; i++){
			int range = triangle[i].length;
			for(int j = 0; j < range; j++){
				dp[i+1][j] = Math.max(dp[i+1][j],triangle[i+1][j] + dp[i][j]);
				if(j+1 < M){
					dp[i+1][j+1] = Math.max(dp[i+1][j+1],triangle[i+1][j+1]+dp[i][j]);
				}

			}
			// System.out.println(Arrays.toString(dp[i]));
		}

		for(int j = 0; j < M; j++){
			answer = Math.max(dp[N-1][j],answer);
		}

		return answer;
	}
}
