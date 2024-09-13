package algo_202409;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class BJ_21774_가희와로그파일 {
	public static int N, Q;
	public static List<String>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		list = new ArrayList[7];
		for (int i = 1; i <= 6; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("#");
			int idx = Integer.parseInt(input[1]);
			list[idx].add(input[0]);
		}


		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			String[] query = br.readLine().split("#");
			String start = query[0];
			String end = query[1];
			int idx = Integer.parseInt(query[2]);
			int sum = 0;
			for (int j = idx; j <= 6; j++) {
				sum += find(j,start, end);
			}
			sb.append(sum).append("\n");
		}

		System.out.println(sb);
	}

	public static int find(int idx, String startTime, String endTime) {
		int start = 0;
		int end = list[idx].size();

		int left = 0;
		while (start < end) {
			int mid = (start + end) / 2;

			if (list[idx].get(mid).compareTo(startTime) >= 0) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		left = start;

		int right = 0;
		start = 0;
		end = list[idx].size();
		while (start < end) {
			int mid = (start + end) / 2;

			if (list[idx].get(mid).compareTo(endTime) > 0) {
				end = mid;
			} else {
				start = mid+1;
			}
		}
		right = start;

		// System.out.println("idx = "+idx);
		// System.out.println("right = "+right + ", left = "+left);

		return right-left;
	}
}
