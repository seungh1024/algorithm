package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_1374_강의실 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Data[] data = new Data[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			data[i] = new Data(start, end);
		}
		Arrays.sort(data, Comparator.comparing((Data d) -> d.start));

		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparing((Data d) -> d.end));
		pq.offer(data[0]);

		for (int i = 1; i < N; i++) {
			Data now = pq.poll();
			if (now.end <= data[i].start) {
				pq.offer(new Data(now.start, data[i].end));
			} else {
				pq.offer(now);
				pq.offer(data[i]);
			}
		}

		System.out.println(pq.size());
		// System.out.println(pq);

	}

	public static class Data{
		int start;
		int end;

		public Data(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public String toString() {
			return "start = "+start +", end = "+end;
		}
	}
}
