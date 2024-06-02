package vsfe_20240531;

import java.io.*;
import java.util.*;

public class BJ_31423_신촌통폐합계획 {
	public static int N;
	public static String[] data;
	public static StringBuilder sb;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		data = new String[N+1];

		for (int i = 1; i <= N; i++) {
			data[i] = br.readLine();
		}

		int[] last = new int[N+1];
		int[] next = new int[N+1];
		for (int i = 1; i <= N; i++) {
			last[i] = i;
			next[i] = i;
		}
		int l = 0;
		int r = 0;
		StringTokenizer st;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			next[last[l]] = r;
			last[l] = last[r];
		}

		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(data[l]);
			l = next[l];
		}

		System.out.println(sb);
	}



}
