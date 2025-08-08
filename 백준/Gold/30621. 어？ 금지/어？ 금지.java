

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int[] T;
	public static int[] B;
	public static int[] C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		B = new int[N];
		C = new int[N];
		init(br, T);
		init(br, B);
		init(br, C);

		long[][] dp = new long[N][2];
		dp[0][0] = C[0]; // 0 ->외친다, 1 -> 외치지 않는다
		for (int i = 1; i < N; i++) {
			int t = T[i];
			int b = B[i];
			int c = C[i];
			int target = t-b-1;
			if (target < T[0]) {
				dp[i][0] = c;
			} else {
				int idx = find(0, i - 1, target, T);
				// System.out.println("i = "+i + " , idx = "+idx + ", target = "+target +", T = "+T[idx]) ;
				if (target < T[idx]) {
					idx--;
				}
				dp[i][0] = Math.max(dp[idx][0], dp[idx][1]) + c;

			}
			dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
		}
		System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
		// for (int i = 0; i < N; i++) {
		// 	System.out.println(Arrays.toString(dp[i]));
		// }
	}

	public static int find(int start, int end, int target, int[] arr) {

		while (start < end) {
			int mid = (start + end) / 2;

			if (arr[mid] >= target) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}

	public static void init(BufferedReader br, int[] arr) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
}

// 4
// 1 2 5 10
// 1 1 2 5
// 4 5 3 5