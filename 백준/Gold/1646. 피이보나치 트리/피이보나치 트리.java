

import java.io.*;
import java.util.*;

public class Main {
	public static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());

		dp = new long[51];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= 50; i++) {
			dp[i] = dp[i - 1] + dp[i - 2]+1;
		}

		List<Character> l1 = new ArrayList<>();
		List<Character> l2 = new ArrayList<>();
		find(N, from, l1);
		find(N, to, l2);

		int size = Math.min(l1.size(), l2.size());
		int idx = 0;
		for (int i = 0; i < size; i++) {
			if (l1.get(i) != l2.get(i)) {
				break;
			}
			idx++;
		}
		StringBuilder sb = new StringBuilder();
		if (idx == l1.size()) {
			for (int i = idx; i < l2.size(); i++) {
				sb.append(l2.get(i));
			}
		} else if (idx == l2.size()) {
			for (int i = idx; i < l1.size(); i++) {
				sb.append('U');
			}
		} else {
			for (int i = idx; i < l1.size(); i++) {
				sb.append('U');
			}
			for (int i = idx; i < l2.size(); i++) {
				sb.append(l2.get(i));
			}
		}
		System.out.println(sb);
	}

	public static void find(int idx, long value, List list) {
		if (idx <= 1 || value == 1) {
			return;
		}
		value--;

		if (dp[idx - 2] >= value) {
			list.add('L');
			find(idx - 2, value, list);
		} else {
			list.add('R');
			find(idx - 1, value - dp[idx - 2], list);
		}
	}
}
