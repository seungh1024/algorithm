package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_1799_비숍 {
	public static int N;
	public static int[][] data;
	public static int count;
	public static List<int[]> list;
	public static int wb;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (N == 1) {
			if (data[0][0] == 1) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			return;
		}

		int result = 0;
		count = 0;
		list = new ArrayList<>();
		int wx = -1;
		int wy = -1;
		int x = 0;
		int y = 0;
		while (x < N) {
			if ((x+y)%2 == 0 && data[x][y] == 1) {
				wx = x;
				wy = y;
				break;
			}
			y++;
			if (y >= N) {
				x++;
				y = 0;
			}
		}
		wb = 0;
		if (wx != -1 && wy != -1) {
			// System.out.println("white start");
			find(wx, wy);
		}
		result += count;
		// System.out.println("white count = "+result);

		count = 0;
		list = new ArrayList<>();
		int bx = -1;
		int by = -1;
		x = 0;
		y = 1;
		while (x < N) {
			if ((x+y)%2 == 1 && data[x][y] == 1) {
				bx = x;
				by = y;
				break;
			}
			y++;
			if (y >= N) {
				x++;
				y = 0;
			}
		}
		wb = 1;
		if (bx != -1 && by != -1) {
			// System.out.println("black start");
			find(bx, by);
		}
		result += count;
		System.out.println(result);
	}

	public static void find(int x, int y) {
		// System.out.println("x = "+x + ", y = "+y);
		// if (list.size() > count) {
		// 	System.out.println("!!");
		// 	for (int[] l : list) {
		// 		System.out.println(Arrays.toString(l));
		// 	}
		// }
		count = Math.max(count, list.size());

		if(x == N){
			return;
		}

		boolean flag = false;
		for (int[] l : list) {
			double v = Math.abs(((double)l[1] - (double)y) / ((double)l[0] - (double)x));
			int xx = Math.abs(l[0]-x);
			int yy = Math.abs(l[1] - y);
			if (xx == yy) {
				flag = true;
				break;
			}
		}

		int nx = x;
		int ny = y;
		while(true){
			ny ++;
			if (ny >= N) {
				nx++;
				ny = 0;
			}
			if (nx == N) {
				break;
			}
			if ((nx+ny)%2 == wb && data[nx][ny] == 1) {
				break;
			}
		}
		if (!flag && data[x][y] == 1) {
			// System.out.println("nx = "+ nx +", ny = "+ny);
			list.add(new int[] {x, y});
			find(nx, ny);
			list.remove(list.size()-1);
		}

		find(nx, ny);

	}
}
// 10
// 0 1 1 1 1 1 1 1 0 1
// 0 1 1 1 1 0 1 1 0 1
// 0 1 0 0 0 0 0 0 1 1
// 0 1 1 1 1 1 1 1 0 0
// 1 0 1 1 0 1 1 1 1 0
// 1 0 1 1 1 0 1 1 1 1
// 1 0 0 1 1 1 1 1 1 1
// 0 1 1 0 1 0 0 0 1 1
// 1 1 1 0 1 1 1 1 1 0
// 1 1 1 0 0 0 1 1 0 0