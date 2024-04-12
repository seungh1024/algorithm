package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_1082_방번호 {
	public static int N,M;
	public static Data[] data;
	public static int result;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new Data[N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int value = Integer.parseInt(st.nextToken());
			data[i] = new Data(value,i);
		}
		Arrays.sort(data);
		M = Integer.parseInt(br.readLine());

		Queue<Data> q = new ArrayDeque<>();

		if (data[0].index == 0 && 1<N && M - data[1].cost >= 0){
			q.offer(data[1]);
			M -= data[1].cost;
		}
		if (data[0].index == 0 && q.isEmpty()) {
			q.offer(data[0]);
			M -= data[0].cost;
		}else{
			while (M - data[0].cost >= 0) {
				M -= data[0].cost;
				q.offer(data[0]);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			Data now = q.poll();
			boolean flag = true;
			int minus = 0;
			int index = now.index;
			for (int i = N - 1; i >= 0; i--) {
				Data target = data[i];
				int value = target.cost - now.cost;
				if (value <= M && target.index > index) {
					index = target.index;
					minus =value;
					flag = false;
					// break;
				}
			}
			if (flag) {
				sb.append(now.index);
			} else {
				sb.append(index);
				M-=minus;
			}
		}

		if (sb.length() == 0) {
			System.out.println(data[0].index);
			return;
		}


		System.out.println(sb);


	}

	public static class Data implements Comparable<Data> {
		int cost;
		int index;

		public Data(int cost, int index) {
			this.cost = cost;
			this.index = index;
		}

		@Override
		public int compareTo(Data data) {
			if (this.cost == data.cost) {
				return data.index - this.index;
			}
			return this.cost - data.cost;
		}

		@Override
		public String toString() {
			return "cost = " +cost + ", index = "+index;
		}
	}

}
