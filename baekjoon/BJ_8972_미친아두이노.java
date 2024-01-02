package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_8972_미친아두이노 {
	public static char[][] data;
	public static int R, C;

	public static int[] dx = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
	public static int[] dy = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		data = new char[R][C];
		int x = 0, y = 0;
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				data[i][j] = input[j];
				if (data[i][j] == 'R') {
					list.add(new int[]{i, j});
				} else if (data[i][j] == 'I') {
					x = i;
					y = j;
				}
			}
		}
		char[] move = br.readLine().toCharArray();
		int count = 0;
		for (char c : move) {
			int[][] visited = new int[R][C];
			count++;
			int d = c-'0';
			int nx = x+dx[d];
			int ny = y+dy[d];
			if (data[nx][ny] == 'R') {
				System.out.println("kraj "+count);
				return;
			}
			data[x][y] = '.';
			data[nx][ny] = 'I';
			x = nx;
			y = ny;

			for (int[] crazy : list) {
				int cx = crazy[0];
				int cy = crazy[1];
				int dd = 0;
				int size = R+C+1;
				for (d = 1; d <= 9; d++) { // 가장 가까운 곳 찾기
					nx = cx+dx[d];
					ny = cy+dy[d];
					int length = Math.abs(x-nx)+Math.abs(y-ny);
					if (length <= size) {
						size = length;
						dd = d;
					}
				}
				// System.out.println("x: "+x + ", y: "+y);
				// System.out.println("cx: "+cx + ", cy: "+cy + ", nx: "+(cx+dx[dd]) + ", ny: "+(cy+dy[dd]));
				// System.out.println(size);
				if (cx + dx[dd] == x && cy + dy[dd] == y) {
					System.out.println("kraj " + count);
					return;
				}
				data[cx][cy] = '.';
				visited[cx+dx[dd]][cy+dy[dd]] ++; // 몇 개 거기로 갔는지 세어 줌
			}

			list.clear();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (visited[i][j] == 1) {
						list.add(new int[] {i,j});
						data[i][j] = 'R';
					}
				}
			}

			// StringBuilder sb = new StringBuilder();
			// sb.append("turn: "+count).append("\n");
			// for (int i = 0; i < R; i++) {
			// 	for (int j = 0; j < C; j++) {
			// 		sb.append(data[i][j]);
			// 	}
			// 	sb.append("\n");
			// }
			// System.out.println(sb.append("==============="));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(data[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
