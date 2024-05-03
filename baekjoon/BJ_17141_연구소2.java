package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_17141_연구소2 {
	public static List<int[]> virus;
	public static int N,M;
	public static int[][] data;
	public static boolean[] check;
	public static int result;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1, -1, 0, 0};
	public static int totalRoom;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N][N];
		virus = new ArrayList<>();
		totalRoom = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] == 2) {
					virus.add(new int[] {i, j});
					totalRoom++;
				} else if (data[i][j] == 0) {
					totalRoom++;
				}
			}
		}

		result = Integer.MAX_VALUE;
		check = new boolean[virus.size()];
		chooseVirus(0, 0, virus.size());
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}

	public static void chooseVirus(int index, int count, int range) {
		if (count == M) {
			result = Math.min(result,find(range));
			for (int i = 0; i < range; i++) {

			}
			return;
		}
		if (index >= range) {
			return;
		}

		check[index] = true;
		chooseVirus(index + 1, count + 1, range);
		check[index] = false;
		chooseVirus(index + 1, count, range);
	}

	public static int find(int range) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < range; i++) {
			if (check[i]) {
				int[] input = virus.get(i);
				int x = input[0];
				int y = input[1];
				visited[x][y] = true;
				q.offer(input);
			}
		}

		int time = 0; // 퍼지는 시간
		int count = M; // 퍼지는 공간 카운트
		while (!q.isEmpty()) {
			int size = q.size();
			time++;
			for (int s = 0; s < size; s++) {
				int[] now = q.poll();

				for (int d = 0; d < 4; d++) {
					int nx = now[0]+dx[d];
					int ny = now[1]+dy[d];

					if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && data[nx][ny] != 1) {
						visited[nx][ny] = true;
						q.offer(new int[] {nx, ny});
						count++;
					}
				}
			}
		}

		if (count == totalRoom) {
			return time - 1;
		} else {
			return Integer.MAX_VALUE;
		}

	}
}
