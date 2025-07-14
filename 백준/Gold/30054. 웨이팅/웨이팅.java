

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Data> pq = new PriorityQueue<>(
			Comparator.comparingInt((Data o) -> o.t2).thenComparingInt(o -> o.t1));

		Data[] data = new Data[200001];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t1 = Integer.parseInt(st.nextToken());
			int t2 = Integer.parseInt(st.nextToken());
			Data d = new Data(t1, t2);
			pq.offer(d);
			data[t1] = d; //t1은 서로 다르니까 가능함
		}

		Queue<Data> q = new ArrayDeque<>();
		int max = 0;
		int time = 1;
		for (int i = 0; i < N; i++) {
			Data now = pq.poll();

			// System.out.println("time = "+time +", i = "+i);

			if (now.t2 == time) {
				now.isWaiting = true;
				q.offer(now);
			} else if (now.t2 > time) {
				if (data[time] != null && data[time].isWaiting) { // 이미 대기 중인 상태
					max = Math.max(max, time - data[time].t2);
					data[time].isWaiting = false;
					// System.out.println("in = "+ data[time]);
				} else {
					while (!q.isEmpty()) {
						Data d = q.poll();

						if (d.isWaiting) {
							max = Math.max(max, time - d.t2);
							d.isWaiting = false;
							// System.out.println("in = "+d);
							break;
						}
					}
				}
				time++;
				pq.offer(now);
				i--;
			}
		}


		while (!q.isEmpty()) {
			if (time <= 200000 && data[time] != null && data[time].isWaiting) {
				max = Math.max(max, time - data[time].t2);
				data[time].isWaiting = false;
				// System.out.println("in = "+data[time]);
			} else {
				while (!q.isEmpty()) {

					Data now = q.poll();
					if (now.isWaiting) {
						// System.out.println("in = "+now);
						max = Math.max(max, time - now.t2);
						now.isWaiting = false;
						break;
					}
				}
			}
			time++;
		}
		System.out.println(max);

	}


	public static class Data{
		int t1;
		int t2;
		boolean isWaiting;

		public Data(int t1, int t2) {
			this.t1 = t1;
			this.t2 = t2;
		}

		@Override
		public String toString() {
			return "Data{" +
				"t1=" + t1 +
				", t2=" + t2 +
				'}';
		}
	}
}

// 11 2  -> 2
// 3 3  -> 3
// 7 3  -> 4
// 2 4  -> 5
// 6 6 -> 6