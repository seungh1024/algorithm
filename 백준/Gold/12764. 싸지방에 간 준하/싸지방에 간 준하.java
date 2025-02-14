import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static Data[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		data = new Data[N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			data[i] = new Data(0, from, to);
		}
		data[0] = new Data(0, -1, 0);
		Arrays.sort(data,Comparator.comparingInt(o->o.from));

		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt((Data o) -> o.to));
		int[] count = new int[100001];
		pq.offer(data[1]);
		int idx = 1;
		count[idx] ++;
		data[1].idx = idx;

		idx ++;
		PriorityQueue<Data> empty = new PriorityQueue<>(Comparator.comparingInt(o -> o.idx));
		for (int i = 2; i <= N; i++) {
			Data next = data[i];

			while (!pq.isEmpty()) {
				Data d = pq.poll();
				if (d.to < next.from) {
					empty.offer(d);
				} else {
					pq.offer(d);
					break;
				}
			}

			if (empty.isEmpty()) {
				count[idx]++;
				next.idx = idx++;
				pq.offer(next);
			} else {
				Data last = empty.poll();
				count[last.idx]++;
				pq.offer(new Data(last.idx, last.from, next.to));
			}

		}
		// System.out.println(Arrays.toString(count));

		StringBuilder sb = new StringBuilder();
		sb.append(idx-1).append("\n");
		for (int i = 1; i <= 100000; i++) {
			if(count[i] == 0) continue;
			sb.append(count[i]).append(" ");
		}
		System.out.println(sb);

	}

	public static class Data{
		int idx;
		int from;
		int to;

		public Data(int idx, int from, int to) {
			this.idx = idx;
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Data{" +
				"idx=" + idx +
				", from=" + from +
				", to=" + to +
				'}';
		}
	}
}