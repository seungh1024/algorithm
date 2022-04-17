package day0417;

import java.io.*;
import java.util.*;

public class BJ_15486_퇴사2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Schedule[] schedule = new Schedule[N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			schedule[i] = new Schedule(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		int[] money = new int[N+1];
		
		int maxMoney = 0;
		for(int i = 0; i < N; i++) {
			Schedule now = schedule[i];
//			System.out.println(now.t+","+now.p);
//			if(i+now.t <= N && money[i+now.t] < money[i] + schedule[i].p) {
//				money[i+now.t] = money[i] + schedule[i].p; 
//			}
			maxMoney = Math.max(maxMoney, money[i]);
			if(i+now.t<=N) {
				money[i+now.t] = Math.max(maxMoney+now.p, money[i+now.t]); 
			}
			
		}
		
//		int result = 0;
//		for(int i = 1; i <= N; i++) {
//			result = Math.max(result, money[i]);
//		}
		
		System.out.println(Math.max(maxMoney, money[N]));
//		System.out.println(Arrays.toString(money));
		
	}
	
	public static class Schedule{
		int t;//상담 기간
		int p;//상담완료 후 금액
		
		public Schedule() {};
		public Schedule(int t, int p) {
			super();
			this.t = t;
			this.p = p;
		}
	}
}
