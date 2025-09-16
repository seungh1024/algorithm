

import java.io.*;
import java.util.*;

public class Main {
	public static int K ,N , F;
	public static List<Integer>[] list;
	public static boolean[][] friend;
	public static int[] arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		// list = new ArrayList[N + 1];
		// for (int i = 0; i <= N; i++) {
		// 	list[i] = new ArrayList<>();
		// }

		friend = new boolean[N + 1][N + 1];
		for (int i = 0; i < F; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friend[a][b] = true;
			friend[b][a] = true;
		}

		visited = new boolean[N + 1];
		// arr = new int[K];

		for (int i = 1; i <= N; i++) {
			visited[i] = true;
			if (find(1, i)) {
				System.out.println(sb);
				return;
			}

			visited[i] = false;
		}

		System.out.println(-1);
	}
	public static boolean find(int idx, int num) {
		if (idx == K) {
			for (int i = 1; i <=N; i++) {
				if (visited[i]) {
					sb.append(i).append("\n");
				}
			}
			return true;
		}

		for (int i = num + 1; i <= N; i++) {
			if(visited[i] || !friend[num][i]) continue;
			visited[i] = true;
			if (check(i) && find(idx + 1, i)) {
				return true;
			}
			visited[i] = false;
		}

		return false;
	}

	public static boolean check(int target) {
		for (int i = 1; i < target; i++) {
			if (visited[i] && !friend[i][target]) {
				return false;
			}
		}

		return true;
	}
}
