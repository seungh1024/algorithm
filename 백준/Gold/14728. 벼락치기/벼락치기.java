import java.io.*;
import java.util.*;

public class Main {
	public static int N, T;
	public static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		dp = new int[T+1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			for (int j = T; j > 0; j--) {
				if(j-K < 0)  break;

				dp[j] = Math.max(dp[j], dp[j - K] + S);
			}
		}
		// System.out.println(dp[110]);

		int result = Arrays.stream(dp)
			.max().getAsInt();
		System.out.println(result);
	}
}