package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_1633_최고의팀만들기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = "";
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		List<Integer> w = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		while ((input = br.readLine()) != null && !input.isEmpty() && !input.isBlank()) {
			String[] data = input.split(" ");
			int white = Integer.parseInt(data[0]);
			int black = Integer.parseInt(data[1]);

			w.add(white);
			b.add(black);
		}

		int N = w.size();
		int[][][] dp = new int[N][16][16];
		dp[0][1][0] = w.get(0);
		dp[0][0][1] = b.get(0);

		int result = 0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 16; j++) {
				for (int k = 0; k < 16; k++) {
					int temp1 = 0;
					int temp2 = 0;
					if (j > 0) {
						temp1 = Math.max(temp1, dp[i - 1][j - 1][k] + w.get(i));
					}
					if (k > 0) {
						temp2 = Math.max(temp2, dp[i - 1][j][k - 1] + b.get(i));
					}
					dp[i][j][k] = Math.max(temp1, temp2);
					dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
				}
			}
			result = Math.max(result, dp[i][15][15]);
		}

		System.out.println(result);


	}
}
