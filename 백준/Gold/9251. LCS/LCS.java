import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] up = br.readLine().toCharArray();
		char[] down = br.readLine().toCharArray();

		int[][] dp = new int[up.length + 1][down.length + 1];

		int max = 0;
		for (int i = 1; i <= up.length; i++) {
			for (int j = 1; j <= down.length; j++) {
				if (up[i - 1] == down[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}


		System.out.println(dp[up.length][down.length]);

	}
}