import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	public static int N, M, K;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[M + 1][K + 1];
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (b <= M && c <= K) {
				list.add(new int[] {b, c});
				// dp[b][c] = 1;
			}
		}

		for (int[] arr : list) {
			int x = arr[0];
			int y = arr[1];
			for (int i = M; i > 0; i--) {
				for (int j = K; j > 0; j--) {
					if(x > i || y > j) continue;

					dp[i][j] = Math.max(dp[i][j], dp[i-x][j-y]+1);

				}
			}
		}

		// for (int i = 0; i <= M; i++) {
		// 	System.out.println(Arrays.toString(dp[i]));
		// }

		Arrays.stream(dp)
			.flatMapToInt(Arrays::stream)
			.max()
			.ifPresent(System.out::println);


	}
}