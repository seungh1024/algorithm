

import java.io.*;
import java.util.*;

public class Main {
	public static long N;
	public static int M;
	public static int size;
	public static long MOD = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		if (N < M) {
			System.out.println(1);
			return;
		}
		if (N == M) {
			System.out.println(2);
			return;
		}
		if (N == M + 1) {
			System.out.println(3);
			return;
		}

		size = M + 1;
		long exp = N - M - 1;

		long[][] data = new long[size][size];
		for (int i = 0; i < size-1; i++) {
			data[i][i+1] = 1;
		}
		data[size-1][1] = 1;
		data[size-1][size-1] = 1;

		long[][] A = power(data,exp);

		long result = 0;
		for (int i = 0; i < size - 2; i++) {
			result = (result+A[size-1][i])%MOD;
		}
		result = (result+A[size-1][size-2]*2)%MOD;
		result = (result+A[size-1][size-1]*3)%MOD;

		System.out.println(result);
	}

	private static long[][] power(long[][] data, long exp) {
		long[][] result = new long[size][size];

		for (int i = 0; i < size; i++) {
			result[i][i] = 1;
		}

		while (exp > 0) {
			if ((exp & 1L) == 1L) {
				result = multiply(result,data);
			}
			data = multiply(data,data);
			exp >>=1;
		}
		return result;

	}

	private static long[][] multiply(long[][] A, long[][] B) {

		long[][] C = new long[size][size];

		for (int i = 0; i < size; i++) {
			for (int k = 0; k < size; k++) {
				long aik = A[i][k];
				if(aik == 0) continue;
				for (int j = 0; j < size; j++) {
					C[i][j] = (C[i][j] + A[i][k]*B[k][j])%MOD;
				}
			}
		}

		return C;
	}
}
