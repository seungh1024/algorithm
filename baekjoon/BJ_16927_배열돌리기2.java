package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_16927_배열돌리기2 {
	public static int N,M, R;
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

		int range = Math.min(N, M)/2;
		int x = 0;
		int y = 0;
		for (int i = 0; i < range; i++) {
			spin(x++,y++);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(data[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void spin(int x, int y) {
		int totalCount = (N-x*2)*2 + (M-y*2)*2 -4;
		int move = R%totalCount;
		List<int[]> list = new ArrayList<>();
		int xmin = x;
		int xmax = N-x;
		int ymin = y;
		int ymax = M-y;

		// System.out.println("xmin = "+xmin + ", xmax = "+xmax + ", ymin = "+ymin +", ymax = "+ymax);
		int d = 0;
		for (int i = 0; i < totalCount; i++) {
			list.add(new int[] {x, y});
			int nx = x+dx[d];
			int ny = y+dy[d];
			if(nx < xmin || nx >= xmax || ny < ymin || ny >= ymax){
				d = (d+1)%4;
			}
			x +=dx[d];
			y += dy[d];
		}

		// for(int[] arr : list){
		// 	System.out.println(Arrays.toString(arr));
		// }
		// System.out.println("========");

		List<int[]> copy = new ArrayList<>();
		List<Integer> copyValue = new ArrayList<>();
		for (int i = 0; i < totalCount; i++) {
			int[] now = list.get(i);
			int[] next = list.get((i+move)%totalCount);
			// System.out.println("next = "+Arrays.toString(next));
			copy.add(next);
			copyValue.add(data[now[0]][now[1]]);
		}

		for (int i = 0; i < totalCount; i++) {
			int[] now = copy.get(i);
			data[now[0]][now[1]] = copyValue.get(i);
		}
	}
}
