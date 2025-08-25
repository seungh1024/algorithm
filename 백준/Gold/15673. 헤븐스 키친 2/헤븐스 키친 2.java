

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] data = new int[N+1];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		if (N == 2) {
			System.out.println(data[1] * data[2]);
			return;
		}

		long[] lMin = new long[N + 2];
		long[] lMax = new long[N + 2];
		long[] lMinSum = new long[N + 2];
		long[] lMaxSum = new long[N + 2];

		for (int i = 1; i <= N; i++) {
			lMin[i] = Math.min(0, lMin[i - 1] + data[i]);
			lMax[i] = Math.max(0, lMax[i - 1] + data[i]);
			lMinSum[i] = Math.min(lMinSum[i-1], lMin[i]);
			lMaxSum[i] = Math.max(lMaxSum[i - 1], lMax[i]);
		}

		long[] rMin = new long[N + 2];
		long[] rMax = new long[N + 2];
		long[] rMaxSum = new long[N + 2];
		long[] rMinSum = new long[N + 2];

		for (int i = N; i > 0; i--) {
			rMin[i] = Math.min(0, rMin[i + 1] + data[i]);
			rMax[i] = Math.max(0, rMax[i + 1] + data[i]);
			rMinSum[i] = Math.min(rMinSum[i + 1], rMin[i]);
			rMaxSum[i] = Math.max(rMaxSum[i + 1], rMax[i]);
		}


		long result = Long.MIN_VALUE;
		for (int i = 1; i <= N; i++) {
			result = Math.max(result, lMinSum[i] * rMinSum[i + 1]);
			result = Math.max(result, lMaxSum[i] * rMaxSum[i + 1]);
		}
		System.out.println(result);

	}
}
