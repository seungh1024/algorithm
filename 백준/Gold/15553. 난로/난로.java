

import java.io.*;
import java.util.*;

public class Main {
	public static int N, K;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		data = new int[N];

		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		int last = data[0]+1;
		for (int i =1; i < N; i++) {
			pq.offer(data[i] - last);
			last = data[i] + 1;
		}


		// System.out.println(pq);

		long sum = N;
		for (int i = 0; i < N - K; i++) {
			sum += pq.poll();
		}

		// while (!pq.isEmpty()) {
		// 	sum += pq.poll();
		// 	System.out.println(sum);
		// }
		System.out.println(sum);
	}


}
