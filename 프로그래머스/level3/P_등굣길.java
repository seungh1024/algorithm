package algo_202403;

public class P_등굣길 {
	public static int[][] data;
	public int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		data = new int[n+1][m+1];
		for(int[] p : puddles){
			data[p[1]][p[0]] = -1;
		}
		data[1][1] = 1;
		int mod = 1_000_000_007;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= m; j++){
				if(data[i][j] == -1) continue;
				if(data[i-1][j] != -1){
					data[i][j] = (data[i][j] + data[i-1][j])%mod;
				}
				if(data[i][j-1] != -1){
					data[i][j] = (data[i][j] + data[i][j-1])%mod;
				}
				// data[i][j] += data[i-1][j] + data[i][j-1];
			}
			// System.out.println(Arrays.toString(data[i]));
		}
		answer = data[n][m];
		return answer;
	}
}
