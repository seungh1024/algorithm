

import java.io.*;
import java.util.*;

public class Main {
	public static int T,A,S, B;
	public static int[] count;
	public static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		count = new int[4001];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < A; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (count[num] == 0) {
				list.add(num);
			}
			count[num]++;
		}

		int[][] dp = new int[T + 1][A+1];
		int mod = 1000000;
		for (int i = 1; i <= T; i++) {
			for (int j = 1; j <= count[i]; j++) {
				dp[i][j] += 1;
			}

			for (int j = 1; j <= A; j++) {
				dp[i][j] += dp[i - 1][j];
				for (int k = 1; k <= count[i]; k++) {
					if (j - k > 0) {
						dp[i][j] += dp[i - 1][j - k];
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
