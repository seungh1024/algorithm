package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_16926_배열돌리기 {
	public static int N,M,R;
	public static int[][] data;
	public static int[] dx = {1, 0, -1, 0};
	public static int[] dy = {0, 1, 0, -1};


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		data = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int sx = 0;
		int sy = 0;
		int ex = N;
		int ey = M;
		int range = (Math.min(N,M)+1)/2;

		int[][] result = new int[N][M];
		for (int r = 0; r < range; r++) {
			int size = (ex-sx)*2 + (ey-sy)*2 - 4;
			// System.out.println(size);
			// System.out.println("range = "+range);
			List<int[]> list = new ArrayList<>(size);
			// 다음 위치 생성
			int x = sx;
			int y = sy;
			int d = 0;
			list.add(new int[] {x, y});
			for (int s = 1; s < size; s++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if (nx >= sx && nx < ex && ny >= sy && ny < ey) {
					x = nx;
					y = ny;
					list.add(new int[] {x, y});
				} else {
					d = (d+1)%4;
					s--;
				}
			}
			// for (int[] l : list) {
			// 	System.out.println(Arrays.toString(l));
			// }
			int jump = R%size;

			for (int s = 0; s < size; s++) {
				int[] last = list.get(s);
				int[] next = list.get((s+jump)%size);

				result[next[0]][next[1]] = data[last[0]][last[1]];
			}

			sx++;
			sy++;
			ex--;
			ey--;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
