package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_5427_불 {
	public static int  W, H;
	public static int[][] data;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static Queue<int[]> fire;
	public static Queue<int[]> q;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			data = new int[H][W];
			fire = new ArrayDeque<>();
			q = new ArrayDeque<>();
			for (int i = 0; i < H; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j = 0; j < W; j++) {
					data[i][j] = input[j];
					if (data[i][j] == '*') {
						fire.add(new int[]{i, j});
					} else if (data[i][j] == '@') {
						q.add(new int[] {i, j});
					}
				}
			}
			int result = find();
			if (result == -1) {
				sb.append("IMPOSSIBLE");
			} else {
				sb.append(result);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static int find() {
		int result = 0;

		while (!q.isEmpty()) {
			result++;
			int fSize = fire.size();
			for (int s = 0; s < fSize; s++) {
				int[] f = fire.poll();

				for (int d = 0; d < 4; d++) {
					int nx = f[0] + dx[d];
					int ny = f[1] + dy[d];
					if (nx >= 0 && nx < H && ny >= 0 && ny < W && (data[nx][ny] == '.' || data[nx][ny] == '@')) {
						data[nx][ny] = '*';
						fire.offer(new int[] {nx, ny});
					}
				}
			}

			int size = q.size();
			for (int s = 0; s < size; s++) {
				int[] now = q.poll();

				for (int d = 0; d < 4; d++) {
					int nx = now[0] + dx[d];
					int ny = now[1] + dy[d];

					if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
						if (data[nx][ny] == '.') {
							data[nx][ny] = '@';
							q.offer(new int[] {nx, ny});
						}
					} else {
						return result;
					}
				}
			}
		}

		return -1;
	}
}
