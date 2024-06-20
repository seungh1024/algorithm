package algo_202406;

import java.io.*;
import java.util.*;

public class BJ_1405_미친로봇 {
	public static int N;
	public static int[] dx = {0, 0, 1, -1};
	public static int[] dy = {1, -1, 0, 0};
	public static double[] per = {0, 0, 0, 0};
	public static int[][] visited;
	public static double fail, success;
	public static int sc,sf;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 4; i++) {
			per[i] = Double.parseDouble(st.nextToken())/100.0;
		}

		visited = new int[30][30];
		fail = 0;
		success = 0;
		sc = 0;
		sf = 0;
		// visited[14][14] = true;
		dfs(14, 14, 1.0,0, false);
		// System.out.println((double)success/((double)fail+(double)success));
		// System.out.println("success = " + success);
		// System.out.println("fail = "+fail);

		int test = 1;
		for (int i = 0; i < 14; i++) {
			test*=4;
		}
		// System.out.println(test);
		// System.out.println("sc = "+sc);
		// System.out.println("sf = "+sf);
		// System.out.println((double)sc/((double)sf + (double)(sc)));
		System.out.println(success);
	}

	public static void dfs(int x, int y, double p, int depth, boolean isFail) {
		if (depth == N) {
			if (isFail) {
				fail+=p;
				sf++;
			} else {
				success+=p;
				sc++;
				// System.out.println("x = "+x + ", y = "+y);
			}
			return;
		}

		visited[x][y] ++;
		for (int d = 0; d < 4; d++) {
			if(per[d] == 0.0) continue;

			int nx = x+dx[d];
			int ny = y+dy[d];
			double np = p*per[d];
			if(isFail){ //이미 단순하지 않은 경우
				dfs(nx, ny, np, depth + 1, true);
			}else{ // 아직 단순한 경우
				if (visited[nx][ny] > 0) {
					dfs(nx, ny, np, depth + 1, true);
				} else{
					dfs(nx, ny, np, depth + 1, false);
				}
			}

		}
		visited[x][y] --;
	}

	public static class Data {
		int x;
		int y;
		double p;
		boolean isFail;

		public Data(int x, int y, double p, boolean isFail) {
			this.x = x;
			this.y = y;
			this.p = p;
			this.isFail = isFail;
		}
	}
}
