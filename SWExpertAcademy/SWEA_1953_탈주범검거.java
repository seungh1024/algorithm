package day0407;

import java.io.*;
import java.util.*;

public class SWEA_1953_탈주범검거 {

	static int N, M, R, C, L;
	static int[][] map;
	static Queue<Point> queue;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 세로 크기
			M = Integer.parseInt(st.nextToken()); // 가로 크기 -> new int[N][M];
			R = Integer.parseInt(st.nextToken()); // 맨홀 뚜겅이 위치한 장소의 세로 위치 R
			C = Integer.parseInt(st.nextToken()); // 맨홀 장소 가로 위치 C -> (R,C)임
			L = Integer.parseInt(st.nextToken()); // 탈출 후 소요 시간 ->반복해야 하는 횟수

			map = new int[N][M];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				// System.out.println(Arrays.toString(map[i]));
			}
			visited = new boolean[N][M];
			System.out.println("#" + t + " " + bfs());
			// for(int i = 0; i < N; i++) {
			// System.out.println(Arrays.toString(visited[i]));
			// }
		}
	}

	public static int bfs() {
		queue = new LinkedList<>();
		queue.offer(new Point(R, C)); // 맨홀 위치를 시작점으로
		visited[R][C] = true;
		int count = 1;
		result = 0;
		while (count < L) {
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				Point now = queue.poll(); // 현재 위치
				int pipe = map[now.x][now.y]; // 현재 파이프 모양
				int[] move = null; // 델타를 가지고 갈 배열

				switch (pipe) { // 어느 위치로 움직여야 하는지, 0: 아래, 1: 위, 2: 오른쪽, 3: 왼쪽
					case 1:
						move = new int[] { 0, 1, 2, 3 };
						break;
					case 2:
						move = new int[] { 0, 1 };
						break;
					case 3:
						move = new int[] { 2, 3 };
						break;
					case 4:
						move = new int[] { 1, 2 };
						break;
					case 5:
						move = new int[] { 0, 2 };
						break;
					case 6:
						move = new int[] { 0, 3 };
						break;
					case 7:
						move = new int[] { 1, 3 };
						break;
				}

				run(move, now);
			}

			count++;
		}

		return result + 1;
	}

	public static void run(int[] move, Point now) {
		int nx, ny;
		// System.out.println(now.x+","+now.y);
		for (int num : move) {
			nx = now.x + dx[num];
			ny = now.y + dy[num];
			// System.out.println(nx+"????"+ny);
			if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && map[nx][ny] != 0) {
				switch (num) {
					case 0:
						// System.out.println("pipe: "+map[nx][ny]);
						if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 4 || map[nx][ny] == 7) {
							queue.offer(new Point(nx, ny));
							visited[nx][ny] = true;
							result++;
						}
						break;
					case 1:
						// System.out.println("pipe: "+map[nx][ny]);
						if (map[nx][ny] == 1 || map[nx][ny] == 2 || map[nx][ny] == 5 || map[nx][ny] == 6) {
							queue.offer(new Point(nx, ny));
							visited[nx][ny] = true;
							result++;
						}
						break;
					case 2:
						// System.out.println("pipe: "+map[nx][ny]);
						if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 6 || map[nx][ny] == 7) {
							queue.offer(new Point(nx, ny));
							visited[nx][ny] = true;
							result++;
						}
						break;
					case 3:
						// System.out.println("pipe: "+map[nx][ny]);
						if (map[nx][ny] == 1 || map[nx][ny] == 3 || map[nx][ny] == 4 || map[nx][ny] == 5) {
							queue.offer(new Point(nx, ny));
							visited[nx][ny] = true;
							result++;
						}
						break;
				}
			}
		}
	}

	public static class Point {
		int x, y;

		Point() {
		};

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}

// 5
// 5 6 2 1 3
// 0 0 5 3 6 0
// 0 0 2 0 2 0
// 3 3 1 3 7 0
// 0 0 0 0 0 0
// 0 0 0 0 0 0
// 5 6 2 2 6
// 3 0 0 0 0 3
// 2 0 0 0 0 6
// 1 3 1 1 3 1
// 2 0 2 0 0 2
// 0 0 4 3 1 1