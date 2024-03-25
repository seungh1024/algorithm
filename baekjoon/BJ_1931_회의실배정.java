package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_1931_회의실배정 {
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Data[] data = new Data[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			data[i] = new Data(start,end);
		}
		Arrays.sort(data);


		int last = 0;
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (data[i].start >= last) {
				// System.out.println(data[i].end);
				count++;
				last = data[i].end;
			}
		}


		System.out.println(count);
	}

	public static class Data implements Comparable<Data> {
		int start;
		int end;

		public Data(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Data data) {
			if (this.end == data.end) {
				return this.start - data.start;
			}
			return this.end - data.end;
		}
	}
}
