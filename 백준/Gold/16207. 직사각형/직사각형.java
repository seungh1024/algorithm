

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(st.nextToken());
			pq.offer(num);
		}

		long result = 0;
		while (pq.size() >= 4) {
			long a = pq.poll();
			long b = pq.poll();
			if (a - b>1) {
				pq.offer(b);
			} else {
				long x = Math.min(a, b);
				// System.out.println("a = "+a +", b = "+b);
				
				while (pq.size() >= 2) {
					long c = pq.poll();
					long d = pq.poll();
					if (c - d > 1) {
						pq.offer(d);
					} else {
						// System.out.println("c = "+c +", d = "+d);
						result += x * Math.min(c, d);
						break;
					}
				}
			}
		}
		System.out.println(result);
	}
}
