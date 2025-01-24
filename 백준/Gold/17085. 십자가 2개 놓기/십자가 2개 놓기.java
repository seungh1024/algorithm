import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static char[][] data;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static List<Integer> size;
	public static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new char[N][M];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				data[i][j] = input[j];
			}
		}

		size = new ArrayList<>();
		int value = 1;
		for (int i = 0; i <= 7; i++) {
			size.add(value);
			value += 4;
		}
		// System.out.println(size);
		find(0, 0, 0, 1);
		System.out.println(result);
	}

	public static void find(int x, int y, int cnt, int value) {
		// System.out.println("x = "+x + ", y = "+y);
		// printData();
		if (cnt == 2) {
			// System.out.println("value = "+value);
			result = Math.max(result, value);
			return;
		}

		if (x >= N) {
			return;
		}

		if (data[x][y] == '#') {
			for (int i = 0; i <= 7; i++) {
				if (check(x, y, i)) {
					changeValue(x, y, i, '.');
					int s = size.get(i);
					// System.out.println("x = "+ x + ", y = "+ y + ", i = "+ i + ", size = "+s);
					if (y + 1 < M) {
						find(x, y + 1, cnt + 1, value * s);
					} else {
						find(x + 1, 0, cnt + 1, value * s);
					}

					changeValue(x, y, i, '#');
				}
			}

		}
			if (y + 1 < M) {
				find(x, y + 1, cnt,value);
			} else {
				find(x + 1, 0, cnt,value);
			}

	}

	public static boolean check(int x, int y, int size) {
		// System.out.println("check size = "+size);
		if (size == 0) {
			if (data[x][y] == '#') {
				return true;
			}
		}

		for (int s = 1; s <= size; s++) {
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d] * s;
				int ny = y + dy[d] * s;
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || data[nx][ny] == '.') {
					return false;
				}
			}
		}

		return true;
	}

	public static void changeValue(int x, int y, int size, char value) {
		data[x][y] = value;
		for (int s = 1; s <= size; s++) {
			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d] * s;
				int ny = y + dy[d] * s;
				data[nx][ny] = value;
			}
		}
	}

	public static void printData() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(data[i]));
		}
	}
}