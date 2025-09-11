

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int M = Integer.parseInt(br.readLine());
		String[] data = new String[M];
		int[] point = new int[M];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int p = Integer.parseInt(st.nextToken());
			data[i] = s;
			point[i] = p;
		}

		int N = input.length();
		int[] dp = new int[N];
		dp[0] = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				String s = data[j];
				int p = point[j];
				if(input.startsWith(s,i)){
					int l = s.length();
					if (i == 0) {
						dp[i+l-1] = Math.max(dp[i+l-1],p);
					} else {
						dp[i + l - 1] = Math.max(dp[i + l - 1], dp[i - 1] + p);
					}
				}
				if (i != 0) {
					dp[i] = Math.max(dp[i], dp[i - 1] + 1);
				}
			}
		}
		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[N-1]);
	}
}
