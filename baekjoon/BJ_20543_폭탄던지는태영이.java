package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_20543_폭탄던지는태영이 {
	public static int N, M;
	public static long[][] data;
	public static long[][] result;
	public static int size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		data = new long[N+1][N+1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Long.parseLong(st.nextToken());
			}
		}


		result = new long[N][N];
		size = (M-1)/2;

		for (int i = N - 1; i >= 0; i--) {
			for (int j = N - 1; j > 0; j--) {
				data[i][j] = data[i][j] - data[i][j-1];
			}
		}
		for (int j = 0; j < N; j++) {
			for (int i = N - 1; i > 0; i--) {
				data[i][j] = data[i][j] - data[i-1][j];
			}
		}
		// printData();

		for (int i = 0; i <=N-M; i++) {
			for (int j = 0; j <= N-M; j++) {
				if (data[i][j] < 0) {
					long value = -data[i][j];
					data[i][j] += value;
					data[i + M][j] -= value;
					data[i][j + M] -= value;
					data[i + M][j + M] += value;
					result[i+size][j+size] += value;
				}
			}
		}


		// printData();

		// System.out.println("result");
		// for (int i = 0; i < N; i++) {
		// 	System.out.println(Arrays.toString(result[i]));
		// }
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void printData() {
		System.out.println("print data");
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(data[i]));
		}


	}
}
