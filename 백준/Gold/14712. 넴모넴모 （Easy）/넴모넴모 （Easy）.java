

import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[][] data;
	public static int result = 0;
	public static int[] dx = {-1, -1, 0, 0};
	public static int[] dy = {-1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N][M];


		find(0, 0, 1);
		System.out.println(result);
	}

	public static void find(int x, int y, int cnt) {


		if(x>=N){
		// System.out.println("x = "+x +", y = "+y +", cnt = "+cnt);
		// 	for (int i = 0; i < N; i++) {
		// 		System.out.println(Arrays.toString(data[i]));
		// 	}
		// 	System.out.println("=====");
			result += cnt;
			// result++;
			return;
		}
		if (y >= M) {
			find(x + 1, 0, cnt);
			return;
		}

		data[x][y] = 1;
		if (!nemmo()) {
			find(x, y + 1, cnt);
			data[x][y] = 0;
			find(x, y + 1, cnt);
		} else {

			data[x][y] = 0;
			find(x, y + 1, cnt);
		}

	}

	public static boolean nemmo(){
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < M; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i+dx[d];
					int ny = j + dy[d];
					if (data[nx][ny] == 1) {
						cnt++;
					}

				}
				if (cnt == 4) {
					return true;
				}
			}
		}

		return false;
	}
}
