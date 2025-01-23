import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static int[][] data;
	public static int[] count = {0, 5, 5, 5, 5, 5};
	public static int result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = new int[10][10];
		int total = 0;
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
				if (data[i][j] == 1) {
					total++;
				}
			}
		}

		result = Integer.MAX_VALUE;
		find(0, 0, total,0);
		if (result == Integer.MAX_VALUE) {
			result = -1;
		}

		System.out.println(result);
	}

	public static void find(int x, int y, int total, int cnt) {

		if (total == 0 ) {
			result = Math.min(result, cnt);
			return;
		}

		if (cnt >= result) {
			return;
		}


		if (data[x][y] == 1) {
			for (int i = 5; i > 0; i--) {
				if (isValid(x, x + i, y, y + i) && count[i] > 0) {
					changeValue(x, x + i, y, y + i, 0);
					count[i]--;
					if (y + 1 >= 10) {
						find(x + 1, 0, total -(i*i), cnt+1);
					} else {
						find(x, y + 1, total - (i*i),cnt+1);
					}
					count[i]++;
					changeValue(x, x + i, y, y + i, 1);
				}
			}
		} else {
			if (y + 1 >= 10) {
				find(x + 1,0,total, cnt);
			} else {
				find(x, y + 1,total, cnt);
			}
		}

	}


	public static boolean isValid(int x, int xend, int y, int yend) {
		if(xend > 10 || yend > 10) return false;

		for (int i = x; i < xend; i++) {
			for(int j = y; j < yend; j++) {
				if(data[i][j] == 0) return false;
			}
		}

		return true;
	}


	public static void changeValue(int x, int xend, int y, int yend, int num) {
		for (int i = x; i < xend; i++) {
			for (int j = y; j <yend; j++) {
				data[i][j] = num;
			}
		}
	}

	public static void printData() {
		System.out.println("===== print data ======");
		for (int i = 0; i < 10; i++) {
			System.out.println(Arrays.toString(data[i]));
		}

	}
}