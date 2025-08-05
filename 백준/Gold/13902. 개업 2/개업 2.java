

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] data = new int[M];
		for (int i = 0; i < M; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				int v = data[i]+data[j];
				if (!set.contains(v)) {
					list.add(v);
					set.add(v);
				}
			}
			if (!set.contains(data[i])) {
				set.add(data[i]);
				list.add(data[i]);
			}
		}

		int[] dp = new int[10001];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		int size = list.size();
		for (int i = 0; i < size; i++) {
			int v = list.get(i);
			for (int j = 0; j <= 10000; j++) {
				if (j + v <= 10000 && dp[j] != Integer.MAX_VALUE) {
					dp[j + v] = Math.min(dp[j + v], dp[j] + 1);
				}
			}
		}
		if (dp[N] == Integer.MAX_VALUE) {
			dp[N] = -1;
		}

		System.out.println(dp[N]);

	}
}
