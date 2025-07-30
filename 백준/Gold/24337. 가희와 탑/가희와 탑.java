

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;

		List<Integer> left = new ArrayList<>();
		List<Integer> right = new ArrayList<>();

		int num = 1;
		int max = 0;
		for (int i = 0; i < a; i++) {
			left.add(num++);
		}
		max = num;
		num = 1;
		for (int i = 0; i < b; i++) {
			right.add(num++);
		}
		max = Math.max(max, num);
		int range = N - 1 - left.size() - right.size();

		if (a >0) {

			for (int i = 0; i < range; i++) {
				left.add(1);
			}
		}
		range = N - 1 - left.size() - right.size();

		List<Integer> spare = new ArrayList<>();
		for (int i = 0; i < range; i++) {
			spare.add(1);
		}
		if (left.size() + right.size() + spare.size() + 1 != N) {
			System.out.println(-1);
			return;
		}
		Collections.sort(left);
		StringBuilder sb = new StringBuilder();
		for (int i : left) {
			sb.append(i).append(" ");
		}
		sb.append(max).append(" ");
		Collections.sort(right, Comparator.reverseOrder());
		for (int i : spare) {
			sb.append(i).append(" ");
		}
		for (int i : right) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}
}
