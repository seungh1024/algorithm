package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_16939_2x2x2큐브 {
	public static int[][] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = new int[6][8];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			for (int j = 2; j < 4; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int start = 0;
		int end = start+2;
		for (int t = 0; t < 3; t++) {
			for (int i = 2; i < 4; i++) {
				for (int j = start; j < end; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			start += 2;
			if (start == 2) {
				start +=2;
			}
			end = start+2;
		}

		// printData();

		int[][] copy = getCopy();
		// 0,3 아래로
		// for (int i = 0; i < 4; i++) {
		// 	copy[(i+2)%6][3] = data[i][3];
		// }
		copy[2][3] = data[0][3];
		copy[3][3] = data[1][3];
		copy[4][3] = data[2][3];
		copy[5][3] = data[3][3];
		copy[3][6] = data[4][3];
		copy[2][6] = data[5][3];
		copy[0][3] = data[3][6];
		copy[1][3] = data[2][6];

		// System.out.println("0,3 down");
		// printData();
		// printCopy(copy);

		if (find(copy)) {
			System.out.println(1);
			return;
		}

		// 0,3 위로
		copy = getCopy();
		// for (int i = 2; i < 6; i++) {
		// 	copy[(i+4)%6][3] = data[i][3];
		// }
		copy[0][3] = data[2][3];
		copy[1][3] = data[3][3];
		copy[2][3] = data[4][3];
		copy[3][3] = data[5][3];
		copy[3][6] = data[0][3];
		copy[2][6] = data[1][3];
		copy[4][3] = data[3][6];
		copy[5][3] = data[2][6];


		// System.out.println("0,3 up");
		// printData();
		// printCopy(copy);

		if (find(copy)) {
			System.out.println(1);
			return;
		}

		// 0,2 down
		copy = getCopy();
		// for (int i = 0; i < 4; i++) {
		// 	copy[(i+2)%6][2] = data[i][2];
		// }
		copy[3][2] = data[1][2];
		copy[2][2] = data[0][2];
		copy[5][2] = data[3][2];
		copy[4][2] = data[2][2];

		copy[3][7] = data[4][2];
		copy[2][7] = data[5][2];
		copy[0][2] = data[3][7];
		copy[1][2] = data[2][7];

		// System.out.println("0,2 down");
		// printData();
		// printCopy(copy);

		if (find(copy)) {
			System.out.println(1);
			return;
		}

		// 0,2 위로
		copy = getCopy();
		// for (int i = 2; i < 6; i++) {
		// 	copy[(i+4)%6][2] = data[i][2];
		// }
		copy[0][2] = copy[2][2];
		copy[1][2] = copy[3][2];
		copy[2][2] = copy[4][2];
		copy[3][2] = copy[5][2];

		copy[3][7] = data[0][2];
		copy[2][7] = data[1][2];
		copy[4][2] = data[3][7];
		copy[5][2] = data[2][7];

		// System.out.println("0,2 위로");
		// printData();
		// printCopy(copy);

		if (find(copy)) {
			System.out.println(1);
			return;
		}

		// 2,2 오른쪽
		copy = getCopy();
		copy[1][3] = data[2][1];
		copy[1][2] = data[3][1];
		copy[3][4] = data[1][3];
		copy[2][4] = data[1][2];
		copy[4][2] = data[3][4];
		copy[4][3] = data[2][4];
		copy[2][1] = data[4][2];
		copy[3][1] = data[4][3];

		// System.out.println("2,2 오른쪽");
		// printData();
		// printCopy(copy);

		if (find(copy)) {
			System.out.println(1);
			return;
		}

		// 2,2 왼쪽
		copy = getCopy();
		copy[1][3] = data[3][4];
		copy[1][2] = data[2][4];
		copy[3][4] = data[4][2];
		copy[2][4] = data[4][3];
		copy[4][2] = data[2][1];
		copy[4][3] = data[3][1];
		copy[2][1] = data[1][3];
		copy[3][1] = data[1][2];

		// System.out.println("2,2 left");
		// printData();
		// printCopy(copy);

		if (find(copy)) {
			System.out.println(1);
			return;
		}

		copy = getCopy();
		for (int i = 0; i < 8; i++) {
			copy[2][(i+2)%8] = data[2][i];
		}
		if (find(copy)) {
			System.out.println(1);
			return;
		}

		copy = getCopy();
		for (int i = 0; i < 8; i++) {
			copy[2][(i+6)%8] = data[2][i];
		}
		if (find(copy)) {
			System.out.println(1);
			return;
		}



		System.out.println(0);
	}

	public static boolean find(int[][] copy) {
		for (int i = 0; i < 6; i += 2) {
			for (int j = 0; j < 8; j += 2) {

				int color = copy[i][j];
				if(color == 0) continue;
				for (int x = i; x < i + 2; x++) {
					for (int y = j; y < j + 2; y++) {
						if (copy[x][y] != color) {
							return false;
						}
					}
				}
			}
		}

		return true;
	}

	public static int[][] getCopy() {
		int[][] copy = new int[6][8];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 8; j++) {
				copy[i][j] = data[i][j];
			}
		}

		return copy;
	}

	public static void printData() {
		System.out.println("===========");
		for (int i = 0; i < 6; i++) {
			System.out.println(Arrays.toString(data[i]));
		}
	}

	public static void printCopy(int[][] copy) {
		System.out.println("=====copy=====");
		for (int i = 0; i < 6; i++) {
			System.out.println(Arrays.toString(copy[i]));
		}
	}
}
