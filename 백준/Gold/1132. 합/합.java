

import java.io.*;
import java.util.*;

public class Main {
	public static int N;
	public static List<char[]> list;
	public static char[] al = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
	public static int[] arr;
	public static boolean[] visited;
	public static long result = 0;
	public static Set<Character> set;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			list.add(input);

			set.add(input[0]);
		}

		arr = new int[10];
		visited = new boolean[10];
		find(0);
		System.out.println(result);
	}

	public static void find(int idx) {
		// System.out.println("idx = "+idx);
		if (idx == 10) {
			int zero = 0;
			for (int i = 0; i < 10; i++) {
				if (arr[i] == 0) {
					zero = i;
					break;
				}
			}
			if (set.contains(al[zero])) {
				return;
			}
			// System.out.println(Arrays.toString(arr));
			long sum = 0;

			for (char[] temp : list) {

				long a = 1;
				for (int i = temp.length - 1; i >= 0; i--) {
					sum += (a * arr[temp[i]-'A']);
					a*=10;
				}
				// if (sb.toString().equals("9876543201")) {
				// 	check = true;
				// }
				// if (check) {
				// 	System.out.println(Arrays.toString(arr));
				// 	System.out.println(sb);
				// }
			}
			result = Math.max(result, sum);
			return;
		}

		for (int i = 0; i < 10; i++) {
			if(visited[i]) continue;
			// if(i == 0 && idx == 0 && set.contains(al[i])) continue;
			visited[i] = true;
			arr[idx] = i;
			find(idx + 1);
			visited[i] = false;
		}
	}
}
