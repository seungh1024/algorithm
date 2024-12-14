package algo_202412;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BJ_21944_문제추천시스템version2 {
	public static int N, M;
	public static Data[] data;
	public static TreeSet<Data> set;
	public static TreeSet<Data>[] subTree;

	public static Comparator<Data> com() {
		return Comparator.comparing((Data d) -> d.l).thenComparing((Data d) -> d.p);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new Data[100001];
		set = new TreeSet<>(com());
		subTree = new TreeSet[101];
		for (int i = 1; i <= 100; i++) {
			subTree[i] = new TreeSet<>(com());
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			Data d = new Data(p, l, g);
			data[p] = d;
			set.add(d);
			subTree[g].add(d);
		}

		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("recommend")) {
				int g = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					Data last = subTree[g].last();
					sb.append(last.p);
				} else {
					Data first = subTree[g].first();
					sb.append(first.p);
				}
				sb.append("\n");
			} else if (command.equals("recommend2")) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					Data last = set.last();
					sb.append(last.p);
				} else {
					Data first = set.first();
					sb.append(first.p);
				}
				sb.append("\n");
			} else if (command.equals("recommend3")) {
				int x = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				Data d = new Data(0, l, 0);
				if (x == 1) {
					if (set.ceiling(d) == null) {
						sb.append(-1);
					} else {
						sb.append(set.ceiling(d).p);
					}
				} else {
					if (set.lower(d) == null) {
						sb.append(-1);
					} else {
						sb.append(set.lower(d).p);
					}
				}
				sb.append("\n");
			} else if (command.equals("add")) {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				int g = Integer.parseInt(st.nextToken());
				Data d = new Data(p, l, g);
				data[p] = d;
				set.add(d);
				subTree[g].add(d);
			} else if (command.equals("solved")) {
				int p = Integer.parseInt(st.nextToken());

				if (data[p] != null) {
					Data d = data[p];
					set.remove(d);
					subTree[d.g].remove(d);
					data[p] = null;
				}
			}
		}
		System.out.println(sb);
	}

	public static class Data {
		// int id;
		int p;
		int l;
		int g;

		public Data( int p, int l, int g) {
			this.p = p;
			this.l = l;
			this.g = g;
		}

		@Override
		public String toString() {
			return "Data{" +
				", p=" + p +
				", l=" + l +
				", g=" + g +
				'}';
		}
	}
}
