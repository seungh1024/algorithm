

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		int[] count = new int[T + 1];
		int[] nums = new int[A + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= A; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			count[nums[i]]++;
		}

		int mod = 1_000_000;
		int[][] dp = new int[T+1][A + 1];
		for (int i = 1; i <= T; i++) {

			// 어떤 숫자를 그 개수만큼 고를 때의 경우의 수는 기본적으로 1임. 초기화를 한다.
			for (int j = 1; j <= count[i]; j++) {
				dp[i][j] ++;
			}

			for (int j = 1; j <= A; j++) {
				dp[i][j] += dp[i - 1][j]; // i번째 선택 안하고 i-1번째의 결과를 그대로 가져오는 경우.
				for (int k = 1; k <= count[i]; k++) {
					if (j - k > 0) {
						dp[i][j] += dp[i-1][j-k];
						dp[i][j] %= mod;
					}
				}
			}
		}

		int result = 0;
		for (int j = S; j <= B; j++) {
			result += dp[T][j];
			result %= mod;
		}
		System.out.println(result);
	}
}
