package day0404;

import java.io.*;
import java.util.*;

public class SWEA_3308_최장증가부분수열Hard {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] list = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				list[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(list));
			
//			int[] result = new int[N];
			ArrayList<Integer> result = new ArrayList<>();
//			result[0] = list[0];
			result.add(list[0]);
			
			for(int i = 1; i < N; i++) {
				int findIndex = Arrays.binarySearch(result.toArray(), list[i]);
				int index = Math.abs(findIndex)-1;
				if(index > result.size()-1) {
					result.add(list[i]);
				}else {
					result.remove(index);
					result.add(index,list[i]);
				}
			}
			
			System.out.println("#"+t+" "+result.size());
//			System.out.println(result);
		}
	}
}

//2
//5
//1 3 2 5 4
//6
//4 2 3 1 5 6