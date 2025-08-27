

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int now = 1;

		String result = "YES";
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());

			if (v == 1) {
				int a = Integer.parseInt(st.nextToken());
				char c = st.nextToken().charAt(0);
				if (c == 'R') {
					if (now >= a) {
						result = "NO";
						break;
					}
					// now = Math.min(now, c - 1);
				} else {
					now = Math.max(now, a + 1);
				}
			} else if (v == 2) {
				int a = Integer.parseInt(st.nextToken());
				char b = st.nextToken().charAt(0);
				int c = Integer.parseInt(st.nextToken());
				char d = st.nextToken().charAt(0);

				if (b == 'R' && d == 'L') {
					if (a < c) {
						if (now >= a) {
							now = Math.max(now, c + 1);
						}
					} else {

						now = Math.max(now, c + 1);

						if (now >= a) {
							result = "NO";
							break;
						}
					}
				} else if (b == 'R' && d == 'R') {
					int min = Math.min(a, c);
					if (now >= min) {
						result = "NO";
						break;
					}
				} else if (b == 'L' && d == 'L') {
					int max = Math.max(a, c);
					now = Math.max(now, max + 1);
				} else if (b == 'L' && d == 'R') {
					if (a < c) {

						now = Math.max(now, a + 1);
						if (now >= c) {
							result = "NO";
							break;
						}
					} else {
						if (now >= c) {
							now = Math.max(now, a + 1);
						}
					}
				}
			}

			if (now > M) {
				result = "NO";
				break;
			}
		}
		System.out.println(result);
	}
}
