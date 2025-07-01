

import java.io.*;
import java.util.Stack;

public class Main {
	public static char[] data;
	public static int[] cnt;
	public static int N;
	public static boolean[][][][][] visited;
	public static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		N = input.length;
		cnt = new int[3];

		for (int i = 0; i < N; i++) {
			if (input[i] == 'A') {
				cnt[0]++;
			} else if (input[i] == 'B') {
				cnt[1]++;
			} else if (input[i] == 'C') {
				cnt[2]++;
			}
		}

		stack = new Stack<>();
		visited = new boolean[51][51][51][3][3];
		if (find(0, 0, 0, 0, 0)) {
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				int now = stack.pop();
				if (now == 0) {
					sb.append("A");
				} else if (now == 1) {
					sb.append("B");
				} else {
					sb.append("C");
				}
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}

	public static boolean find(int a, int b, int c, int last1, int last2) {
		// System.out.println("a = "+a +", b = "+b +", c = "+c + ", last1 = "+last1 + ", last 2 = "+last2);
		if (a == cnt[0] && b == cnt[1] && c == cnt[2]) {
			return true;
		}
		if (a > cnt[0] || b > cnt[1] || c > cnt[2]) {
			return false;
		}
		if (visited[a][b][c][last1][last2]) {
			return false;
		}
		visited[a][b][c][last1][last2] = true;

		if (cnt[0] > 0) {
			if (find(a + 1, b, c, 0, last1)) {
				stack.push(0);
				return true;
			}
		}
		if (cnt[1] > 0) {
			if (last1 != 1 && find(a, b + 1, c, 1, last1)) {
				stack.push(1);
				return true;
			}
		}
		if (cnt[2] > 0) {
			if (last1 != 2 && last2 != 2 && find(a, b, c + 1, 2, last1)) {
				stack.push(2);
				return true;
			}
		}

		return false;
	}
}
