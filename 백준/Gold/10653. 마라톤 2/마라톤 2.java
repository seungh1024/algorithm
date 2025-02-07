import java.io.*;
import java.util.*;

public class Main {
	public static int N, K;
	public static int[][] data;
	public static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		List<int[]> input = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			input.add(new int[]{x, y});
		}

		data = new int[N][N];

		for (int i = 0; i < N; i++) {
			int[] now = input.get(i);
			for (int j = i + 1; j < N; j++) {
				int[] next = input.get(j);
				int length = Math.abs(now[0]-next[0]) + Math.abs(now[1]-next[1]);
				data[i][j] = length;
				data[j][i] = length;
			}
		}

		dp = new int[N][K + 1];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}

		int result = find(N-1, K);
		System.out.println(result);
	}

	public static int find(int idx, int k) {
		if (idx == 0) {
			return 0;
		}

		if(dp[idx][k] != -1) return dp[idx][k];

		int min = 1000000;
		for (int i = 0; i <= k; i++) {
			if(idx - k -1 < 0) break;

			min = Math.min(min, find(idx - i - 1, k - i) + data[idx - i - 1][idx]);
		}

		return dp[idx][k] = min;
	}

}