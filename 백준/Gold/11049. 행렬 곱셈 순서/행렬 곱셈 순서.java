import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[][] dp;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		List<int[]> list = new ArrayList<>();
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list.add(new int[] {r, c});
		}

		for (int k = 1; k < N; k++) {
			for (int i = 0; i + k < N; i++) {
				dp[i][i + k] = Integer.MAX_VALUE;

				for (int j = i; j < i + k; j++) {
					dp[i][i + k] = Math.min(dp[i][i + k],
						dp[i][j] + dp[j + 1][i + k] + list.get(i)[0] * list.get(j)[1] * list.get(i + k)[1]);
				}
			}
		}

		System.out.println(dp[0][N - 1]);

	}
}