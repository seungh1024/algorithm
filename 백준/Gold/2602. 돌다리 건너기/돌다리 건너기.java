import java.io.*;
import java.util.*;

public class Main {
	public static char[] rings;
	public static char[][] input;

	public static int N, M;
	public static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		rings = br.readLine().toCharArray();

		char[] arr1 = br.readLine().toCharArray();
		char[] arr2 = br.readLine().toCharArray();
		N = rings.length;
		M = arr1.length;
		input = new char[2][M];
		input[0] = arr1;
		input[1] = arr2;
		dp = new int[2][N][M];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < N; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		int sum = find(0, 0, 0);
		sum += find(1, 0, 0);

		System.out.println(sum);
	}

	public static int find(int upDownIdx, int ringIdx, int idx) {
		if (ringIdx >= N) {
			return 1;
		}
		if (idx >= M) {
			return 0;
		}

		if(dp[upDownIdx][ringIdx][idx] != -1) {
			return dp[upDownIdx][ringIdx][idx];
		}


		int cnt = 0;
		for (int i = idx; i < M; i++) {
			if (input[upDownIdx][i] == rings[ringIdx]) {
				cnt += find((upDownIdx + 1) % 2, ringIdx + 1, i + 1);
			}
		}

		return dp[upDownIdx][ringIdx][idx] = cnt;
	}
}