

import java.io.*;
import java.util.*;

public class Main {
	public static int N,K, T;
	public static int X,Y, V;
	public static List<Data>[] list;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		list = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		Data[] data = new Data[N+1];
		data[0] = new Data(0,X, Y, V);
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			data[i] = new Data(i,x, y, v, p);
		}

		for (int i = 0; i < N; i++) {
			Data from = data[i];
			for (int j = i + 1; j <= N; j++) {
				Data to = data[j];
				int disX = Math.abs(from.x - to.x);
				int disY = Math.abs(from.y - to.y);
				double length = Math.sqrt(disX * disX + disY * disY);
				int dis = (int)length;
				if ((double)(length - dis) > 0) {
					dis++;
				}
				int ver = Math.abs(from.v - to.v);
				if (dis <= K && ver <= T) {
					list[i].add(to);
					list[j].add(from);
				}
			}
		}

		find();
	}

	public static void find(){
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(0,X, Y, V));
		boolean[] visited = new boolean[N + 1];
		visited[0] = true;

		List<Integer> result = new ArrayList<>();
		while (!q.isEmpty()) {
			Data now = q.poll();
			if (now.value == 1) {
				result.add(now.idx);
			}

			for (Data next : list[now.idx]) {
				if (!visited[next.idx]) {
					visited[next.idx] = true;
					q.offer(next);
				}
			}
		}
		if (result.isEmpty()) {
			System.out.println(0);
			return;
		}

		Collections.sort(result);
		StringBuilder sb = new StringBuilder();
		for (int i : result) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);

	}


	public static class Data{
		int idx;
		int x;
		int y;
		int v;
		int value;

		public Data(int idx, int x, int y, int v) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.v = v;
		}

		public Data(int idx, int x, int y, int v, int value) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.v = v;
			this.value = value;
		}
	}
}
