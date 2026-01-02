

import java.io.*;
import java.util.*;

public class Main {
	public static long MOD = 100_000_007;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());

			if (K == 0) {
				long x = 2;
				long result = 1;
				while (N > 0) {
					if (N % 2 > 0) {
						result = (result * x) % MOD;
					}
					x = (x * x) % MOD;
					N/=2;
				}
				sb.append(result).append("\n");
				continue;
			}
			if (N <= K) {
				sb.append("1\n");
				continue;
			}
			if (N == K + 1) {
				sb.append("2\n");
				continue;
			}
			if (N == K + 2) {
				sb.append("3\n");
				continue;
			}

			int size = K + 2;
			int power = N - K - 2;

			long[][] base = new long[size][size];
			for (int i = 0; i < size - 1; i++) {
				base[i][i+1] = 1;
			}
			base[size-1][1] = 1;
			base[size-1][size-1] = 1;

			long[][] result = new long[size][size];
			for (int i = 0; i < size - 2; i++) {
				result[i][0] = 1;
			}
			result[size-2][0] = 2;
			result[size-1][0] = 3;
			base = find(base, size, power);
			result = matrixMultiply(base, result, size);

			sb.append(result[size - 1][0]).append("\n");
		}
		System.out.println(sb);
	}


	public static long[][] find(long[][] base, int size, int power) {
		long[][] result = new long[size][size];
		for (int i = 0; i < size; i++) {
			result[i][i] = 1;
		}

		while (power > 0) {
			if ((power & 1) == 1) {
				result = matrixMultiply(result, base, size);
			}
			base = matrixMultiply(base, base, size);
			power >>= 1;
		}

		return result;
	}
	public static long[][] matrixMultiply(long[][] A, long[][] B, int size) {
		long[][] result = new long[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int k = 0; k < size; k++) {
					long temp = A[i][k] * B[k][j] % MOD;
					result[i][j] += temp;
					result[i][j] %= MOD;
				}
			}
		}

		return result;
	}


}
