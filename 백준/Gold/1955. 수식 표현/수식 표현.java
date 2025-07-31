
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		// if (N <= 5) {
		// 	System.out.println(N);
		// 	return;
		// }

		int[] dp = new int[10001];
		// for (int i = 1; i <= 10000; i++) {
		// 	dp[i] = i;
		// }
		Arrays.fill(dp, 10000);
		dp[1] = 1;
		int temp = 1;
		for (int i = 1; i <= 10000; i++) {

			temp *= i;
			if (temp >= 10000) {
				temp = 10001;
			}

			for (int j = 1; j <= i; j++) {
				if (i * j <= 10000) {
					dp[i * j] = Math.min(dp[i * j], dp[j] + dp[i]);
				}
				if (i + j <= 10000) {
					dp[i + j] = Math.min(dp[i + j], dp[j] + dp[i]);
				}
				
			}
            if (temp <= 10000) {
                dp[temp] = Math.min(dp[temp], dp[i]);
            }

		}
		System.out.println(dp[N]);
	}
}
