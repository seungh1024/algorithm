package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_2026_소풍 {
	public static int K, N, F;
	public static int[] count;
	public static boolean[][] friend;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());

		count = new int[N + 1];
		friend = new boolean[N + 1][N + 1];

		for (int i = 0; i < F; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			count[a]++;
			count[b]++;
			friend[a][b] = true;
			friend[b][a]= true;
		}

		visited= new boolean[N+1];
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			if(count[i] < K-1) continue;

			visited[i] = true;
			if (find(i, 1)) {
				for (int j = 1; j <= N; j++) {
					if (visited[j]) {
						sb.append(j).append("\n");
					}
				}
				break;
			}
			visited[i] = false;
		}

		if (sb.isEmpty()) {
			System.out.println(-1);
		} else {
			System.out.println(sb);
		}


	}

	public static boolean find(int idx, int cnt) {
		if (cnt == K) {
			return true;
		}

		for (int i = idx + 1; i <= N; i++) {
			if (friend[idx][i] && isFriend(i)) {
				visited[i] = true;
				if (find(i, cnt + 1)) {
					return true;
				}
				visited[i] = false;
			}
		}

		return false;
	}

	public static boolean isFriend(int idx) {
		for (int i = 1; i <= N; i++) {
			if (visited[i] && !friend[idx][i]) {
				return false;
			}
		}
		return true;
	}
}
