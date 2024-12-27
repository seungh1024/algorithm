package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_16432_떡장수와호랑이 {
	public static int N;
	public static int[][] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data= new int[N][10];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				int idx = Integer.parseInt(st.nextToken());
				data[i][idx] = 1;
			}
		}


		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				if (data[i][j] > 0) {
					for (int k = 0; k < 10; k++) {
						if(j == k) continue;
						if (data[i - 1][k] == i) {
							data[i][j] += data[i-1][k];
							break;
						}
					}
				}
			}
		}

		// for (int i = 0; i < N; i++) {
		// 	System.out.println(Arrays.toString(data[i]));
		// }

		Stack<Integer> stack = new Stack<>();
		for (int j = 0; j < 10; j++) {
			if (data[N - 1][j] == N) {
				stack.push(j);
				break;
			}
		}
		if (!stack.isEmpty()) {
			for (int i = N - 2; i >= 0; i--) {
				int last = stack.peek();
				boolean flag = false;
				for (int j = 0; j < 10; j++) {
					if(last == j) continue;
					if (data[i][j] == data[i + 1][last] - 1) {
						stack.push(j);
						flag = true;
						break;
					}
				}
				if (!flag) {
					break;
				}
			}
		}

		if (stack.size() < N) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append("\n");
			}
			System.out.println(sb);
		}

	}
}
