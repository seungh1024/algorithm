package vsfe_20240531;

import java.io.*;
import java.util.*;

public class BJ_2082_시계 {
	public static char[][][] data;
	public static char[][][] clock;

	public static void main(String[] args) throws IOException{
		initData();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		clock = new char[4][5][3];
		for (int i = 0; i < 5; i++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 3; k++) {
					clock[j][i][k] = input[j].charAt(k);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		// 0~2
		find(3, 0,sb);
		find(10, 1, sb);
		// System.out.println(sb);
		sb.append(":");
		find(6, 2, sb);
		find(10, 3, sb);
		System.out.println(sb);

	}

	public static void find(int range, int clockIndex, StringBuilder sb) {
		for (int n = 0; n < range; n++) {
			boolean flag = false;
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 3; j++) {
					if (clock[clockIndex][i][j] == '#' && data[n][i][j] != '#') {
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			if (!flag) {
				sb.append(n);
				break;
			}
		}
	}

	public static void initData() {
		data = new char[10][5][3];
		String input = "###  ..#  ###  ###  #.#  ###  ###  ###  ###  ###\n"
					 + "#.#  ..#  ..#  ..#  #.#  #..  #..  ..#  #.#  #.#\n"
					 + "#.#  ..#  ###  ###  ###  ###  ###  ..#  ###  ###\n"
					 + "#.#  ..#  #..  ..#  ..#  ..#  #.#  ..#  #.#  ..#\n"
					 + "###  ..#  ###  ###  ..#  ###  ###  ..#  ###  ###";
		StringTokenizer st = new StringTokenizer(input,"\n");

		int lineIndex = 0;
		while (st.hasMoreTokens()) {
			String[] line = st.nextToken().split("  ");
			// System.out.println(Arrays.toString(line));
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 3; j++) {
					data[i][lineIndex][j] = line[i].charAt(j);
				}
			}
			lineIndex++;
		}

		// for (int i = 0; i < 10; i++) {
		// 	for (int j = 0; j < 5; j++) {
		// 		System.out.println(Arrays.toString(data[i][j]));
		// 	}
		// 	System.out.println("=====");
		// }
	}
}
