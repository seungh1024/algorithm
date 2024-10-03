package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_16438_원숭이스포츠 {
	public static int N;
	public static boolean[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new boolean[8][N];



		find('A',0,N,0);


		StringBuilder result = new StringBuilder();
		for (int i = 1; i < 8; i++) {
			for (int j = 0; j < N; j++) {
				if (data[i][j]) {
					result.append('A');
				} else {
					result.append('B');
				}
			}
			result.append("\n");
		}
		System.out.println(result);
	}

	public static void find(char c ,int left, int right, int depth) {
		if (depth == 8) {
			return;
		}

		for (int i = left; i < right; i++) {
			if (c == 'B') {
				data[depth][i] = true;
			}
		}

		int mid = (left+right)/2;
		find(c, left, mid, depth + 1);
		find(c == 'A' ? 'B' : 'A', mid, right, depth + 1);
	}

}
