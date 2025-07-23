

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static List<char[]> list;
	public static char[] al = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
	public static int[] arr;
	public static boolean[] visited;
	public static long result = 0;
	public static Set<Character> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		set = new HashSet<>();
		long[] count = new long[10];
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			long temp = 1;
			for (int j = input.length - 1; j >= 0; j--) {
				int idx = input[j]-'A';
				count[idx] += temp;
				temp*=10;
			}
			set.add(input[0]);
		}

		// System.out.println(Arrays.toString(count));
		PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[1]));

		for (int i = 0; i < 10; i++) {
			pq.offer(new long[] {i, count[i]});
		}

		long result = 0;
		long num = 0;

		Queue<long[]> q = new ArrayDeque<>();
		while (!pq.isEmpty()) {
			long[] now = pq.poll();

			char c = al[(int)now[0]];
			if (set.contains(c)) {
				q.offer(now);
			} else {
				result += now[1]*num;
				num++;
				break;
			}
		}

		while (!q.isEmpty()) {
			pq.offer(q.poll());
		}
		while (!pq.isEmpty()) {
			long[] now = pq.poll();
			result += now[1]*num;
			num++;
		}

		System.out.println(result);
	}

}
