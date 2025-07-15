

import java.io.*;
import java.util.*;

public class Main {
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		if (N % 2 == 0) {
			System.out.println("NOT POSSIBLE");
			return;
		}

		char[] c1 = new char[N / 2+1];
		char[] c2 = new char[N / 2+1];
		char[] c3 = new char[N / 2+1];
		char[] c4 = new char[N / 2+1];
		for (int i = 0; i < N / 2; i++) {
			c1[i] = input[i];
			c3[i] = input[i];
		}
		c1[N/2] = 'a';
		c3[N/2] = input[N/2];
		for (int i = N/2; i < N; i++) {
			c2[i-N/2] = input[i];
			if (i + 1 < N) {

				c4[i-N/2] = input[i+1];
			}
		}
		c4[N/2] = 'a';

		int cnt1 = 0;
		int cnt2 = 0;
		Set<String> set = new HashSet<>();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		// System.out.println(Arrays.toString(c1));
		// System.out.println(Arrays.toString(c2));
		for (int l = 0, r = 0; l <= N / 2 && r <= N/2; l++, r++) {
			// System.out.println("l = "+l + ", r = "+r);
			if (c1[l] != c2[r]) {
				cnt1++;
				l--;
			} else {

				sb1.append(c1[l]);
			}
		}

		if (cnt1 <= 1) {
			set.add(sb1.toString());
		}

		// System.out.println(Arrays.toString(c3));
		// System.out.println(Arrays.toString(c4));
		for (int l = 0, r = 0; l <= N / 2 && r <= N/2; l++, r++) {
			// System.out.println("l = "+l +", r = "+r);
			if (c3[l] != c4[r]) {
				cnt2++;
				r--;
			} else {

				sb2.append(c4[r]);
			}
		}

		if (cnt2 <= 1) {
			set.add(sb2.toString());
		}
		// System.out.println(cnt1 + ", "+ cnt2);

		// System.out.println(sb1 +", "+sb2);
		if (cnt1<=1 && cnt2 <= 1 && set.size() == 2) {
			System.out.println("NOT UNIQUE");
		} else if (cnt1 <= 1) {
			System.out.println(sb1);
		} else if (cnt2 <= 1) {
			System.out.println(sb2);
		} else {
			System.out.println("NOT POSSIBLE");
		}



	}

}
