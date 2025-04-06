

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong((long[] o) -> o[0]).thenComparingLong(o->o[2]));
		for (int i = 0; i < K; i++) {
			pq.offer(new long[] {0, 0,i});
		}

		List<long[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long id = Long.parseLong(st.nextToken());
			long w = Long.parseLong(st.nextToken());

			long[] data = pq.poll();
			// System.out.println(Arrays.toString(data));
			if (data[1] != 0) {
				list.add(new long[]{data[0],data[1],data[2]});
			}
			data[0] += w;
			data[1] = id;
			pq.offer(data);
		}

		while (!pq.isEmpty()) {
			long[] data = pq.poll();
			if (data[1] != 0) {
				list.add(new long[] {data[0], data[1],data[2]});
			}
		}

		list.sort(Comparator.comparingLong((long[] o) -> o[0]).thenComparingLong(o -> -o[2]));

		// System.out.println("sort");
		// for (long[] l : list) {
		// 	System.out.println(Arrays.toString(l));
		// }

		long result = 0;
		for (int i = 1; i <= N; i++) {
			result += list.get(i-1)[1]*i;
		}
		System.out.println(result);
	}
}
