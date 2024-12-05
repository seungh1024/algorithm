package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_2613_숫자구슬 {
	public static int N, M;
	public static int[] data;
	public static List<Integer> list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++){
			data[i] = Integer.parseInt(st.nextToken());
		}

		// for (int i = 1; i <= N; i++) {
		// 	data[i] += data[i-1];
		// }

		list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		int size = find();
		sb.append(size).append("\n");

		for (int i : list) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	public static int find() {
		int start = 0;
		int end = 30001;

		int cnt = 20;
		while (start < end && cnt-- > 0) {
			int mid = (start + end) / 2;

			// System.out.println(mid);


			if (getValue(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}

	public static boolean getValue(int range) {
		// System.out.println("?");
		// System.out.println(list);
		int idx = 0;
		int cnt = 1;
		int sum = 0;
		int dataCount = 0;
		int[] groupCount = new int[N+1];
		for (int i = 1; i <= N; i++) {
			if(cnt > M || data[i] > range) return false;

			if (sum + data[i] > range || N - i < M - cnt) {
				groupCount[cnt] = dataCount;
				cnt++;
				dataCount = 1;
				sum = data[i];
			} else {
				dataCount++;
				sum += data[i];
			}

		}

		if(cnt > M) return false;

		groupCount[cnt] = dataCount;
		list = new ArrayList<>();
		for(int i : groupCount){
			if (i != 0) {
				list.add(i);
			}
		}

		return true;
	}
}
