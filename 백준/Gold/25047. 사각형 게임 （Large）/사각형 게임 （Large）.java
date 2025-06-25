

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] data;
	public static int[] indexes;
	public static boolean[] visited;
	public static long result = Long.MIN_VALUE;
	public static long[] rowSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		rowSum = new long[N];
		for (int i = 0; i < N; i++) {
			long sum = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				sum += data[i][j];
			}
			rowSum[i] = sum;
		}

		visited = new boolean[N];

		find(0);
		System.out.println(result);
	}

	public static void find(int idx) {
		if (idx == N) {
			long max = 0;
			for (int i = 0; i < N; i++) {

				if (visited[i]) {
					max += rowSum[i];
				}
			}

			// System.out.println("woo = "+max);

			for (int j = 0; j < N; j++) {
				long jong = 0;
				long woo = 0;
				for (int i = 0; i < N; i++) {
					if (visited[i]) {
						jong += data[i][j];
						woo -= data[i][j];
					} else {
						jong -= data[i][j];
						woo += data[i][j];
					}
				}
				if (jong > 0) {
					max += woo;
				}
			}

			result = Math.max(result, max);
			return;
		}


		visited[idx] = true;
		find(idx+1);
		visited[idx] = false;
		find(idx+1);
	}
}
// 3
// -10 2 -3
// -4 -1 7
// -3 0 9