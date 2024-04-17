package algo_202403;

import java.util.*;
import java.io.*;

public class BJ_1107_리모컨 {
	public static int N,M;
	public static int start = 100;
	public static boolean[] broken;
	public static int[] check;
	public static int result;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String number = br.readLine();
		int length = number.length();

		N = Integer.parseInt(number);
		M = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int index = Integer.parseInt(st.nextToken());
				broken[index] = true;
			}
		}
		result = Math.abs(N-start);
		// System.out.println(result);


		for (int i = length - 1; i <= length + 1; i++) {
			if(i <= 0) continue;
			check = new int[i];
			find(0,i);
		}
		System.out.println(result);
	}

	public static void find(int index,int length) {
		if (index >= length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < length; i++) {
				sb.append(check[i]);
			}

			int num = Integer.parseInt(sb.toString());
			result = Math.min(result, Math.abs(N-num)+length);

			return;
		}

		for (int i = 0; i <= 9; i++) {
			if(broken[i]) continue;
			check[index] = i;
			find(index+1,length);
		}
	}
}
