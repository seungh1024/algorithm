

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = 100000;
		int[] dp = new int[size + 1];
		List<Integer> list = new ArrayList<>();
		boolean[] visited = new boolean[size + 1];
		int range = (int)Math.sqrt(size);
		for (int i = 2; i <= range; i++) {
			int num = i;
			while (num <= size) {
				num += i;
				if(num > size) break;
				visited[num] = true;
			}
		}

		for (int i = 2; i <= size; i++) {
			if (!visited[i]) {
				list.add(i);
			}
		}

		// System.out.println(list);
		// System.out.println(list.size());

		int mod = 1000000007;
		for (int i : list) {
			dp[i] += 1;
			for (int j = 2; j <= size; j++) {
				if(j-i < 0) continue;
				dp[j] += dp[j-i];
				dp[j] %= mod;
			}
		}

		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(dp[N]).append("\n");
		}
		System.out.println(sb);
	}
}
