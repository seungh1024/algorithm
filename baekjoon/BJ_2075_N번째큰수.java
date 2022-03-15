package day0315;

import java.io.*;
import java.util.*;

public class BJ_2075_N번째큰수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				pQueue.offer(Integer.parseInt(st.nextToken()));
			}
		}
		int size = N*N-N;
		for(int i = 0; i < size; i++) {
			pQueue.poll();
		}
		System.out.println(pQueue.poll());
	}

}
