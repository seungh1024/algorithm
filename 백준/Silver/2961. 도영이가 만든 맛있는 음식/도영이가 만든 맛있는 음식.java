

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] S, B;
	public static long result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}

		result = Long.MAX_VALUE;

		find(0, 1, 0);
		System.out.println(result);
	}

	public static void find(int idx, long mul, long sum) {

		// System.out.println("idx = " + idx + ", sum = " + sum + ", mul = " + mul);
		if (sum > 0) {
			result = Math.min(result, Math.abs(mul - sum));
		}

		if (idx >= N) {
			return;
		}

		find(idx + 1, mul, sum);
		find(idx + 1, mul * S[idx], sum + B[idx]);
	}
}
