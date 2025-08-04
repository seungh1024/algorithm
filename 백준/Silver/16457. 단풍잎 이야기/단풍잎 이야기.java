

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M , K;
	public static boolean[][] skill;
	public static boolean[] visited;
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		skill = new boolean[M][21];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < K; k++) {
				int idx = Integer.parseInt(st.nextToken());
				skill[i][idx] = true;
			}
		}

		visited = new boolean[21];
		find(1,0);
		System.out.println(result);
	}

	public static void find(int idx, int cnt) {
		if (cnt == N) {
			// System.out.println(Arrays.toString(visited));
			int max = 0;
			for (int i = 0; i < M; i++) {
				boolean check = true;
				for (int k = 1; k < 21; k++) {
					if (skill[i][k] && !visited[k]) {
						check = false;
						break;
					}
				}
				if (check) {
					max++;
				}
			}

			// System.out.println("max = "+max);
			result = Math.max(result, max);

			return;
		}
		if (idx > 20) {
			return;
		}

		visited[idx] = true;
		find(idx + 1, cnt + 1);
		visited[idx] = false;
		find(idx + 1, cnt);
	}
}
