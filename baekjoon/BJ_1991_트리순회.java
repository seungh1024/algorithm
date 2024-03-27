package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_1991_트리순회 {
	public static int N;
	public static Map<String,String[]> map;
	public static String[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new HashMap<>();

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String root = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();

			map.put(root,new String[]{left,right});
		}
		result = new String[3];
		Arrays.fill(result,"");

		find("A");
		for (int i = 0; i < 3; i++) {
			System.out.println(result[i]);
		}
	}
	public static void find(String s) {
		String[] next = map.get(s);
		if (next == null) {
			return;
		}
		result[0] += s;

		if (!next[0].equals(".")) {
			find(next[0]);
		}
		result[1] += s;

		if (!next[1].equals(".")) {
			find(next[1]);
		}
		result[2] += s;
	}
}
