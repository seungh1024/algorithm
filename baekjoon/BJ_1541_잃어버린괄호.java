package algo_202409;

import java.io.*;
import java.util.*;

public class BJ_1541_잃어버린괄호 {
	public static List<Integer> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		list = new ArrayList<>();
		int sum = 0;
		for (char c : input) {
			if (c == '+' || c == '-') {
				sum += Integer.parseInt(sb.toString());
				// System.out.println(sum);
				if (c == '-') {
					list.add(sum);
					sum = 0;
				}
				sb = new StringBuilder();
			} else {
				sb.append(c);
			}
		}
		list.add(sum + Integer.parseInt(sb.toString()));
		// System.out.println(list);

		int result = list.get(0);
		for(int i = 1; i < list.size(); i++) {
			result -= list.get(i);
		}
		System.out.println(result);
	}


}
