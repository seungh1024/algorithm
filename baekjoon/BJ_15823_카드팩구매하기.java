package algo_202405;

import java.io.*;
import java.util.*;

public class BJ_15823_카드팩구매하기 {
	public static int N,M;
	public static int[] data;
	public static int[] check;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		check = new int[500001];
		int result = find();
		System.out.println(result);
	}

	public static int find() {
		int start = 1;
		int end = N;

		while (start < end) {
			int mid = (start+end+1)/2;

			int count = 0;
			int left = 0;
			int right = 0;
			Arrays.fill(check, -1);
			while (right < N) {
				if (check[data[right]] >= left) {
					left = check[data[right]]+1;
				}

				check[data[right]] = right;
				if (right - left + 1 == mid) {
					count++;
					left = right+1;
				}
				if (count == M) {
					break;
				}
				right++;
			}
			// System.out.println("mid = "+mid + ", count = "+count);

			if (count < M) {
				end = mid-1;
			} else {
				start = mid;
			}

		}

		return start;
	}
}
