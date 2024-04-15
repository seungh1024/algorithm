package algo_202403;

import java.util.*;
import java.io.*;

public class BJ_2583_영역구하기 {
	public static int M,N,K;
	public static int[][] data;
	public static int[] dx = {0,0,1,-1};
	public static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N][M];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			for (int x = a; x < c; x++) {
				for (int y = b; y < d; y++) {
					data[x][y] = 1;
				}
			}
		}

		// for (int i = 0; i < N; i++) {
		// 	System.out.println(Arrays.toString(data[i]));
		// }

		List<Integer> list = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (data[i][j] == 0) {
					count++;
					list.add(find(i,j));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(count).append("\n");
		Collections.sort(list);
		for (int i : list) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	public static int find(int x, int y) {
		int result = 1;

		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{x,y});
		data[x][y] = 1;

		while (!q.isEmpty()) {
			int[] now = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = now[0]+dx[d];
				int ny = now[1]+dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && data[nx][ny] == 0) {
					data[nx][ny] = 1;
					q.offer(new int[]{nx,ny});
					result++;
				}
			}
		}

		return result;
	}
}
