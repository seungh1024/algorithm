

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		visited = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			if (idx != 0) {
				visited[i] = idx;
			}
		}

		// System.out.println(Arrays.toString(visited));
		boolean result = find(1);
		// System.out.println(Arrays.toString(visited));
		if (result) {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= N; i++) {
				sb.append(visited[i]).append(" ");
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}

	public static boolean find(int row) {
		// System.out.println("row = "+row);
		if (row == N+1) {
			return true;
		}

		if (visited[row] > 0) {
			if (find(row + 1)) {
				return true;
			}
		} else {

			for (int j = 1; j <= N; j++) {
				boolean check = false;
				for (int r = 1; r <= N; r++) {
					int idx = visited[r];
					if(idx == 0)continue;
					double temp = Math.abs((double)(j-idx)/(double)(row-r));
					if (temp == 1.0 || j == idx) {
						check = true;
						break;
					}
				}

				if(check) continue;

				visited[row] = j;
				if (find(row + 1)) {
					return true;
				}
				visited[row] = 0;
			}
		}

		return false;
	}
}
