package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_16400_소수화폐 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] visited = new boolean[N+1];
		int range = (int)Math.sqrt(N);
		for(int i = 2; i <= range; i++){
			if (!visited[i]) {
				for (int j = 2; i*j <= N; j++) {
					visited[i*j] = true;
				}
			}
		}

		int[] dp = new int[N+1];
		List<Integer> list = new ArrayList<>();
		for (int i = 2; i <= N; i++) {
			if(!visited[i]){
				// dp[i] = 1;
				list.add(i);
			}
		}
		// System.out.println(list);

		dp[0] = 1;
		for (int num : list) {
			for (int i = 2; i <= N; i++) {
				if(i-num < 0) continue;

				dp[i] += dp[i-num];
				dp[i] %= 123456789;
			}
			// System.out.println(Arrays.toString(dp));
		}

		System.out.println(dp[N]);
	}
}
