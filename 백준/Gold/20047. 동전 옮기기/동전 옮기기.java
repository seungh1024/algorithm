

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static boolean[][] dp;
	public static char[] data, S, T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		S = new char[N];
		T = br.readLine().toCharArray();
		data = new char[2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		data[0] = input[a];
		data[1] = input[b];

		int idx = 0;
		for (int i = 0; i < N; i++) {
			if(a == i || b == i)continue;
			S[idx++] = input[i];
		}

		dp = new boolean[3][N];

		if (find(0, 0)) {

			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static boolean find(int status, int idx) {
		if (status+idx == N-1) {
			return true;
		}

		if (idx == N - 2) {
			return false;
		}

		if (S[idx] == T[idx + status]) {
			if ((find(status, idx + 1))) {
				return true;
			}
		}


		if(status == 2) return false;

		if (data[status] == T[idx + status]) {
			if (find(status + 1, idx)) {
				return true;
			}
		}

		return false;
	}
}
