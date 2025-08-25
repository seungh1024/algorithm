

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int N = Integer.parseInt(br.readLine());
		String[] data = new String[N];
		int[] point = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			data[i] = st.nextToken();
			point[i] = Integer.parseInt(st.nextToken());
		}

		int idx = 0;
		int length = s.length();
		int[] dp = new int[length];
		dp[0] = 1;

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < N; j++) {
				if (s.startsWith(data[j], i)) {
					if (i - 1 >= 0) {
						dp[i + data[j].length() - 1] = Math.max(dp[i + data[j].length() - 1], dp[i - 1] + point[j]);
					} else {
						dp[i + data[j].length() - 1] = point[j];
					}
				}
			}
			if (i - 1 >= 0) {
				dp[i] = Math.max(dp[i], dp[i - 1] + 1);
			}
		}
		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[length-1]);
	}
}
