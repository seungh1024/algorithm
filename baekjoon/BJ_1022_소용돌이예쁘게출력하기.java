package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_1022_소용돌이예쁘게출력하기 {
	public static int r,c;
	public static int[][] data;
	public static int[] dx = {0, -1, 0, 1};
	public static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		r = r2-r1+1;
		c = c2-c1+1;

		data = new int[r][c];

		int x = 0;
		int y = 0;
		int cnt = 0;
		int value = 1;
		int change = 1;
		int move = 0;
		int d = 0;
		int range = 0;
		int max = 0;
		int limit = 10001*10001;
		while (range ++ < limit) {

			if (x >= r1 && x <= r2 && y >= c1 && y <= c2) {
				data[x-r1][y-c1] = value;
				max = Math.max(max,value);
			}
			// System.out.println("x = "+x + ", y ="+y + ", cnt = "+cnt +", change = "+change);
			if (cnt == change) {
				cnt = 0;
				d = (d+1)%4;
				move++;
			}
			if (move == 2) {
				change++;
				move = 0;
			}

			// System.out.println("d = "+d + ", move = "+move + ", change = "+change);

			x+=dx[d];
			y+=dy[d];
			value++;
			cnt++;
		}

		String s = max+"";
		int length = s.length();
		int target = 1;
		for (int i = 1; i < length; i++) {
			target *= 10;
		}

		// System.out.println(target);

		StringBuilder sb = new StringBuilder();
		String empty = " ";
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int temp = data[i][j];
				// System.out.println("i = "+i + ", j ="+j);
				// System.out.println("temp = "+temp);
				while (temp < target) {
					sb.append(empty);
					temp *= 10;
					// System.out.println("temp = "+temp);
				}
				sb.append(data[i][j]).append(empty);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
