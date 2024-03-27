package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_2230_수고르기투포인터 {
	public static int N,M;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(data);

		int left = 0;
		int right = 0;
		int min = Integer.MAX_VALUE;
		if(M == 0){
			System.out.println(0);
			return;
		}
		while (true) {
			int value = data[right] - data[left];
			if (value < M) {
				right ++;
			} else if (value >= M) {
				left ++;
				min = Math.min(min,value);
			}
			if (right >= N) {
				if(value <M){
					break;
				}
				right --;
			}
		}
		System.out.println(min);
	}
}
