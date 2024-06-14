package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_15925_욱제는정치쟁이야 {
	public static int N, M;
	public static int[][] data;
	public static int[] rowSum; // row 1 개수 카운트
	public static int[] colSum; // col 1 개수 카운트


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N][N];

		rowSum = new int[N];
		colSum = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] == 1) {
					rowSum[i]++;
					colSum[j]++;
				}
			}
		}

		int range = 1000;
		if (M == 0) {
			while (range-- > 0) {
				for (int i = 0; i < N; i++) {
					if (N - rowSum[i] > N / 2) {
						for (int j = 0; j < N; j++) {
							if (data[i][j] == 1) {
								data[i][j] = 0;
								rowSum[i]--;
								colSum[j]--;
							}
						}
					}
					if (N - colSum[i] > N / 2) {
						for (int j = 0; j < N; j++) {
							if (data[j][i] == 1) {
								data[j][i] = 0;
								rowSum[j]--;
								colSum[i]--;
							}
						}
					}
				}
			}
		} else {
			while (range-- > 0) {
				for (int i = 0; i < N; i++) {
					if (rowSum[i] > N / 2) {
						for (int j = 0; j < N; j++) {
							if (data[i][j] == 0) {
								data[i][j] = 1;
								rowSum[i]++;
								colSum[j]++;
							}
						}
					}
					if (colSum[i] > N / 2) {
						for (int j = 0; j < N; j++) {
							if (data[j][i] == 0) {
								data[j][i] = 1;
								rowSum[j]++;
								colSum[i]++;
							}
						}
					}
				}
			}
		}

		int result = 1;
		for (int i = 0; i < N; i++) {
			if (M == 0) {
				if (rowSum[i] > 0 || colSum[i] > 0) {
					result = 0;
					break;
				}
			} else {
				if (rowSum[i] != N && colSum[i] != N) {
					result = 0;
					break;
				}
			}
		}
		// System.out.println(Arrays.toString(rowSum));
		// System.out.println(Arrays.toString(colSum));
		System.out.println(result);

	}
}
