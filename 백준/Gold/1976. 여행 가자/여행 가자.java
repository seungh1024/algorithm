

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		data = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int j = 1; j <= N; j++) {
			for (int i = 1; i <= N; i++) {
				if(i == j)continue;
				for (int k = 1; k <= N; k++) {
					if (data[i][j] == 1 && data[j][k] == 1) {
						data[i][k] = 1;
					}
				}
			}
		}
		for (int i = 1; i <= N; i++) {
			data[i][i] = 1;
		}

		int[] input = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		String result = "YES";
		for (int i = 1; i < M; i++) {
			int from = input[i-1];
			int to = input[i];
			if (data[from][to] == 0) {
				result = "NO";
				break;
			}
		}

		System.out.println(result);
	}
}
