

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int now = 1;
		boolean check = false;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			if (x == 1) {
				int n = Integer.parseInt(st.nextToken());
				String s = st.nextToken();

				if (s.equals("R")) {
					if (now >= n) {
						check = true;
						break;
					}
				} else {
					if (n == M) {
						check = true;
						break;
					}
					now = Math.max(now, n + 1);
				}
			} else if(x == 2) {
				int n1 = Integer.parseInt(st.nextToken());
				String c1 = st.nextToken();
				int n2 = Integer.parseInt(st.nextToken());
				String c2 = st.nextToken();
				if (c1.equals("R")) {
					if (c2.equals("R")) { // c1 = r, c2 = r
						int n = Math.min(n1, n2);
						if (now >= n) {
							check = true;
							break;
						}
					} else { // c1 = r, c2 = l
						if (n1 < n2) {
							if (now >= n1 && now <= n2) {
								if (n2 + 1 > M) {
									check = true;
									break;
								}
								now = Math.max(now, n2 + 1);
							}
						} else {
							if (now >= n1 || n1 - n2 == 1) {
								check = true;
								break;
							}
							now = Math.max(now, n2 + 1);

						}
					}
				} else {
					if (c2.equals("R")) { // c1 = l, c2 = r
						if (n1 <= n2) {
							if (now >= n2 || n2-n1 == 1) {
								check = true;
								break;
							}
							now = Math.max(now, n1 + 1);
						} else {
							if (now >= n2 && now <= n1) {
								if (n1 + 1 > M) {
									check = true;
									break;
								}
								now = Math.max(now,n1 + 1);
							}
						}
					} else { // c1 = l , c2 = l
						int n = Math.max(n1, n2);
						if (n == M) {
							check = true;
							break;
						}
						now = Math.max(now, n + 1);
					}
				}
			}



		}
		if (check) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}

	}
}
