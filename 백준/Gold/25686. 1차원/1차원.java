

import java.io.*;
import java.util.*;

public class Main {
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			list.add(i);
		}

		find(list);
		if (list.size() == 0) {
			System.out.println(-1);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for (int i : list) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	public static void find(List<Integer> list) {
		if (list.size() <= 2) {
			return;
		}

		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (i % 2 == 0) {
				left.add(list.get(i));
			} else {
				right.add(list.get(i));
			}
		}

		find(left);
		find(right);

		list.clear();
		for(int i : left){
			list.add(i);
		}
		for (int i : right) {
			list.add(i);
		}
	}
}
