

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N+1];
		long[] dp = new long[500001];
		long[] count = new long[500001];
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(br.readLine());
			count[data[i]]++;
		}
		Arrays.sort(data);
		dp[0] = 1;
		dp[0] += count[data[0]];

		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			int num = data[i];
			if(set.contains(num)) continue;
			set.add(num);
			for (int j = 500000; j > 0; j--) {
				for (int k = 1; k <= count[num]; k++) {
					int idx = k*num;
					if(j-idx < 0) break;
					dp[j] += dp[j - idx];
				}
			}
		}

		boolean[] check = new boolean[500001];
		int range = (int)Math.sqrt(500000);
		for (int i = 2; i <= range; i++) {
			if(check[i]) continue;
			for (int j = i * 2; j <= 500000; j += i) {
				check[j] = true;
			}
		}
		long result = 0;
		for (int i = 2; i <= 500000; i++) {
			if (!check[i]) {
				result += dp[i];
			}
		}

		System.out.println(result);


	}
}
