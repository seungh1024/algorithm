package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_16971_배열B의값 {
	public static int N, M;
	public static long[][] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new long[N][M];
		long[] row = new long[N];
		long[] col = new long[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long sum = 0;
			for(int j = 0; j < M; j++) {
				data[i][j] = Long.parseLong(st.nextToken());
				if (j == 0 || j == M - 1) {
					sum += data[i][j] * 2;
				} else {
					sum += data[i][j] * 4;
				}
			}
			row[i] = sum;
		}
		for (int j = 0; j < M; j++) {
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (i == 0 || i == N - 1) {
					sum += data[i][j] * 2;
				} else {
					sum += data[i][j] * 4;
				}
			}
			col[j] = sum;
		}

		int maxRow = row[0] >= row[N - 1] ? 0 : N - 1;
		int minRow = 1;
		long nowRow = row[minRow];
		for (int i = 2; i < N - 1; i++) {
			if (nowRow > row[i]) {
				minRow = i;
				nowRow = row[i];
			}
		}

		long rowValue = row[maxRow] - row[minRow];

		int maxCol = col[0] >= col[M - 1] ? 0 : M - 1;
		int minCol = 1;
		long nowCol = col[minCol];
		for (int i = 2; i < M - 1; i++) {
			if (nowCol > col[i]) {
				minCol = i;
				nowCol = col[i];
			}
		}

		long colValue = col[maxCol] - col[minCol];

		long defaultSum = dataSum();
		long rowSum = Long.MIN_VALUE;
		if (row[maxRow] > row[minRow]) {
			for (int j = 0; j < M; j++) {
				long temp = data[maxRow][j];
				data[maxRow][j] = data[minRow][j];
				data[minRow][j] = temp;
			}
			rowSum = dataSum();
			for (int j = 0; j < M; j++) {
				long temp = data[maxRow][j];
				data[maxRow][j] = data[minRow][j];
				data[minRow][j] = temp;
			}
		}

		long colSum = Long.MIN_VALUE;
		if (col[maxCol] > col[minCol]) {
			for (int i = 0; i < N; i++) {
				long temp = data[i][maxCol];
				data[i][maxCol] = data[i][minCol];
				data[i][minCol] = temp;
			}
			colSum = dataSum();
			for (int i = 0; i < N; i++) {
				long temp = data[i][maxCol];
				data[i][maxCol] = data[i][minCol];
				data[i][minCol] = temp;
			}
		}

		// System.out.println(rowSum +", " +colSum);
		System.out.println(Math.max(defaultSum, Math.max(rowSum, colSum)));

	}

	public static long dataSum(){
		long result = 0;
		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < M - 1; j++) {
				result += data[i][j] +data[i+1][j] +data[i+1][j+1] +data[i][j+1];
			}
		}
		return result;
	}
}
