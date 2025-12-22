

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			while (!q.isEmpty()) {
				int now = q.poll();
				if (now >= i) {
					q.offerFirst(now);
					break;
				}
			}
			// System.out.println("q = "+q);
			if (q.size() % 2 == 1) {
				data[i] = (data[i] + 1) % 2;
			}
			if (data[i] == 1) {
				// System.out.println("hit");
				if (i + K - 1 < N) {
					q.offer(i + K - 1);
					data[i] = 0;
					cnt++;
				}
			}
			// System.out.println("i = "+i +", "+Arrays.toString(data));
		}

		for (int i = 0; i < N; i++) {
			if (data[i] == 1) {
				System.out.println("Insomnia");
				return;
			}
		}

		System.out.println(cnt);
	}
}
