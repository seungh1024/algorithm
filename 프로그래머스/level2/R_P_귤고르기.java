package algo_202402;

import java.util.*;

public class R_P_귤고르기 {
	public int solution(int k, int[] tangerine) {
		int answer = 0;
		Map<Integer,Integer> map = new HashMap<>(); // 귤 개수 카운트

		for(int t : tangerine){
			Integer value = map.get(t);
			if(value == null){
				map.put(t,1);
			}else{
				map.put(t,value+1);
			}
		}

		Queue<Data> pq = new PriorityQueue<>();
		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			int size = entry.getKey();
			int count = entry.getValue();
			pq.offer(new Data(size,count));
		}

		while(!pq.isEmpty() && k > 0){
			Data now = pq.poll();
			k -= now.count;
			answer++;
		}

		return answer;
	}

	public class Data implements Comparable<Data>{
		int size;
		int count;

		public Data(int size, int count){
			this.size = size;
			this.count = count;
		}

		@Override
		public int compareTo(Data d){
			return d.count-this.count;
		}
	}
}
