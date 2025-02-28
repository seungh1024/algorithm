import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static boolean[][] monkey;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		monkey = new boolean[8][N];

		find(true, 0, 0, N);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= 7; i++) {
			for (int j = 0; j < N; j++) {
				if (monkey[i][j]) {
					sb.append('A');
				} else {
					sb.append('B');
				} 
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void find(boolean flag, int idx, int left, int right) {
		if (idx > 7) {
			return;
		}

		for (int i = left; i < right; i++) {
			if (!flag) {
				monkey[idx][i] = true;
			}
		}

		int mid = (left + right) / 2;
		find(flag, idx + 1, left, mid);
		find(!flag, idx + 1, mid, right);
	}
}