

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] data = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] A = new int[N + 2][N + 2];
		int[][] B = new int[N + 2][N + 2];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				A[i][j] += A[i-1][j-1] + data[i][j];
			}
			for (int j = N; j > 0; j--) {
				B[i][j] += B[i -1][j + 1] + data[i][j];
			}
		}

		// for (int i = 0; i <= N + 1; i++) {
		// 	System.out.println(Arrays.toString(A[i]));
		// }
		// System.out.println("=====");
		// for (int i = 0; i <= N + 1; i++) {
		// 	System.out.println(Arrays.toString(B[i]));
		// }

		int max = Integer.MIN_VALUE;
		for (int s = 1; s <= N; s++) {
			// System.out.println("s = "+s);
			for (int i = 1; i + s - 1 <= N; i++) {
				for (int j = 1; j + s - 1 <= N; j++) {
					int a = A[i + s - 1][j + s - 1] - A[i-1][j-1];
					int b = B[i + s - 1][j] - B[i - 1][j + s];
					int sum =  a - b;
					// System.out.println("i = " + i + ", j = " + j + ", sum = " + sum + ", a = " + a + ", b= " + b);
					max = Math.max(max, sum);
				}
			}
		}

		System.out.println(max);
	}
}
