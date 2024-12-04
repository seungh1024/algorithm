package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_1711_직각삼각형 {
	public static int N;
	public static Data[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		data = new Data[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			data[i] = new Data(x, y);
		}

		// System.out.println(Arrays.toString(data));
		int result = 0;
		for (int i = 0; i < N; i++) {
			long x1 = data[i].x;
			long y1 = data[i].y;
			for (int j = i + 1; j < N; j++) {
				long x2 = data[j].x;
				long y2 = data[j].y;
				for (int k = j + 1; k < N; k++) {
					long x3 = data[k].x;
					long y3 = data[k].y;

					long d1 = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
					long d2 = (x2-x3)*(x2-x3) + (y2-y3)*(y2-y3);
					long d3 = (x1-x3)*(x1-x3) + (y1-y3)*(y1-y3);

					if (d1 + d2 == d3 || d2 + d3 == d1 || d1 + d3 == d2) {
						result++;
					}
				}
			}
		}

		System.out.println(result);

	}


	public static class Data {
		int x;
		int y;

		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Data{" +
				"x=" + x +
				", y=" + y +
				'}';
		}
	}
}
