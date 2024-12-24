package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_7490_0만들기 {
	public static int N;
	public static List<String> list;
	public static StringBuilder result;
	public static String[] data;
	public static Map<Integer, String> map = Map.of(1, "1", 2, "2", 3, "3", 4, "4", 5, "5", 6, "6", 7, "7", 8, "8", 9,
		"9");
	public static String[] operator = {"+", "-"};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		result = new StringBuilder();
		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			data = new String[N*2];
			data[0] = "1";
			find(2, 1);
			Collections.sort(list);

			for (String s : list) {
				result.append(s).append("\n");
			}
			result.append("\n");
		}
		System.out.println(result);
	}

	public static void find(int num, int idx) {
		if (num > N) {
			Stack<String> stack = new Stack<>();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < idx; i++) {
				if (data[i].equals("j")) {
					String last = stack.pop();
					stack.push(last + data[i + 1]);
					sb.append(" ").append(data[i + 1]);
					i++;
					continue;
				}
				stack.push(data[i]);
				sb.append(data[i]);
			}

			// System.out.println(stack);

			int i = 0;
			int sum = 0;
			String operator = null;
			for (String s : stack) {
				if (i % 2 == 0) {
					if (operator == null) {
						sum += Integer.parseInt(s);
					} else if (operator.equals("+")) {
						sum += Integer.parseInt(s);
					} else if (operator.equals("-")) {
						sum -= Integer.parseInt(s);
					}
				} else {
					operator = s;
				}
				i++;
			}

			if (sum == 0) {
				list.add(sb.toString());
			}

			return;
		}

		data[idx] = operator[0];
		data[idx + 1] = map.get(num);
		find(num + 1, idx+2);
		data[idx] = operator[1];
		data[idx + 1] = map.get(num);
		find(num + 1, idx+2);

		data[idx] = "j";
		data[idx+1] = map.get(num);
		find(num + 1, idx+2);

	}
}
