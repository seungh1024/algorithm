

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static char[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new char[N+2][M+2];
		for (int i = 1; i <= N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				data[i][j] = input[j-1];
			}
		}

		find();
	}

	public static void find() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N+2][M+2];
		for (int i = 0; i <= N+1; i++) {
			q.offer(new int[] {i, 0});
			q.offer(new int[] {i, M+1});
			visited[i][0] = true;
			visited[i][M+1] = true;
		}
		for (int j = 0; j <= M+1; j++) {
			q.offer(new int[] {0, j});
			q.offer(new int[] {N+1, j});
			visited[0][j] = true;
			visited[N+1][j] = true;
		}

		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		char[] urdl = {'U', 'R', 'D', 'L'};
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now[0]+dx[d];
				int ny = now[1] + dy[d];

				if (nx > 0 && nx <= N && ny > 0 && ny <= M && !visited[nx][ny]) {
					if (urdl[d] == data[nx][ny]) {
						q.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
						cnt++;
					}
				}
			}
		}

		System.out.println(cnt);
	}
}
