package algo_202410;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BJ_14925_목장건설하기 {
	public static int M, N;
	public static int[][] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		data = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] > 0) {
					data[i][j] = -1;
				} else if (data[i][j] == 0) {
					data[i][j] = 1;
				}
			}
			// System.out.println(Arrays.toString(data[i]));
		}
		// System.out.println("====");

		// for (int j = 0; j < N; j++) {
		// 	if (data[0][j] == 0) {
		// 		data[0][j] = 1;
		// 	}
		// }
		//
		// for (int i = 0; i < M; i++) {
		// 	if (data[i][0] == 0) {
		// 		data[i][0] = 1;
		// 	}
		// }

		// System.out.println(Arrays.toString(data[0]));
		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				if(data[i][j] == -1 || data[i-1][j] == -1 || data[i][j-1] == -1 || data[i-1][j-1] == -1) continue;

				// if (data[i - 1][j] == data[i][j - 1] && data[i-1][j] == data[i-1][j-1]) {
				// 	data[i][j] = data[i - 1][j] + 1;
				// } else {
				// }
				data[i][j] = Math.min(data[i-1][j-1],Math.min(data[i - 1][j], data[i][j - 1]))+1;
			}
			// System.out.println(Arrays.toString(data[i]));

		}

		int max = Arrays.stream(data)
			.flatMapToInt(row -> Arrays.stream(row))
			.max().getAsInt();

		if (max < 0) {
			max = 0;
		}

		System.out.println(max);
	}
}
