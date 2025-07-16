

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M, K;
	public static char[][] data;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static int[] lx = {-1, -1, 1, 1};
	public static int[] ly = {-1, 1, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		double k = (Double.parseDouble(st.nextToken()));

		data = new char[M * 2 + 3][N * 2 + 2+3];

		for (int i = 1; i <= M * 2+1; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 1; j <= N * 2+1; j++) {
				data[i][j] = input[j-1];
			}
		}
		// for (int i = 0; i <= M * 2 + 1; i++) {
		// 	System.out.println(Arrays.toString(data[i]));
		// }
		int x = M*2+1;
		int y = (int)(2 * k) + 1;
		int d = 0;
		int result = 0;
		while (true) {

			if (data[x][y] == 'B') {
				result++;
				merge(x, y);
			} else if (data[x][y] == '-') {
				if (data[x + 1][y] == 'B' || data[x - 1][y] == 'B') {
					result++;
					if (data[x + 1][y] == 'B') {
						merge(x + 1, y);
					}
					if (data[x - 1][y] == 'B') {
						merge(x - 1, y);
					}
				}
			} else if (data[x][y] == '|') {
				if (data[x][y + 1] == 'B' || data[x][y-1] == 'B') {
					result++;
					if (data[x][y + 1] == 'B') {
						merge(x, y + 1);
					}
					if (data[x][y - 1] == 'B') {
						merge(x, y - 1);
					}
				}
			}
			if (y == 1) {
				if (d == 0) {
					d = 1;
				}
				if (d == 3) {
					d = 2;
				}
			}
			if (x == 1) {
				if (d == 1) {
					d = 2;
				}
				if (d == 0) {
					d = 3;
				}
			}
			if (y == 2 * N + 1) {
				if (d == 2) {
					d = 3;
				}
				if (d == 1) {
					d = 0;
				}
			}

			x += lx[d];
			y += ly[d];

			if (x == 2 * M + 1) {
				break;
			}
		}

		System.out.println(result);
	}

	private static void merge(int x, int y) {
		// System.out.println("x = "+ x + " y = "+y);
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		data[x][y] = 'O';

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now[0] + dx[d];
				int ny = now[1] + dy[d];

				if (nx >= 1 && nx <= 2 * M && ny >= 1 && ny <= 2 * N) {
					if (data[nx][ny] == '.' || data[nx][ny] == 'B') {
						data[nx][ny] = 'O';
						q.offer(new int[] {nx, ny});
					}
				}
			}
		}

		// System.out.println("print");
		// for (int i = 0; i <= M * 2 + 1; i++) {
		// 	System.out.println(Arrays.toString(data[i]));
		// }
	}

}



// 2 2 0.5
// +-+-+
// |B|B|
// +-+-+
// |O|O|
// +-+-+