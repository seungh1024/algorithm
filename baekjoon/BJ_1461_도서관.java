package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_1461_도서관 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());

		}
		Arrays.sort(data);
		// System.out.println(Arrays.toString(data));

		Queue<Integer> pq = new PriorityQueue<>();
		int size = 0;
		int result = 0;
		for (int i = 0; i < N; i+=M) {
			if (data[i] >= 0) {
				break;
			}
			pq.offer(Math.abs(data[i])*2);
			size++;
		}
		int right = 0;
		for (int i = N - 1; i >= 0; i -= M) {
			if (data[i] <= 0) {
				break;
			}
			pq.offer(Math.abs(data[i])*2);
			size++;
		}

		for (int i = 1; i < size; i++) {
			result += pq.poll();
		}
		result += pq.poll()/2;

		System.out.println(result);
	}
}
