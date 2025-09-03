

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;
	public static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		long result = 0;
		dp = new long[N][N];
		for (int i = 0; i < N; i++) {

			long v = find((i+1)%N, (i+N - 1)%N, 1)+data[i];
			result = Math.max(result, v);
		}
		System.out.println(result);
	}

	public static long find(int left, int right, int turn) {
		// System.out.println("left = "+left + ", right = "+right);
		if (left == right) {
			if(turn == 0)return data[left];
			return 0;
		}

		if (dp[left][right] != 0) {
			return dp[left][right];
		}

		long max = 0;
		int nextTurn = (turn+1)%2;
		if (turn == 0) {
			max = Math.max(data[left] + find((left+1)%N, right, nextTurn), data[right] + find(left, (right +N- 1)%N, nextTurn));
		} else {
			if (data[left] > data[right]) {
				max = find((left+1)%N, right, nextTurn);
			} else {
				max = find(left, (right +N- 1)%N, nextTurn);
			}
		}

		return dp[left][right] = max;
	}
}
