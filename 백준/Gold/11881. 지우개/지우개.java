

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static long[] data;
	public static long[] count;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		List<Integer> list = new ArrayList<>();
		count = new long[100001];
		long[] sum = new long[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int v = Integer.parseInt(st.nextToken());
			if (count[v] == 0) {
				list.add(v);
			}
			count[v]++;
		}

		long mod = 1000000007;

		int idx = 1;
		for (int i : list) {
			if (count[i] > 0) {
				sum[idx] = sum[idx - 1] + i * count[i] % mod;
				sum[idx]%=mod;
				idx++;
			}
		}

		long[] dp = new long[idx];
		long result = 0;
		for (int i = 1; i < idx; i++) {
			// System.out.println("i = "+i);
			// System.out.println(list.get(i-1));
			dp[i] = dp[i - 1] + (sum[i - 1] * (list.get(i - 1)*count[list.get(i-1)])%mod) % mod;
			dp[i] %= mod;

			result += (dp[i - 1] * (list.get(i - 1)*count[list.get(i-1)])%mod) % mod;
			result %= mod;
		}
		System.out.println(result);
	}

}
