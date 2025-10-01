

import java.io.*;
import java.util.*;

public class Main {
	public static boolean[][][][][] visited;
	public static char[] data;
	public static int N;
	public static char[] arr;
	public static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = br.readLine().toCharArray();
		N = data.length;
		visited = new boolean[51][51][51][3][3];
		arr = new char[N];
		count = new int[3];
		for (int i = 0; i < N; i++) {
			count[data[i]-'A']++;
		}

		boolean result = find(0, 0, 0, 0, 0, 0);
		if (result) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(arr[i]);
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}

	public static boolean find(int idx, int a, int b, int c, int last1, int last2) {
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
			arr[idx] = 'A';
			if (find(idx + 1, a + 1, b, c, 0, last1)) {
				return true;
			}
		}
		if (count[1] > 0) {
			arr[idx] = 'B';
			if (last1 != 1 && find(idx + 1, a, b + 1, c, 1, last1)) {
				return true;
			}
		}

		if (count[2] > 0) {
			arr[idx] = 'C';
			if (last1 != 2 && last2 != 2 && find(idx + 1, a, b, c + 1, 2, last1)) {
				return true;
			}
		}

		return false;
	}
}
