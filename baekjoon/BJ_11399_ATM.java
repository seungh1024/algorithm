package day0211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11399_ATM {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());//시간 입력
//		List<Integer> time = new ArrayList<>();
//		
//		for(int i = 0; i <N; i++) {
//			time.add(Integer.parseInt(st.nextToken()));
//		}
//		Collections.sort(time);
//		int sum = time.get(0);
//		for(int i = 1; i < N; i++) {
//			time.set(i, time.get(i-1)+time.get(i));
//			sum += time.get(i);
//		}
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			pQueue.offer(Integer.parseInt(st.nextToken()));
		}
		
		int sum = 0;
		int last = 0;
		int poll = 0;
		while(!pQueue.isEmpty()) {
			poll = pQueue.poll();
			last = last+poll;
			sum+=last;
		}
		System.out.println(sum);
	}

}
