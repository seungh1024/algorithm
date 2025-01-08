package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_16434_드래곤앤던전 {
	public static int N, A;
	public static List<Data> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());

		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long t = Long.parseLong(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			long h = Long.parseLong(st.nextToken());
			list.add(new Data(t, a, h));
		}

		find();


	}

	public static void find() {
		long start = 0;
		long end = Long.MAX_VALUE;

		while (start < end) {
			long mid = (start+end)/2;

			if (check(mid)) {
				end = mid;
			} else {
				start = mid+1;
			}

		}

		System.out.println(start);
	}

	public static boolean check(long maxHp) {
		long atk = A;
		long hp = maxHp;

		for (Data d : list) {
			long t = d.t;
			long a = d.a;
			long h = d.h;

			if (t == 1) {
				h -= atk;
				if (h > 0) {
					long cnt = (h + atk - 1) / atk;
					long minus = cnt * a;
					hp -= minus;
				}
			} else {
				atk += a;
				hp += h;
				if (hp > maxHp) {
					hp = maxHp;
				}
			}

			if (hp <= 0) {
				return false;
			}
		}

		return true;
	}

	public static class Data{
		long t;
		long a;
		long h;

		public Data(long t, long a, long h) {
			this.t = t;
			this.a = a;
			this.h = h;
		}
	}


}
