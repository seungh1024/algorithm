package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_12761_돌다리 {
	public static int A,B,N,M;
	public static int SIZE = 100_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		boolean[] check = new boolean[SIZE + 1];
		int[] dx = {1,-1,-A,-B,A,B};

		Queue<Integer> q = new ArrayDeque<>();
		q.offer(N);

		int count = 0;
		boolean flag = false;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int s = 0; s < size; s++) {
				int index = q.poll();
				// System.out.println(index);
				if (index == M) {
					flag = true;
					break;
				}
				check[index] = true;

				for (int d = 0; d < 6; d++) {
					int ni = index+dx[d];
					if (ni >= 0 && ni <= SIZE && !check[ni]) {
						check[ni] = true;
						q.offer(ni);
					}
				}
				for (int d = 4; d < 6; d++) {
					int ni = index*dx[d];
					if (ni >= 0 && ni <= SIZE && !check[ni]) {
						check[ni] = true;
						q.offer(ni);
					}
				}
			}
			if (flag) {
				break;
			}

			count++;
			// System.out.println("count = "+count);
		}

		System.out.println(count);

	}
}
