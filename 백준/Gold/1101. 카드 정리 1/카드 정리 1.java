

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] data = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;
		Set<Integer> set = new HashSet<>();
		int add = 0;
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			int idx = 0;
			for (int j = 0; j < M; j++) {
				if (data[i][j] > 0) {
					cnt++;
					idx = j;
				}
			}
			if (cnt >= 2) {
				result++;
			} else if(cnt == 1) {
				if (!set.contains(idx)) {
					set.add(idx);
				} else {
					result++;
				}
			}
		}

		if (result > 0) {
			result--;
		}
		// System.out.println("result = "+result +", add = "+add);
		// result+=add;

		System.out.println(result);

	}
}
