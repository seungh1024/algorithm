

import java.io.*;
import java.util.*;

public class Main {

	public static Stack<Integer> stack;
	public static List<String> list;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		list = new ArrayList<>();
		stack = new Stack<>();
		find(1, N, new ArrayList<>());
		// Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for (int i = list.size()-1; i >= 0; i--) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}

	public static void find(int num, int N, List<Integer> out) {
		if (out.size() == N) {
			StringBuilder sb = new StringBuilder();
			for (int i : out) {
				sb.append(i).append(" ");
			}
			list.add(sb.toString());
			return;
		}

		if (num <= N) {
			stack.push(num);
			find(num+1, N, out);
			stack.pop();
		}

		// pop
		if (!stack.isEmpty()) {
			int x = stack.pop();
			out.add(x);
			find(num, N, out);
			out.remove(out.size()-1);
			stack.push(x);
		}


	}
}
