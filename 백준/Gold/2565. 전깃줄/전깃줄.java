import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.add(new int[]{a, b});
		}

		Collections.sort(list, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
		int[] dp = new int[N];

		Arrays.fill(dp, 1);
		int max = 1;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (list.get(i)[1] > list.get(j)[1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

			max = Math.max(max, dp[i]);
		}
		// System.out.println(Arrays.toString(dp));

		System.out.println(N-max);
	}
}