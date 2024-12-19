package algo_202412;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_18513_샘터 {
	public static int N, K;
	public static Set<Integer> water;
	public static List<Integer> list;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		water = new HashSet<>();

		Queue<Integer> q = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		Set<Integer> visited = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			water.add(idx);
			visited.add(idx);
			q.offer(idx);
		}

		list = water.stream().collect(Collectors.toList());

		long result = 0;
		int count = 0;
		int[] dx = {1, -1};
		long length = 0;
		boolean flag = false;
		while(!q.isEmpty() && !flag){
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int now = q.poll();

				if (!water.contains(now)) {
					result += length;
					count++;
				}

				if (count == K) {
					flag = true;
					break;
				}

				for (int d = 0; d < 2; d++) {
					int next = now + dx[d];
					if (!visited.contains(next)) {
						q.offer(next);
						visited.add(next);
					}
				}
			}
			length++;

		}
		System.out.println(result);
	}

	public static int binarySearch(int num) {
		int start = 0;
		int end = list.size()-1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (list.get(mid) >= num) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		int result = Integer.MAX_VALUE;
		if (start > 0) {
			result = Math.min(result, Math.abs(list.get(start - 1) - num));
		}
		result = Math.min(result, Math.abs(list.get(start) - num));

		return result;
	}
}
