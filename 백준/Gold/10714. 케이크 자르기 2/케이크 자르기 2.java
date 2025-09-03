

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static long[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		long result = 0;
		for (int i = 0; i < N; i++) {
			data = new int[N-1];
			int idx = (i + 1) % N;
			for(int j = 0; j < N-1; j++){
				data[j] = input[idx];
				idx = (idx + 1) % N;
			}
			dp = new long[N][N][2];
			long v = find(0, N - 2, 1) + input[i];
			result = Math.max(result, v);
		}
		System.out.println(result);
	}

	public static long find(int left, int right, int turn) {
		// System.out.println("left = "+left + ", right = "+right);
		if (left > right) {
			return 0;
		}

		if (dp[left][right][turn] != 0) {
			return dp[left][right][turn];
		}

		long max = 0;
		int nextTurn = (turn+1)%2;
		if (turn == 0) {
			max = Math.max(data[left] + find(left+1, right, nextTurn), data[right] + find(left, right - 1, nextTurn));
		} else {
			if (data[left] > data[right]) {
				max = find(left + 1, right, nextTurn);
			} else {
				max = find(left, right - 1, nextTurn);
			}
		}

		return dp[left][right][turn] = max;
	}
}
