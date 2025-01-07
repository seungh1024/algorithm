package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_7682_틱택토 {
	public static char[][] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String VALID = "valid";
		String INVALID = "invalid";
		while (true) {
			String input = br.readLine();
			if(input.equals("end")) break;

			data = new char[3][3];
			char[] array = input.toCharArray();
			int idx = 0;
			int xCnt = 0;
			int oCnt = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					data[i][j] = array[idx++];
					if (data[i][j] == 'O') {
						oCnt++;
					} else if (data[i][j] == 'X') {
						xCnt++;
					}
				}
			}

			if (xCnt - 1 == oCnt) {
				if (xCnt + oCnt == 9 && !check('O')) {
					sb.append(VALID);
				}
				else if (!check('O') && check('X')) {
					sb.append(VALID);
				} else {
					sb.append(INVALID);
				}
			} else if (xCnt == oCnt) {
				if (check('O') && !check('X')) {
					sb.append(VALID);
				} else {
					sb.append(INVALID);
				}
			} else {
				sb.append(INVALID);
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}


	public static boolean check(char c) {
		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			for (int j = 0; j < 3; j++) {
				if (data[i][j] == c) {
					cnt++;
				}
			}
			if (cnt == 3) {
				return true;
			}
		}

		for (int i = 0; i < 3; i++) {
			int cnt = 0;
			for (int j = 0; j < 3; j++) {
				if (data[j][i] == c) {
					cnt++;
				}
			}
			if (cnt == 3) {
				return true;
			}
		}

		if (data[1][1] == c && data[0][0] == c && data[2][2] == c) {
			return true;
		}

		if (data[1][1] == c && data[2][0] == c && data[0][2] == c) {
			return true;
		}

		return false;
	}
}
