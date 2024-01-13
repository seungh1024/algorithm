package algo_202401;

import java.util.*;

public class P_숫자변환하기 {
	public static void main(String[] args) {
		P_숫자변환하기 test = new P_숫자변환하기();
		int x=  10;
		int y = 40;
		int n = 5;
		int result = 2;
		int answer = test.solution(x, y, n);
		if (result == answer) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(int x, int y, int n) {
		int answer = -1;
		Queue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(y,0));
		while(!pq.isEmpty()){
			Data now = pq.poll();

			if(now.value == x){
				answer = now.count;
				break;
			}

			if(now.value-n >= x){
				pq.offer(new Data(now.value-n,now.count+1));
			}
			if(now.value%2== 0 && now.value/2 >=x){
				pq.offer(new Data(now.value/2,now.count+1));
			}
			if(now.value%3 == 0 && now.value/3 >= x){
				pq.offer(new Data(now.value/3,now.count+1));
			}

		}
		return answer;
	}

	public static class Data implements Comparable<Data>{
		int value, count;

		public Data(int value, int count){
			this.value = value;
			this.count = count;
		}

		@Override
		public int compareTo(Data d){
			if(this.count == d.count){
				return d.value - d.value;
			}
			return this.count - d.count;
		}
	}
}
