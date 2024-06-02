package vsfe_20240531;

import java.io.*;
import java.util.*;

public class BJ_31792_한빛미디어hard {
	public static int Q;
	public static TreeMap<Integer,Integer> map;
	public static List<Integer> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Q = Integer.parseInt(br.readLine());
		map = new TreeMap<>();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		for (int t = 0; t < Q; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());
			if (command == 1) {
				int price = Integer.parseInt(st.nextToken());
				Integer value = map.get(price);
				if (value == null) {
					map.put(price, 1);
				} else {
					map.put(price,value+1);
				}

			} else if (command == 2) {
				int target = Integer.parseInt(st.nextToken());
				Integer value = map.get(target);
				if (value != null) {
					value--;
					if (value == 0) {
						map.remove(target);
					} else {
						map.put(target,value);
					}
				}
			} else { // 3
				if (map.isEmpty()) {
					// System.out.println("empty");
					sb.append(0).append("\n");
					continue;
				}
				Integer key = map.firstKey();
				// System.out.println(map);
				// System.out.println("key = "+key);
				int count = 1;
				while (key != null) {
					Map.Entry<Integer, Integer> entry = map.ceilingEntry(key*2);
					// System.out.println(entry);
					if (entry == null) {
						break;
					}
					key = entry.getKey();
					count++;
				}
				sb.append(count).append("\n");
			}
		}
		System.out.println(sb);
	}
}
