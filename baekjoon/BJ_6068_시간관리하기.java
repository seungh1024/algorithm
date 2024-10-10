package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_6068_시간관리하기 {
	public static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparing(d -> d.S));
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			pq.offer(new Data(T, S));
		}


		int time = 0;
		int result = Integer.MAX_VALUE;
		while (!pq.isEmpty()) {
			Data now = pq.poll();
			time += now.T;
			if (time > now.S) {
				result = -1;
				break;
			}

			result = Math.min(result, now.S-time);
		}

		System.out.println(result);
	}

	public static class Data{
		int T;
		int S;

		public Data(int T, int S){
			this.T = T;
			this.S = S;
		}
	}
}
