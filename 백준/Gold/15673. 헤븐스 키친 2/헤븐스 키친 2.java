

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N+2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		long[] lMax = new long[N+2];
		long[] lMin = new long[N+2];
		long[] rMax = new long[N+2];
		long[] rMin = new long[N+2];
		long[] lMaxSum = new long[N + 2];
		long[] lMinSum = new long[N + 2];
		long[] rMaxSum = new long[N + 2];
		long[] rMinSum = new long[N + 2];

		for (int i = 1; i <= N; i++) {
			lMax[i] = Math.max(0, lMax[i - 1] + data[i]);
			lMaxSum[i] = Math.max(lMaxSum[i - 1], lMax[i]);
			
			lMin[i] = Math.min(0, lMin[i - 1] + data[i]);
			lMinSum[i] = Math.min(lMinSum[i - 1], lMin[i]);
		}
		for (int i = N; i > 0; i--) {
			rMax[i] = Math.max(0, rMax[i + 1] + data[i]);
			rMaxSum[i] = Math.max(rMaxSum[i + 1], rMax[i]);

			rMin[i] = Math.min(0, rMin[i + 1] + data[i]);
			rMinSum[i] = Math.min(rMinSum[i + 1], rMin[i]);
		}

		if (N == 2) {
			System.out.println(data[1] * data[2]);
			return;
		}

		long result = 0;
		for(int i = 1; i <= N; i++){
			result = Math.max(lMaxSum[i - 1] * rMaxSum[i], result);
			result = Math.max(result, lMinSum[i - 1] * rMinSum[i]);
		}
		System.out.println(result);
	}
}
