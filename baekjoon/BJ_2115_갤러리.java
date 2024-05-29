package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_2115_갤러리 {
	public static int N,M;
	public static char[][] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new char[N+2][M+2];

		for (int i = 1; i <= N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				data[i][j] = input[j-1];
			}
		}

		int result = 0;
		for (int i = 1; i <= N; i++) {
			int upCount = 0;
			int downCount = 0;
			for (int j = 1; j <= M; j++) {
				if (data[i][j] == '.' && data[i - 1][j] == 'X') {
					upCount++;
					if (upCount == 2) {
						result++;
						upCount = 0;
					}
				} else {
					upCount = 0;
				}

				if (data[i][j] == '.' && data[i + 1][j] == 'X') {
					downCount++;
					if (downCount == 2) {
						result++;
						downCount = 0;
					}
				} else {
					downCount = 0;
				}
			}
		}

		for (int j = 1; j <= M; j++) {
			int leftCount = 0;
			int rightCount = 0;
			for (int i = 1; i <= N; i++) {
				if (data[i][j] == '.' && data[i][j - 1] == 'X') {
					leftCount++;
					if (leftCount == 2) {
						result++;
						leftCount = 0;
					}
				} else {
					leftCount = 0;
				}

				if (data[i][j] == '.' && data[i][j + 1] == 'X') {
					rightCount++;
					if (rightCount == 2) {
						result++;
						rightCount = 0;
					}
				} else {
					rightCount = 0;
				}
			}
		}

		System.out.println(result);

	}
}
