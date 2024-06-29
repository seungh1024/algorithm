package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_24727_인지융 {
	public static int N, C, E;
	public static int[][] data;
	public static boolean[][] totalVisited;
	public static boolean[][] visitedC;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		data = new int[N][N];

		visitedC = new boolean[N][N];
		totalVisited = new boolean[N][N];
		if (makeC()) {
			makeB();
			if (makeE()) {
				System.out.println(1);
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						sb.append(data[i][j]);
					}
					sb.append("\n");
				}
				System.out.println(sb);
			} else {
				System.out.println(-1);
			}

		} else {
			System.out.println(-1);
		}
	}

	public static boolean makeE() {
		boolean result = false;

		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			boolean flag = false;
			for (int j = 0; j < N; j++) {
				if (!totalVisited[i][j]) {
					q.offer(new int[] {i, j});
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}

		int count = 0;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			if(totalVisited[x][y]) continue;
			totalVisited[x][y] = true;
			data[x][y] = 2;
			count++;

			if (count == E) {
				result = true;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !totalVisited[nx][ny]) {
					q.offer(new int[] {nx, ny});
				}
			}
		}

		return result;
	}

	// 바리케이드 설치
	public static void makeB() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(totalVisited[i][j]) continue;
				for (int d = 0; d < 4; d++) {
					int nx = i+dx[d];
					int ny = j + dy[d];
					if (nx >= 0 && nx < N && ny >= 0 && ny < N && visitedC[nx][ny]) {
						totalVisited[i][j] = true;
						data[i][j] = 0;
						break;
					}
				}
			}
		}

		// for()
	}

	// 컴공 구역 설정
	public static boolean makeC() {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {0, 0});

		int count = 0;

		boolean result = false;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];

			if(visitedC[x][y]) continue;
			visitedC[x][y] = true;
			totalVisited[x][y] = true;
			data[x][y] = 1;
			count++;

			if (count == C) {
				result = true;
				break;
			}

			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visitedC[nx][ny]) {
					q.offer(new int[] {nx, ny});
				}
			}
		}

		return result;
	}
}
