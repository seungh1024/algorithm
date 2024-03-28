package algo_202403;

import java.io.*;
import java.util.*;

public class BJ_19637_IF문좀대신써줘 {
	public static int N,M;
	public static int[] data;
	public static Map<Integer,String> map;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new HashMap<>();
		data = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int power = Integer.parseInt(st.nextToken());
			data[i] = power;
			if(map.get(power) == null){
				map.put(power,s);
			}

		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine());
			int index = find(num);
			if(data[index] < num){
				index--;
			}
			// System.out.println("index = "+index);
			sb.append(map.get(data[index])).append("\n");
		}

		System.out.println(sb);
	}
	public static int find(int num) {
		int start = 0;
		int end = N;
		while(start < end){
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
