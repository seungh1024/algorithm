

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Long>[] dp = new HashMap[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
			dp[i] = new HashMap<>();
		}

		long result = 0;
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				int idx = data[i] - data[j];
				if (dp[j].get(idx) == null) {
					dp[i].put(idx, (long)data[i] + data[j]);
				} else {
					long v = dp[j].get(idx) + data[i];
					dp[i].put(idx, v);
					result = Math.max(result, v);
				}
			}
		}

		System.out.println(result);
		

	}
}
