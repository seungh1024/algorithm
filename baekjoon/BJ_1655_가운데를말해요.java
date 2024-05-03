package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_1655_가운데를말해요 {
	public static int N;
	public static List<Integer> list;
	public static int size;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>(N);
		size = 0;

		StringBuilder sb = new StringBuilder();
		Queue<Integer> left = new PriorityQueue<>((o1,o2)->{
			return o2-o1;
		});
		Queue<Integer> right = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			right.offer(input);

			while (true) {
				if (!right.isEmpty() && left.size() < right.size()) {
					left.offer(right.poll());
				} else {
					break;
				}
			}

			while (!left.isEmpty() && !right.isEmpty()) {
				int l = left.poll();
				int r = right.poll();
				if (l > r) {
					left.offer(r);
					right.offer(l);
				} else {
					left.offer(l);
					right.offer(r);
					break;
				}
			}
			sb.append(left.peek()).append("\n");
		}
		System.out.println(sb);
	}

}
