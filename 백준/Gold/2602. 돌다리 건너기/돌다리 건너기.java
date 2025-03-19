

import java.io.*;
import java.util.*;

public class Main {
	public static char[] input;
	public static char[][] data;
	public static int N, M;
	public static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().toCharArray();
		char[] arr1 = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();
		N = input.length;
		M = arr1.length;
		data = new char[2][M];
		data[0] = arr1;
		data[1] = arr2;

		dp = new int[2][N][M];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		int sum = find(0, 0, 0);
		sum += find(1, 0, 0);

		System.out.println(sum);
	}

	public static int find(int upDownIdx, int inputIdx, int dataIdx) {
		if (inputIdx >= N) {
			return 1;
		}
		if (dataIdx >= M) {
			return 0;
		}

		if (dp[upDownIdx][inputIdx][dataIdx] != -1) {
			return dp[upDownIdx][inputIdx][dataIdx];
		}

		int cnt = 0;
		for (int i = dataIdx; i < M; i++) {
			if (data[upDownIdx][i] == input[inputIdx]) {
				cnt += find((upDownIdx + 1) % 2, inputIdx + 1, i + 1);
			}
		}

		return dp[upDownIdx][inputIdx][dataIdx] = cnt;
	}
}
