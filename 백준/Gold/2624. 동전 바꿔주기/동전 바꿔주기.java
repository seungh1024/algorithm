import java.io.*;
import java.util.*;

public class Main {
	public static int K;
	public static int[] coin;
	public static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		coin = new int[K+1];
		count = new int[K+1];
		for (int i = 1; i <= K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			coin[i] = cost;
			count[i] = cnt;

		}

		int[] dp = new int[T + 1];

		dp[0] = 1;
		for (int i = 1; i <= K; i++) {
			int cost = coin[i];
			int cnt = count[i];
			for (int t = T; t >= 0; t--) {
				for (int j = 1; j <= cnt; j++) {
					if (t - cost * j >= 0) {
						dp[t] += dp[t - cost * j];
					}
				}
			}
		}


		System.out.println(dp[T]);

	}


}