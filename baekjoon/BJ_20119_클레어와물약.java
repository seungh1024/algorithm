package algo_202404;

import java.io.*;
import java.util.*;

public class BJ_20119_클레어와물약 {
	public static int N,M;
	public static Set<Integer>[] list;
	public static int L;
	public static boolean[] check;
	public static List<Data>[] potion;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new HashSet[N+1];
		potion = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new HashSet<>();
			potion[i] = new ArrayList<>();
		}


		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int[] input = new int[k];
			for (int j = 0; j < k; j++) {
				input[j] = Integer.parseInt(st.nextToken());
			}
			int value = Integer.parseInt(st.nextToken());
			Set<Integer> set = new HashSet<>();
			for (int j = 0; j < k; j++) {
				list[input[j]].add(value);
				set.add(input[j]);
			}

			Data data = new Data();
			data.set = set;
			potion[value].add(data);


		}

		L = Integer.parseInt(br.readLine());
		check = new boolean[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++) {
			int target = Integer.parseInt(st.nextToken());
			check[target] = true;
		}


		find();
	}

	public static void find() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 0; i <= N; i++) {
			if (check[i]) {
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : list[now]) {
				for (Data data : potion[next]) {
					if (data.set.contains(now)) {
						data.set.remove(now);
						if (data.set.isEmpty()) {
							check[next] = true;
							q.offer(next);
						}
					}
				}
			}
		}

		int result = 0;
		StringBuilder sb = new StringBuilder();
		List<Integer> array = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (check[i]) {
				array.add(i);
				result++;
			}
		}
		sb.append(result).append("\n");
		for (int i : array) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	public static class Data {
		Set<Integer> set;
	}

}
