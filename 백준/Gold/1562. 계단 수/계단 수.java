

import java.io.*;

public class Main {
	public static int N;
	public static int MOD = 1000000000;
	public static int[][][] dp = new int[10][101][1024];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int result = 0;

		for (int i = 1; i <= 9; i++) {
			result += find(i, 1, 1 << i);
			result %= MOD;
		}

		System.out.println(result);
	}

	public static int find(int num, int length, int bit) {
		if (dp[num][length][bit] != 0) {
			return dp[num][length][bit];
		}
		if (length == N) {
			if(bit == 1023) return 1;
			return 0;
		}

		int temp = 0;
		if (num < 9) {
			int next = num+1;
			temp += find(next, length + 1, bit | (1 << next));
		}
		if (num > 0) {
			int next = num-1;
			temp += find(next, length + 1, bit | (1 << next));
		}
		temp%=MOD;
		return dp[num][length][bit] = temp;
	}
}

