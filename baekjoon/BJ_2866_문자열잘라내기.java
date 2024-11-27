package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_2866_문자열잘라내기 {
	public static int R, C;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[][] data = new char[R][C];
		for (int i = 0; i < R; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				data[i][j] = input[j];
			}
		}

		List<StringBuilder> list = new ArrayList<>();
		for (int j = 0; j < C; j++) {
			list.add(new StringBuilder());
		}

		int result = 0;
		for (int i = R - 1; i > 0; i--) {
			Set<String> set = new HashSet<>();
			for (int j = 0; j < C; j++) {
				list.get(j).append(data[i][j]);
				set.add(list.get(j).toString());
			}

			// System.out.println(set);

			if (set.size() != C) {
				result = list.get(0).length();
			}
		}

		System.out.println(R-1-result);
	}
}
