

import java.io.*;
import java.util.*;

public class Main {
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int total = 0;
		List<Data> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			total += p;
			list.add(new Data(x, y, p));
		}

		Collections.sort(list, Comparator.comparingInt(o -> o.x));
		int x = 0;
		int mid = 0;
		if (total % 2 == 0) {
			mid = total/2-1;
		} else {
			mid = (total+1)/2-1;
		}
		// System.out.println("mid = "+mid);
		int cnt = 0;
		for (Data d : list) {
			cnt += d.p;
			if (cnt > mid) {
				x = d.x;
				break;
			}
		}

		Collections.sort(list, Comparator.comparingInt(o -> o.y));
		int y = 0;
		cnt = 0;
		for (Data d : list) {
			cnt += d.p;
			if (cnt > mid) {
				y = d.y;
				break;
			}
		}

		System.out.println(x + " "+y);

	}


	public static class Data{
		int x;
		int y;
		int p;

		public Data(int x, int y, int p) {
			this.x = x;
			this.y = y;
			this.p = p;
		}
	}
}
