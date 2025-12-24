

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		if (find(1)) {
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= N; i++) {
				sb.append(data[i]).append(" ");
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}

	public static boolean find(int x) {
		if (x == N+1) {
			return true;
		}

		if (data[x] != 0) {
			if (find(x + 1)) {
				return true;
			}
			return false;
		}

		for (int y = 1; y <= N; y++) {
			boolean check = false;
			// if (data[1] == 3 && data[2] == 1 && x == 3 && y == 6) {
			// 	System.out.println("here");
			// }
			for (int lx = 1; lx <=N; lx++) {
				int ly = data[lx];
				if(x == lx || ly == 0) continue;
				if(ly == y){
					check = true;
					break;
				}
				// if (data[1] == 3 && data[2] == 1 && x == 3 && y == 6) {
				// 	System.out.println("x = "+x +", y ="+y);
				// 	System.out.println("lx = "+lx+", ly = "+ly);
				// }
				double v = (double)Math.abs(y - ly) / (double)Math.abs(x - lx);
				if (v == 1) {
					check = true;
					break;
				}
			}
			if (!check) {
				data[x] = y;
				if (find(x + 1)) {
					return true;
				}
				data[x] = 0;
			}
		}


		return false;
	}
}
