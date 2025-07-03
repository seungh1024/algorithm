

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());

		boolean[] dp = new boolean[K + 1];
		for (int i = K; i >= 1; i--) {
			for (int j = 1; j * j <= i; j++) {
				if (i % j == 0) {

					if (i + j <= K && !dp[i + j]) {
						dp[i] = true;
						break;
					}

					if (i + i / j <= K && !dp[i + i / j]) {
						dp[i] = true;
						break;
					}
				}
			}
		}

		if (dp[1]) {
			System.out.println("Kali");
		} else {
			System.out.println("Ringo");
		}
	}
}
