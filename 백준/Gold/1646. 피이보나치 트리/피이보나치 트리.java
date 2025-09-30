

import java.io.*;
import java.util.*;

public class Main {
	public static long[] dp;
	public static int N,start, end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());


		dp = new long[51];
		dp[0] = 1;
		dp[1] =1;
		for (int i = 2; i <= 50; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + 1;
		}
		// System.out.println(dp[50]);

		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		find(N, start, sb1);
		find(N, end, sb2);
		String s1 = sb1.toString();
		String s2 = sb2.toString();

		int length1 = s1.length();
		int length2 = s2.length();

		int idx = 0;
		int range = Math.min(length1, length2);
		for (int i = 0; i < range; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				break;
			}
			idx++;
		}

		StringBuilder sb = new StringBuilder();
		if (idx == length1) {
			for (int i = length1; i < length2; i++) {
				sb.append(s2.charAt(i));
			}
		} else if (idx == length2) {
			for (int i = length2; i < length1; i++) {
				sb.append('U');
			}
		} else {
			for (int i = idx; i < length1; i++) {
				sb.append('U');
			}
			for (int i = idx; i < length2; i++) {
				sb.append(s2.charAt(i));
			}

		}


		System.out.println(sb);
	}

	public static void find(int idx, long num, StringBuilder s) {
		if(idx <= 1 || num == 1) return;
		num--;
		if (dp[idx - 2] >= num) {
			s.append('L');
			find(idx - 2, num, s);
		} else {
			s.append('R');
			find(idx - 1, num - dp[idx - 2], s);
		}

	}
}
