

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		int size = 100001;
		int[] dp = init(size);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(dp[n]).append("\n");
		}
		System.out.println(sb);
	}

	public static int[] init(int size) {
		int mod = 1000000007;
		int[] dp = new int[size];
		List<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[size];
		int range = (int)Math.sqrt(size);
		for (int i = 2; i <= range; i++) {
			int num = i;
			while (num < size) {
				num += i;
				if(num >=size) break;
				visited[num] = true;
			}
		}

		for (int i = 2; i < size; i++) {
			if (!visited[i]) {
				list.add(i);
			}
		}

		for (int i : list) {
			dp[i] += 1;
			for (int j = 2; j < size; j++) {
				if(j-i <0) continue;
				dp[j] += dp[j - i];
				dp[j] %= mod;
			}
		}



		return dp;
	}
}
/**
 * 1 -> 0
 * 2 -> 1
 * 3 -> 1
 * 4 -> 1
 * 5 -> 2
 * 6 -> 2  (3+3), (2+2+2),
 * 7 -> 3
 * 8 -> 3 (2+2+2+2), (2+3+3), (3+5)
 * 9 -> 4 (3+3+3), (2+2+2+3), (2+2+5), (2+7)
 * 10 -> 5
 */
