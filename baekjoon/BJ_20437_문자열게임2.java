package algo_202412;

import java.io.*;
import java.util.*;

public class BJ_20437_문자열게임2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0 ;t < T ; t++){
			char[] input = br.readLine().toCharArray();
			int K = Integer.parseInt(br.readLine());

			int[] count = new int[26];

			int left = 0;
			int right = 0;
			int N = input.length;
			int min = Integer.MAX_VALUE;
			List<Integer>[] list = new ArrayList[26];
			for (int i = 0; i < 26; i++) {
				list[i] = new ArrayList<>();
			}

			// System.out.println("+++++");
			for (; right < N; right++) {
				int idx = input[right] - 'a';
				count[idx]++;
				list[idx].add(right);

				if (count[idx] == K) {
					while (input[left] != input[right]) {
						int leftIdx = input[left] - 'a';
						count[leftIdx]--;
						left++;
					}
					// System.out.println("right = "+ right +", left = "+left);
					min = Math.min(min, right - left+1);

					count[idx]--;
					left++;
				}
			}

			int max = 0;
			for (int i = 0; i < 26; i++) {
				if (list[i].size() >= K) {
					left = 0;
					right = K-1;
					for (; right < list[i].size(); right++, left++) {
						max = Math.max(max, list[i].get(right) - list[i].get(left) + 1);
					}
				}
			}

			if (min == Integer.MAX_VALUE || max == 0) {
				sb.append(-1);
			} else {
				sb.append(min).append(" ").append(max);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
