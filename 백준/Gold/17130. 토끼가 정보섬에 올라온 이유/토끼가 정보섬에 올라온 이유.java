

import java.io.*;
import java.util.*;

public class Main {
	public static int[] dx = {1, 0, -1};
	public static int[] dy = {1, 1, 1};
	public static int R, C;
	public static char[][] data;
	public static int sx,sy;
	public static int[][] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new char[R][C];

		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				data[i][j] = input[j];
				if (input[j] == 'R') {
					sx = i;
					sy = j;
					data[i][j] = '.';
				}
			}
		}

		count = new int[R][C];
		count[sx][sy] = 1;
		int range = sy;
		for (int j = 0; j < C; j++) {
			for (int i = 0; i < R; i++) {

				if(data[i][j] == '#' || count[i][j] == 0) continue;
				for (int d = 0; d < 3; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (nx >= 0 && nx < R && ny >= 0 && ny < C && data[nx][ny] != '#') {
						// count[nx][ny] += count[i][j];
						count[nx][ny]++;
					}
				}
			}
		}

		// for (int i = 0; i < R; i++) {
		// 	System.out.println(Arrays.toString(count[i]));
		// }

		find();
	}

	public static void find() {
		Queue<int[]> q = new ArrayDeque<>();
		int[][] visited = new int[R][C];
		for (int i = 0; i < R; i++) {
			Arrays.fill(visited[i], -1);
		}
		visited[sx][sy] = 0;
		q.offer(new int[] {sx, sy, 0});

		int result = -1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int x = now[0];
			int y = now[1];
			int c = now[2];

			for (int d = 0; d < 3; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && data[nx][ny] != '#') {
					if (data[nx][ny] == 'C') {
						if (visited[nx][ny] < c + 1) {
							visited[nx][ny] = c+1;
						}
					} else if (data[nx][ny] == 'O') {
						if (visited[nx][ny] < c) {
							visited[nx][ny] = c;
							result = Math.max(result, c);
						}
					} else if (data[nx][ny] == '.') {
						if (visited[nx][ny] < c) {
							visited[nx][ny] = c;
						}
					}
					count[nx][ny]--;
					if (count[nx][ny] == 0) {
						q.offer(new int[] {nx, ny, visited[nx][ny]});
					}
				}
			}
		}

		System.out.println(result);
	}
}
