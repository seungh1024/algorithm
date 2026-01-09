

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] data = new int[N+1];
		long[] minSum = new long[N + 1];
		long[] maxSum = new long[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);
		for (int i = 1; i <= N; i++) {
			minSum[i] += minSum[i - 1] + data[i];
		}
		for (int i = N; i > 0; i--) {
			maxSum[N - i + 1] = maxSum[N - i] + data[i];
		}
		// System.out.println(Arrays.toString(minSum));
		// System.out.println(Arrays.toString(maxSum));

		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.x));
		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>(); // 토큰화된 좌표 리스트. 승하차 지점이라고 생각
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken())+1;
			pq.offer(new Data(from, 1));
			pq.offer(new Data(to, -1));
			if (!set.contains(from)) {
				set.add(from);
				list.add(from);
			}
			if (!set.contains(to)) {
				set.add(to);
				list.add(to);
			}
		}

		Collections.sort(list);

		long max = 0;
		long min = 0;

		int cnt = 0; // 이용중인 사용자 수 -> sum의 idx가 된다.
		int range= list.size()-1;
		// 승하차지점을 앞에서부터 탐색 -> 기준점이 됨.
		for (int i = 0; i < range; i++) {
			int x = list.get(i);// 현재 승하차가 되는 기준점
			while (!pq.isEmpty()) {
				Data now = pq.peek();
				if(now.x > x) break; // 현재 지점 기준에서 승하차 하는지만 본다.
				now = pq.poll();
				cnt += now.cost; // 승차 ->1, 하차 -> -1로 계산되어 카운팅 됨
			}

			int nx = list.get(i+1);
			long dis = nx-x;
			long plusMax =dis*maxSum[cnt];
			long plusMin = dis*minSum[cnt];
			// System.out.println("x = "+x + ", nx = "+nx + ", dis = "+dis + ", plusMax = "+plusMax +", plusMin = "+plusMin);
			max += plusMax;
			min += plusMin;


		}

		System.out.println(min +" "+max);

	}

	public static class Data{
		int x;
		int cost;

		@Override
		public String toString() {
			return "Data{" +
				"x=" + x +
				", cost=" + cost +
				'}';
		}

		public Data(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}
	}
}
