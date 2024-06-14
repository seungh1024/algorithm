package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_30508_고인물이싫어 {
	public static int N, M, h, w;
	public static int[][] data;
	public static boolean[][] check;
	public static int K;
	public static Queue<int[]> q;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N+1][M+1];
		check = new boolean[N+1][M+1];

		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q = new ArrayDeque<>();
		K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			q.offer(new int[] {r, c});
			check[r][c] = true;
		}

		find();

		// for (int i = 0; i <= N; i++) {
		// 	System.out.println(Arrays.toString(check[i]));
		// }

		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if(i+h > N+1 || j+w > M+1) continue;
				boolean flag = false;
				// System.out.println("i = " + i +", i+h = "+(i+h-1) + ", j = " + j +", j+w = " + (j+w-1));
				for (int p = i; p < i + h && !flag; p++) {
					for (int q = j; q < j + w && !flag; q++) {
						if (!check[p][q]) {
							flag = true;
						}
					}
				}
				if (!flag) {
					result++;
				}
				// System.out.println("result = "+result);
			}
		}
		System.out.println(result);
	}

	public static void find() {
		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now[0]+dx[d];
				int ny = now[1] + dy[d];
				if (nx > 0 && nx <= N && ny > 0 && ny <=M && !check[nx][ny] && data[nx][ny] >= data[now[0]][now[1]]) {
					q.offer(new int[] {nx, ny});
					check[nx][ny] = true;
				}
			}
		}
	}
}
