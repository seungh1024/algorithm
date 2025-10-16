

import java.io.*;
import java.util.*;

public class Main {
	public static int K;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		int range = 1000000;
		int[] count = new int[range+1];
		Arrays.fill(count, Integer.MAX_VALUE);
		Set<Integer>[] set = new HashSet[9];
		for (int i = 1; i <= 8; i++) {
			set[i] = new HashSet<>();
		}
		int temp = K;
		for (int i = 1; i <= 8; i++) {
			if (temp <= range) {
				count[temp] = i;
			}
			set[i].add(temp);
			temp*=10;
			temp+=K;
		}

		for (int s = 2; s <= 8; s++) {
			for (int k = 1; k < s; k++) {
				for (int i : set[k]) {
					for (int j : set[s - k]) {
						if (i * j <= range && count[i*j] == Integer.MAX_VALUE) {

							set[s].add(i * j);
							count[i * j] = Math.min(count[i * j], s);

						}
						if (i + j <= range && count[i+j] == Integer.MAX_VALUE) {
							set[s].add(i + j);
							count[i+j] = Math.min(count[i+j],s);
						}
						if (i - j >= 0 && i-j<=range && count[i-j] == Integer.MAX_VALUE) {

							set[s].add(i - j);
							count[i - j] = Math.min(count[i - j], s);

						}

						if (j > 0  && i/j<=range&&  count[i / j] == Integer.MAX_VALUE) {

							set[s].add(i / j);
							count[i / j] = Math.min(count[i / j], s);
						}
					}
				}
			}
		}





		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(br.readLine());
			int v = count[idx];
			if (v <= 8) {
				sb.append(v);
			} else {
				sb.append("NO");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
