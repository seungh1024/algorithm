package algo_202406;

import java.io.*;
import java.util.*;


public class BJ_5639_이진검색트리 {
	public static List<Integer> list;
	public static Queue<Integer> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();

		while (true) {
			String input = br.readLine();
			// System.out.println("inpput = "+input);
			if (Objects.isNull(input) || Objects.equals(input, "")) {
				break;
			}
			list.add(Integer.parseInt(input));
			// System.out.println(list);
		}

		int root = 0;
		q = new ArrayDeque<>();
		find(0, list.size()-1);

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			sb.append(q.poll()).append("\n");
		}
		System.out.println(sb);
	}

	public static void find(int left, int right) {
		// System.out.println("left = "+ left + ", right = "+right);
		if (left == right) {
			q.offer(list.get(left));
			return;
		}

		int index = 0;
		for (int i = left; i <= right; i++) {
			if (list.get(i) > list.get(left)) {
				index = i;
				break;
			}
		}

		if (index != 0) {
			if (left + 1 <= index - 1) {
				find(left + 1, index - 1);
			}
			find(index, right);
		} else {
			find(left+1,right);
		}
		q.offer(list.get(left));

	}

}
