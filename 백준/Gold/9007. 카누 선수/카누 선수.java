

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int[][] data = new int[5][N + 1];
			for (int i = 1; i < 5; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					data[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					list1.add(data[1][i] + data[2][j]);
					list2.add(data[3][i] + data[4][j]);
				}
			}
			Collections.sort(list2);
			// System.out.println(list1);
			// System.out.println(list2);
			int max = 0;
			int abs = Integer.MAX_VALUE;
			for (int i : list1) {
				int idx = binarySearch(list2, K - i, i, K);
				int sum = i+list2.get(idx);
				// System.out.println("i = "+i + ", sum = "+sum + ", abs = "+abs);
				if (Math.abs(K - sum) < abs) {
					abs = Math.abs(K-sum);
					max = sum;
				} else if (Math.abs(K - sum) == abs && sum < max) {
					max = sum;
				}
			}
			sb.append(max).append("\n");

		}
		System.out.println(sb);
	}

	public static int binarySearch(List<Integer> list, int target, int v, int K) {
		int start = 0;
		int end = list.size()-1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (list.get(mid) >= target) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		if(start != 0 &&list.get(start) > target){
			int rabs = Math.abs(target - list.get(start));
			int labs = Math.abs(target - list.get(start-1));
			if (labs <= rabs) {
				start--;
			}
			// System.out.println("rabs = "+rabs + ", labs = "+labs + ", start = "+start);
		}

		// System.out.println("target = " +target + ", start info = "+list.get(start));

		// if (start != list.size()-1 && list.get(start) < target) {
		// 	int rabs = Math.abs(K - list.get(start+1) - v);
		// 	int labs = Math.abs(K - list.get(start) - v);
		// 	if (rabs < labs) {
		// 		start++;
		// 	}
		// }

		return start;
	}
}
