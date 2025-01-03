package algo_202501;

import java.io.*;
import java.util.*;

public class BJ_18114_블랙프라이데이 {
	public static int N, C;
	public static int[] data;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(data);

		boolean result = find(0,C);
		for (int i = 0; i < N; i++) {
			if(C-data[i] <= 0) break;
			result |= find(i + 1, C - data[i]);
		}
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int sum = data[i]+data[j];
				if(C-sum <= 0) break;
				result |= find(j+1,C-sum);
			}
		}

		if (result) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static boolean find(int start,int target) {
		int end = N-1;

		while (start < end) {
			int mid = (start+end)/2;

			if (data[mid] >= target) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		if (start >= N) {
			return false;
		}
		if (data[start] == target) {
			return true;
		}
		return false;
	}
}
