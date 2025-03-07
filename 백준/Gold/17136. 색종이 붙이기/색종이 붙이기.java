import java.io.*;
import java.util.*;

public class Main {
	public static int[][] data = new int[10][10];
	public static int total = 0;
	public static int result = Integer.MAX_VALUE;
	public static int[] count = {0, 5, 5, 5, 5, 5};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] == 1) {
					total++;
				}
			}
		}

		if (total == 0) {
			System.out.println(0);
		} else {
			find(0, 0, 0,0);
			if (result == Integer.MAX_VALUE) {
				result = -1;
			}
			System.out.println(result);
		}

	}

	public static void find(int x, int y, int sum, int cnt) {
		if (sum == total) {
			result = Math.min(result, cnt);
			return;
		}
		if (x == 10) {
			return;
		}

		if (data[x][y] == 0) {
			if (y + 1 >= 10) {
				find(x + 1, 0, sum, cnt);
			} else {
				find(x, y + 1, sum, cnt);
			}
			return;
		}

		for (int i = 5; i > 0; i--) {
			if(count[i] == 0 || x+i > 10 || y+i > 10) continue;

			boolean flag = false;
			for (int a = x; a < x + i; a++) {
				for (int b = y; b < y + i; b++) {
					if (data[a][b] != 1) {
						flag = true;
						break;
					}
				}
				if(flag) break;
			}

			if (!flag) {
				// System.out.println("x = " + x + ", y = " + y);
				// System.out.println("i = "+i);
				count[i] --;
				for (int a = x; a < x + i; a++) {
					for (int b = y; b < y + i; b++) {
						data[a][b] = 0;
					}
				}
				if (y + 1 >= 10) {
					find(x + 1, 0, sum + i * i, cnt+1);
				} else {
					find(x, y + 1, sum + i * i,cnt+1);
				}

				for (int a = x; a < x + i; a++) {
					for (int b = y; b < y + i; b++) {
						data[a][b] = 1;
					}
				}
				count[i] ++;
			}
		}
	}
}