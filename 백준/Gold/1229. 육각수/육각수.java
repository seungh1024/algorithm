

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;

		List<Integer> list = new ArrayList<>();
		int plus = 1;
		int num = 0;
		while (num < 1000000) {
			num += plus;
			plus += 4;
			if(num > 1000000) break;
			list.add(num);
		}

		for (int i : list) {
			for (int j = 0; j <= N; j++) {
				if(j+i > N) break;
				if (dp[j] != Integer.MAX_VALUE) {
					dp[j + i] = Math.min(dp[j + i], dp[j] + 1);
				}
			}
		}
		System.out.println(dp[N]);

	}
}
