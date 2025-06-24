

import java.io.*;
import java.util.*;

public class Main {
	public static int N;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());

		int[][] rowSum = new int[N+1][N+2];
		int[][] colSum = new int[N+1][N+2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int num = Integer.parseInt(st.nextToken());
				rowSum[i][j] = rowSum[i-1][j-1] + num;
				colSum[i][j] = colSum[i-1][j+1] + num;
			}
		}

		int max = 0;

		// size
		for (int s = 1; s <= N; s++) {
			int size = N-s;
			for (int i = 1; i <= s; i++) {
				for (int j = 1; j <= s; j++) {
					int A = rowSum[i + size][j + size] - rowSum[i - 1][j - 1];
					int B = colSum[i + size][j] - colSum[i - 1][j + size + 1];
					max = Math.max(max, A - B);
				}
			}
		}

		System.out.println(max);


	}
}
