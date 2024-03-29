package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_11663_선분위의점 {
	public static int N,M;
	public static int[] data;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		data = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(data);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// if(a > data[N-1]){
			// 	sb.append(0).append("\n");
			// 	continue;
			// }
			int start = find(a);
			int end = find(b);
			if(end != N && data[end] == b){
				end++;
			}
			// System.out.println("start = " + start + ", end = "+end);
			sb.append((end-start)).append("\n");
		}
		// System.out.println(find(40));
		System.out.println(sb);
	}

	public static int find(int num){
		int start = 0;
		int end = N;

		while (start < end) {
			int mid = (start+end)/2;

			if (data[mid] >= num) {
				end = mid;
			} else {
				start = mid+1;
			}
		}

		return start;
	}
}
