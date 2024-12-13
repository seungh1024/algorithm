package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_1313_합성소수 {
	public static List<Integer> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


		boolean[] visited = new boolean[10000001];
		int range = (int)Math.sqrt(10000000);
		for (int v = 2; v <= range; v++) {
			if(visited[v]) continue;
			for (int i = 2; i*v <= 10000000; i ++) {
				visited[i*v] = true;
			}
		}
		visited[0] = true;
		visited[1] = true;

		list = new ArrayList<>();
		for (int v = 100; v <= 10000000; v++) {
			if(!visited[v]) continue;

			String s = v+"";
			int size = s.length();
			boolean flag = false;
			for (int i = 2; i < size; i++) {
				for (int j = 0; j + i <= size; j++) {
					StringBuilder sb = new StringBuilder();
					for (int k = j; k < i + j; k++) {
						sb.append(s.charAt(k));
					}
					int num = Integer.parseInt(sb.toString());
					if (visited[num]) {
						flag= true;
						break;
					}
				}
				if (flag) {
					break;
				}
			}

			if(flag) continue;

			list.add(v);
		}
		// System.out.println(list);


		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			int value = find(num);
			sb.append(value).append("\n");
		}
		System.out.println(sb);
	}

	public static int find(int num) {
		// System.out.println("Num = "+num);
		int start = 0;
		int end = list.size()-1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (list.get(mid) >= num) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		// System.out.println(list.get(start));
		int value = list.get(start);
		if (value > num && start - 1 >= 0) {
			value = list.get(start-1);
		}

		if (value > num) {
			return -1;
		} else {
			return value;
		}
	}
}
