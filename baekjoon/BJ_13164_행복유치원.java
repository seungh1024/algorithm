package algo_202401;

import java.io.*;
import java.util.*;

public class BJ_13164_행복유치원 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> pq = new PriorityQueue<>((o1,o2)->{
			return o2-o1;
		});
		st = new StringTokenizer(br.readLine());
		int last = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			int next = Integer.parseInt(st.nextToken());
			pq.offer(next-last);
			last = next;
		}

		for (int i = 1; i < K; i++) {
			pq.poll();
		}
		int result = 0;
		while (!pq.isEmpty()) {
			result += pq.poll();
		}
		System.out.println(result);
	}
}
