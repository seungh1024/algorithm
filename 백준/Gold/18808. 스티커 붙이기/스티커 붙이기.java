import java.io.*;
import java.util.*;

public class Main {
	public static int N,M, K;
	public static boolean[][] map;
	public static boolean[][] data;
	public static int r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			data = new boolean[r][c];
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < c; j++) {
					int value = Integer.parseInt(st.nextToken());
					if (value == 1) {
						data[i][j] = true;
					}
				}
			}

			// System.out.println("data num= "+k);
			for (int d = 0; d < 4; d++) {
				if (putData()) {
					break;
				}
				spin();
				// printData();
			}
		}
		// printMap();

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j]) {
					result++;
				}
			}
		}
		System.out.println(result);
	}

	public static void spin() {
		int limitX = c;
		int limitY = r;

		boolean[][] copy = new boolean[limitX][limitY];
		int x = r-1;
		int y = 0;
		for (int i = 0; i < limitX; i++) {
			for (int j = 0; j < limitY; j++) {
				copy[i][j] = data[x][y];
				x--;
				if (x < 0) {
					x = r-1;
					y++;
				}
			}
		}

		r = limitX;
		c = limitY;
		data = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				data[i][j] = copy[i][j];
			}
		}
	}

	public static boolean putData() {
		// System.out.println("put data start");
		boolean flag = false;
		for (int x = 0; x < N && x+r <= N; x++) {
			for (int y = 0; y < M && y + c <= M; y++) {
				// System.out.println("x = "+x + ", y = "+y);
				if (check(x, y)) {
					flag = true;
					change(x, y);
					break;
				}
			}
			if (flag) {
				break;
			}
		}

		if (flag) {
			return true;
		}

		return false;
	}

	public static boolean check(int x, int y) {
		int dx = 0;
		int dy = 0;
		// System.out.println("1,1 = "+data[1][1] + ", map 1,1 = "+map[1][1]);
		for (int i = x; i < x + r; i++) {
			for (int j = y; j < y + c; j++) {
				// System.out.println("dx = "+dx +", dy = "+dy + ", i = "+i + ", j = "+j);
				if (data[dx][dy] && map[i][j]) {
					return false;
				}
				dy++;
			}
			dx++;
			dy = 0;
		}

		return true;
	}

	public static void change(int x, int y) {
		int dx = 0;
		int dy = 0;
		for (int i = x; i < x + r; i++) {
			for (int j = y; j < y + c; j++) {
				if (data[dx][dy]) {
					map[i][j] = true;
				}
				dy++;
			}
			dx++;
			dy = 0;
		}
	}

	public static void printMap() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println("===========");
	}

	public static void printData() {
		for (int i = 0; i < r; i++) {
			System.out.println(Arrays.toString(data[i]));
		}
		System.out.println("==========");
	}
}