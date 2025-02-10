import java.io.*;
import java.util.*;

public class Main {
	public static int N, M;
	public static int[] mem;
	public static int[] cost;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mem = new int[N];
		cost = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			mem[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[10001];

		for (int i = 0; i < N; i++) {
			int m = mem[i];
			int c = cost[i];
			for (int j = 10000; j >= 0; j--) {
				if (j - c >= 0) {
					if (dp[j] == 0) {
						dp[j] = dp[j - c] + m;
					} else if (dp[j] < M) {
						dp[j] = Math.max(dp[j],dp[j - c] + m);
					} else {
						dp[j] = Math.max(dp[j], dp[j - c] + m);
					}
				}
			}
		}

		// System.out.println(Arrays.toString(dp));
		// System.out.println(dp[484]);

		int result = Integer.MAX_VALUE;
		for (int i = 0; i <= 10000; i++) {
			if (dp[i] >= M) {
				result = Math.min(result, i);
			}
		}
		System.out.println(result);
	}
}