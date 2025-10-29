

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			long v = Long.parseLong(br.readLine());
			pq.offer(v);
		}

		long result = 0;

		while (pq.size() >= 2) {
			long a = pq.poll();
			long b = pq.poll();
			if (a <= 0 && b <= 0) {
				result += a * b;
			} else {
				pq.offer(a);
				pq.offer(b);
				break;
			}
		}

		PriorityQueue<Long> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		while (!pq.isEmpty()) {

			maxHeap.offer(pq.poll());
		}

		while (maxHeap.size() >= 2) {
			long a = maxHeap.poll();
			long b = maxHeap.poll();

			if (a > 1 && b > 1) {
				result += a * b;
			} else {
				result+=a;
				result+=b;
				break;
			}
		}
		while (!maxHeap.isEmpty()) {
			result += maxHeap.poll();
		}

		System.out.println(result);
	}
}
