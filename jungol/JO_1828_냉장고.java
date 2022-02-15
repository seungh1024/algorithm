package day0215;

import java.io.*;
import java.util.*;

public class JO_1828_냉장고 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		refrigerator[] input = new refrigerator[N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			input[i] = new refrigerator(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(count(input));
		
	}
	
	static class refrigerator implements Comparable<refrigerator>{
		public int low;
		public int high;
		
		public refrigerator(int low, int high){
			super();
			this.low = low;
			this.high = high;
		}

		@Override
		public int compareTo(refrigerator o) {
			// TODO Auto-generated method stub
			return this.low != o.low ? this.low-o.low: this.high - o.high ;
		}
	}
	
	public static int count(refrigerator[] data) {
		int count = 1;
		
		Arrays.sort(data);
//		System.out.println(data[0].low+","+data[0].high);
		int nowl = data[0].low;
		int nowh = data[0].high;
		for(int i = 1, size = data.length; i <size; i++ ) {
			if(data[i].low <= nowh ) {
				nowl = data[i].low; //범위를 좁힘
				if(data[i].high<=nowh) {
					nowh = data[i].high;
				}
//				now = data[i].
			}
			else {// 새로들어온 최저 온도가 현재의 최고 온도보다 높으면 새로운 냉장고를 가져와야 함
				count++;
				nowl = data[i].low;
				nowh = data[i].high;
			}
//			result = last>count? last:count;
//			last = count;
//			System.out.println(nowl+","+nowh);
		}
//		System.out.println(count);
		return count;
	}

}
