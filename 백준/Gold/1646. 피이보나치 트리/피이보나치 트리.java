

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static int start, end;
	public static long[] dp;
	public static Character U = 'U', L = 'L', R = 'R';

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		if (N == 0) {
			return;
		}
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		dp = new long[51];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= 50; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + 1;
		}

		// System.out.println(Arrays.toString(dp));
		List<Character> l1 = new ArrayList();
		List<Character> l2 = new ArrayList<>();
		find(N, start, l1);
		find(N, end, l2);
		// System.out.println(l1);
		// System.out.println(l2);

		StringBuilder sb = new StringBuilder();
		
		if (l1.isEmpty()) {
			for (char c : l2) {
				sb.append(c);
			}
			System.out.println(sb);
			return;
		} else if (l2.isEmpty()) {
			for (char c : l1) {
				sb.append(U);
			}
			System.out.println(sb);
			return;
		}

		int idx = 0;
		while (true) {
			char c1 = l1.get(idx);
			char c2 = l2.get(idx);
			if (c1 != c2) {
				break;
			}
			idx++;
			if (idx >= l1.size() || idx >= l2.size()) {
				break;
			}
		}

		if (idx == l1.size()) { // l1이 l2에 포함되는 경우
			for (int i = idx; i < l2.size(); i++) {
				sb.append(l2.get(i));
			}
		} else if (idx == l2.size()) { // l2가 l1에 포함되는 경우
			for (int i = idx; i < l1.size(); i++) {
				sb.append(U);
			}
		} else {
			for (int i = idx; i < l1.size(); i++) {
				sb.append(U);
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

		if (dp[idx-2] >= value) {
			list.add(L);
			find(idx-2,value,list);
		} else {
			list.add(R);
			find(idx - 1, value - dp[idx - 2], list);
		}
	}
}
