

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] dp = new boolean[N][3];
		char[] S = br.readLine().toCharArray();
		char[] T = br.readLine().toCharArray();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		char[] data = {S[a], S[b]};
		char[] temp = new char[N];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if(i == a || i == b)
				continue;
			temp[idx++] = S[i];
		}
		for (int i = 0; i < N; i++) {
			S[i] = temp[i];
		}
		S[N-1] = 'a';
		S[N-2] = 'a';

		if (S[0] == T[0]) {
			dp[0][0] = true;
		}
		if (T[0] == data[0]) {
			dp[0][1] = true;
		}


		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0] && (S[i] == T[i]);
			dp[i][1] = dp[i - 1][0] && (data[0] == T[i]) || dp[i - 1][1] && (S[i - 1] == T[i]);
			dp[i][2] = dp[i - 1][1] && (data[1] == T[i]) || dp[i - 1][2] && (S[i - 2] == T[i]);
		}

		if (dp[N-1][2]) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}


	}
}
