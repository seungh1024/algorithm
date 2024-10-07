package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_21923_곡예비행 {
	public static int N, M;
	public static long[][] data;
	public static long[][] up;
	public static long[][] down;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new long[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Long.parseLong(st.nextToken());
			}
		}

		up = new long[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(up[i],Long.MIN_VALUE);
		}
		up[N-1][0] = data[N-1][0];

		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < M; j++) {
				if(i != 0){
					up[i - 1][j] = Math.max(up[i - 1][j], up[i][j] + data[i - 1][j]);
				}
				if (j +1 != M) {
					up[i][j + 1] = Math.max(up[i][j + 1], up[i][j] + data[i][j + 1]);
				}
			}
		}

		down = new long[N][M];
		for (int i = 0; i < N; i++) {
			Arrays.fill(down[i], Long.MIN_VALUE);
		}
		down[N-1][M-1] = data[N-1][M-1];

		for (int i = N - 1; i >= 0; i--) {
			for (int j = M - 1; j >= 0; j--) {
				if (i != 0) {
					down[i - 1][j] = Math.max(down[i - 1][j], down[i][j] + data[i - 1][j]);
				}
				if (j - 1 >= 0) {
					down[i][j - 1] = Math.max(down[i][j - 1], down[i][j] + data[i][j - 1]);
				}
			}
		}

		long result = Long.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result = Math.max(result, up[i][j] + down[i][j]);
			}
		}

		System.out.println(result);
	}

}
