package algo_202411;

import java.io.*;
import java.util.*;

public class BJ_22945_팀빌딩 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N-1;
		int max = 0;
		while (left < right) {
			if (data[left] <= data[right]) {
				max = Math.max(max, (right - left - 1) * data[left]);
				left++;
			} else {
				max = Math.max(max, (right - left - 1) * data[right]);
				right--;
			}

		}

		System.out.println(max);
	}
}
