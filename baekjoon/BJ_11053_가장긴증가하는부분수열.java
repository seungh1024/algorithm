package day0412;

import java.io.*;
import java.util.*;

public class BJ_11053_가장긴증가하는부분수열 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		int[] data= new int[N];
		for(int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> result = new ArrayList<>();
//		result.add(data[0]);
		for(int i = 0; i < N; i++) {
			int now = data[i];
			int index = Arrays.binarySearch(result.toArray(), now);
			if(index < 0) {
				index = index*(-1)-1;
			}
//			System.out.println(index);
			if(index < result.size()) {
				result.remove(index);
				result.add(index,now);
			}else {
				result.add(now);
			}
//			System.out.println(result);
//			System.out.println(index);
		}
		
		System.out.println(result.size());
//		System.out.println(result);
	}
}
