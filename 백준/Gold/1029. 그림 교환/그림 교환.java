

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] data;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				data[i][j] = input[j] - '0';
			}
		}

		dp = new int[N][1 << 16];

		System.out.println(find(0, 0, 0) + 1);
	}

	public static int find(int idx, int price, int bit) {
		bit = (bit | (1 << idx)); // 현재 지점 방문

		if (dp[idx][bit] > 0) {
			return dp[idx][bit];
		}

		for (int i = 0; i < N; i++) {
			if(idx == i)continue;
			if ((bit & (1 << i)) == 0 && data[idx][i] >= price) {
				dp[idx][bit] = Math.max(dp[idx][bit], find(i, data[idx][i], bit) + 1);
			}
		}

		return dp[idx][bit];
	}

}
