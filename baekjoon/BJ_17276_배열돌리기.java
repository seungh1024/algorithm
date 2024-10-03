package algo_202410;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_17276_배열돌리기 {
	public static int N, D;
	public static int[][] data;
	public static int[][] copy;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken())%360;
			if (D < 0) {
				D = 360 + D;
			}

			int M = D/90;
			D %= 90;

			data = new int[N][N];
			copy = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int m = 0; m < M; m++) {
				spin();
			}

			// printData();

			if(D > 0){

				int x = 0;
				int y = 0;
				int d = 0;
				int min = 0;
				int max = N;
				for (int m = N/2; m > 0; m--) {
					for (int i = 0; i < 8; i++) {
						int nx = x+dx[d]*m;
						int ny = y+dy[d]*m;
						// System.out.println("nx = "+nx +", ny = "+ny +", d = "+d);

						if (nx < min || nx >= max || ny < min || ny >= max) {
							d++;
							nx = x+dx[d]*m;
							ny = y+dy[d]*m;
						}
						// System.out.println("nnx = "+nx + ", nny = "+ny + ", d = "+d);
						copy[nx][ny] = data[x][y];
						x = nx;
						y = ny;
					}
					x++;
					y++;
					d = 0;
					min++;
					max--;
					// System.out.println("====");
				}

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (copy[i][j] > 0) {
							data[i][j] = copy[i][j];
						}
					}
				}
			}


			String result = Arrays.stream(data)
				.map(row -> Arrays.stream(row)
					.mapToObj(String::valueOf)
					.collect(Collectors.joining(" ")))
				.collect(Collectors.joining("\n"));

			System.out.println(result);
		}
	}

	public static void spin() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == N / 2 || j == N / 2 || i == j || j == (N - 1 - i)) {
					int x = j;
					int y = N - 1 - i;
					copy[x][y] = data[i][j];
				} else {
					copy[i][j] = data[i][j];
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				data[i][j] = copy[i][j];
			}
		}
	}

	public static void printData() {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(data[i]));
		}
	}
}
