

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			pq.offer(new int[]{from, to});
		}

		int point = 0;
		int cnt = 0;

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (now[0] > point) {
				point = now[0];
			}

			int range = now[1]-point;
			int plus = (range + L - 1) / L;
			cnt += plus;
			point += (plus * L);
		}
		System.out.println(cnt);
	}
}
