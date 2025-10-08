

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();

		long r = 0;
		long o = 0;
		long c = 0;
		long k = 0;
		long mod = 1000000007;
		long cnt = 1;
		for (int i = 0; i < N; i++) {
			if (input[i] == 'K') {
				k += c;
				k %= mod;
			} else if (input[i] == 'C') {
				c += o;
				c %= mod;

			} else if (input[i] == 'O') {
				o += r;
				o %= mod;

			} else if (input[i] == 'R') {
				r += cnt;
				r %= mod;
			}
			cnt*=2;
			cnt %= mod;
		}

		System.out.println(k);
	}
}
