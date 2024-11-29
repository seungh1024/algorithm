package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_2696_중앙값구하기 {
	public static int N;
	public static StringBuilder result = new StringBuilder();
	public static List<Integer> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int count = 0;
			list = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 1; i <= N; i++) {
				if (i>10 && (i - 1) % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}
				int num = Integer.parseInt(st.nextToken());
				int idx = find(num);
				if (idx >= list.size()) {
					list.add(num);
				} else {
					list.add(idx, num);
				}
				if (i % 2 == 1) {
					if (count>=10 && count % 10 == 0) {
						sb.append("\n");
					}
					count++;
					int mid = list.get(list.size() / 2);
					sb.append(mid).append(" ");
				}
			}
			result.append(count).append("\n").append(sb).append("\n");
		}
		System.out.println(result);
	}

	public static int find(int num) {
		int start = 0;
		int end = list.size();

		while (start < end) {
			int mid = (start + end) / 2;

			if (list.get(mid) >= num) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		return start;
	}
}
