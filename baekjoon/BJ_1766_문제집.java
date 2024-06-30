package algo_202406;


import java.io.*;
import java.util.*;

public class BJ_1766_문제집 {
	public static int N, M;
	public static int[] check;
	public static List<Integer>[] list;
	public static Map<Integer,Integer> parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		check = new int[N+1];

		list = new ArrayList[N+1];
		parent = new HashMap();
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			list[first].add(next); // 선행되어야 하는 자식들 추가
			//            parent.put(first,next); // 부모 추가
			check[next]++;
		}

		find();
	}

	public static void find() {
		Queue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (check[i] == 0) {
				pq.offer(i);
			}
		}

		StringBuffer sb = new StringBuffer();
		//        System.out.println(Arrays.toString(check));
		//        int range = 10;
		Queue<Integer> retry = new ArrayDeque<>();

		while (!pq.isEmpty()) {
			int size = pq.size();
			for (int s = 0; s < size; s++) {

				int now = pq.poll();
				//                System.out.println("now = "+now);

				sb.append(now).append(" ");

				for (int next : list[now]) {
					check[next]--;
					if (check[next] == 0) {
						pq.offer(next);
					}
				}
			}

			while (!retry.isEmpty()) {
				pq.offer(retry.poll());
			}
		}
		System.out.println(sb);
	}

	// 5 3
	// 4 2
	// 3 1
	// 5 1

	public static class Data implements Comparable<Data>{
		int value; // value
		int count; // 자식 수

		public Data(int value, int count) {
			this.value = value;
			this.count = count;
		}

		@Override
		public int compareTo(Data d){
			if (this.count == d.count) {
				return this.value - d.value;
			}
			return this.count - d.count;
		}
	}
}


