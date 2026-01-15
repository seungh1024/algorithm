

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[][] data;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
	public static int K;
	public static List<Data> list;
	public static int[] check;
	public static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N][M];
		K = 0;
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] > 0 && data[i][j] < 6) {
					K++;
					list.add(new Data(i, j));
				}
			}
		}

		check = new int[K];
		find(0);
		System.out.println(result);
	}

	public static void checkCCTV(boolean[][] arr, int x, int y, int d) {
		while (x >= 0 && x < N && y >= 0 && y < M && data[x][y] != 6) {
			arr[x][y] = true;
			x += dx[d];
			y += dy[d];
		}
	}

	public static int makeResult() {
		int result = 0;

		boolean[][] temp = new boolean[N][M];
		for (int i = 0; i < K; i++) {
			int d = check[i];
			Data now = list.get(i);
			switch (data[now.x][now.y]) {
				case 1 -> {
					checkCCTV(temp, now.x, now.y, d);
				}
				case 2 -> {
					checkCCTV(temp, now.x, now.y, d);
					checkCCTV(temp, now.x, now.y, (d+2)%4);
				}
				case 3 -> {
					for (int j = 0; j < 2; j++) {
						checkCCTV(temp, now.x, now.y, (d + j) % 4);
					}
				}
				case 4 -> {
					for (int j = 0; j < 3; j++) {
						checkCCTV(temp, now.x, now.y, (d + j) % 4);
					}
				}
				case 5 -> {
					for (int j = 0; j < 4; j++) {
						checkCCTV(temp, now.x, now.y, (d + j) % 4);
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!temp[i][j] && data[i][j] != 6) {
					result++;
				}
			}
			// System.out.println(Arrays.toString(temp[i]));
		}
		// System.out.println("=======");
		// System.out.println("result = "+result);

		return result;
	}

	public static void find(int idx) {
		if (idx == K) {
			int cnt = makeResult();
			result = Math.min(result, cnt);
			return;
		}

		for (int d = 0; d < 4; d++) {
			check[idx] = d;
			find(idx + 1);
		}
	}

	public static class Data {
		int x;
		int y;

		@Override
		public String toString() {
			return "Data{" +
				"x=" + x +
				", y=" + y +
				'}';
		}

		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
