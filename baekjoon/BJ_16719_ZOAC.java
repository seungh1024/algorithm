package algo_202410;

import java.io.*;
import java.util.*;

public class BJ_16719_ZOAC {
	public static char[] data;
	public static boolean[] visited;
	public static StringBuilder result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		data = br.readLine().toCharArray();
		List<Data> list = new ArrayList<>();
		for (int i = 0; i < data.length; i++) {
			list.add(new Data(data[i], i));
		}

		list.sort(Comparator.comparing((Data data) -> data.c).thenComparing(data -> data.idx));

		visited = new boolean[data.length];
		result = new StringBuilder();
		find(0,data.length-1);
		System.out.println(result);
	}

	public static void find(int left, int right) {
		// System.out.println("left = "+left + ", right = "+right);
		char c = 'a';
		int idx = -1;
		for (int i = left; i <= right; i++) {
			if (data[i] < c) {
				c = data[i];
				idx = i;
			}
		}

		if (idx != -1) {
			// System.out.println("find idx = "+idx);
			visited[idx] = true;
			for (int i = 0; i < data.length; i++) {
				if (visited[i]) {
					result.append(data[i]);
				}
			}
			result.append("\n");
			find(idx+1,right);
			// System.out.println("right end");
			find(left,idx-1);
			// System.out.println("left end");
		}
	}

	public static class Data{
		char c;
		int idx;

		public Data(char c, int idx) {
			this.c = c;
			this.idx = idx;
		}
	}

}
