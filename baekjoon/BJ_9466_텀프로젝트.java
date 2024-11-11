package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_9466_텀프로젝트 {
	public static int N;
	public static int[] data;
	public static int[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			data = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
			}

			visited = new int[N+1];
			int result = 0;
			for (int i = 1; i <= N; i++) {
				if (i == data[i]) {
					visited[i] = -1;
					// result++;
				}
				else if (visited[i] == 0) {
					find(i);
				}
				// System.out.println("i = "+i + ", result = "+result);
			}
			for (int i = 1; i <= N; i++) {
				if (visited[i] == -1) {
					result++;
				}
			}
			sb.append(N-result).append("\n");
		}
		System.out.println(sb);
	}

	public static void find(int start) {
		int now = start;
		while (true) {
			// 매번 다른 값을 넣어 체크
			visited[now] = start;
			now = data[now];
			// 이번 방문에서 도달
			if (visited[now] == start) {
				while (visited[now] != -1) {
					visited[now] = -1;
					now = data[now];
				}
				return;
			}
			// 이전 방문
			else if (visited[now] != 0)
				return;

		}
	}
}
