

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static char[] data;
	public static int[] count;
	public static boolean[][][][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		N = input.length;
		data = new char[N];
		count = new int[3];
		for (char c : input) {
			if (c == 'A') {
				count[0]++;
			} else if (c == 'B') {
				count[1]++;
			} else if (c == 'C') {
				count[2]++;
			}
		}

		visited = new boolean[51][51][51][3][3];

		if (find(0, 0, 0, 0, 0, 0)) {
			StringBuilder sb = new StringBuilder();
			for (char c : data) {
				sb.append(c);
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}

	public static boolean find(int idx,int a, int b, int c, int last1, int last2) {
		// System.out.println(
		// 	"idx = " + idx + " a = " + a + ", b = " + b + ", c = " + c + ", last1 = " + last1 + ", last2 = " + last2 + ", count = "+Arrays.toString(count));
		if (a == count[0] && b == count[1] && c == count[2]) {
			return true;
		}
		if (a > count[0] || b > count[1] || c > count[2]) {
			return false;
		}
		if (visited[a][b][c][last1][last2]) {
			return false;
		}
		visited[a][b][c][last1][last2] = true;

		if (count[0] > 0) {
			data[idx] = 'A';
			if (find(idx+1,a + 1, b, c, 0, last1)) {
				return true;
			}
		}
		if (count[1] > 0) {
			data[idx] = 'B';
			if (last1 != 1 && find(idx + 1, a, b + 1, c, 1, last1)) {
				return true;
			}
		}
		if (count[2] > 0) {
			data[idx] = 'C';
			if (last1 != 2 && last2 != 2 && find(idx + 1, a, b, c + 1, 2, last1)) {
				return true;
			}
		}

		return false;
	}
}
