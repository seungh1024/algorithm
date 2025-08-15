

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static boolean[][] data;
	public static int result;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				if (input[j] == 'T') { // 뒷면 체크
					data[i][j] = true;
				}
			}
		}

		visited = new boolean[N];
		result = Integer.MAX_VALUE;
		find(0);
		System.out.println(result);
	}

	public static void find(int idx) {
		if (idx >= N) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int i = 0; i < N; i++) {
					boolean b = data[i][j];
					if (visited[i]) {
						b = !b;
					}
					if (b) {
						cnt++;
					}
				}
				if (cnt > N / 2) {
					sum += N-cnt;
				} else {
					sum += cnt;
				}
			}

			result = Math.min(result, sum);

			return;
		}

		visited[idx] = true;
		find(idx+1);
		visited[idx] = false;
		find(idx+1);

	}

	public static void printData() {
		System.out.println("=====print=====");
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(data[i]));
		}
	}
}
