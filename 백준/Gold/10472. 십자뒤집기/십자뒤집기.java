import java.io.*;
import java.util.*;

public class Main {
	public static boolean[][] data;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static boolean[] visited;
	public static int[] arrX = {0, 0, 0, 1, 1, 1, 2, 2, 2};
	public static int[] arrY = {0, 1, 2, 0, 1, 2, 0, 1, 2};
	public static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int p = 0; p < P; p++) {
			data = new boolean[3][3];
			for (int i = 0; i < 3; i++) {
				char[] input = br.readLine().toCharArray();
				for (int j = 0; j < 3; j++) {
					if (input[j] == '*') {
						data[i][j] = true;
					}
				}
			}

			result = Integer.MAX_VALUE;
			visited = new boolean[9];
			find(0,0);

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}

	public static void find(int idx, int cnt) {
		if (check()) {
			result = Math.min(result, cnt);
			// return;
		}
		if (idx >= 9) {
			return;
		}


		visited[idx] = true;
		find(idx + 1, cnt+1);
		visited[idx] = false;
		find(idx + 1, cnt);
	}

	public static boolean check() {
		// System.out.println(Arrays.toString(visited));
		for (int i = 0; i < 9; i++) {
			if (visited[i]) {
				change(arrX[i], arrY[i]);
			}
		}

		boolean flag = false;
		if (isWhite()) {
			flag = true;
		}
		for (int i = 0; i < 9; i++) {
			if (visited[i]) {
				change(arrX[i], arrY[i]);
			}
		}

		return flag;
	}

	public static void change(int x, int y) {
		data[x][y] = !data[x][y];
		for (int d = 0; d < 4; d++) {
			int nx = x+dx[d];
			int ny = y + dy[d];
			if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
				data[nx][ny] = !data[nx][ny];
			}
		}
	}

	public static boolean isWhite() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(data[i][j]){
					return false;
				}
			}
		}

		return true;
	}

	public static void printData() {
		for (int i = 0; i < 3; i++) {
			System.out.println(Arrays.toString(data[i]));
		}
	}
}

// [false, true, false, false, false, false, true, true, false