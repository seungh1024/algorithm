package algo_202402;

import java.util.*;

public class R_P_택배배달과수거하기 {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;
		Stack<Data> del = new Stack<>();
		Stack<Data> pick = new Stack<>();
		for(int i = 0; i < n; i++){
			if(deliveries[i] > 0){
				del.push(new Data(i+1,deliveries[i]));
			}
			if(pickups[i] > 0){
				pick.push(new Data(i+1,pickups[i]));
			}
		}
		int pickCount = cap;
		long maxIndex = 0;
		while(!pick.isEmpty()){
			Data now = pick.pop();
			maxIndex = Math.max(maxIndex,now.index);
			if(pickCount >= now.value){
				pickCount -= now.value;
			}else{
				now.value-= pickCount;
				pick.push(now);

				int delCount = cap;
				while(!del.isEmpty()){
					Data next = del.pop();
					maxIndex = Math.max(maxIndex, next.index);
					if(delCount >= next.value){
						delCount -= next.value;
					}else{
						next.value -= delCount;
						del.push(next);
						break;
					}
				}
				answer += (maxIndex*2);
				pickCount = cap; // 다시 원복
				maxIndex = 0;
			}
		}

		int delCount = cap;
		while(!del.isEmpty()){
			Data now = del.pop();
			maxIndex = Math.max(maxIndex,now.index);
			if(delCount >= now.value){
				delCount-=now.value;
			}else{
				now.value -= delCount;
				del.push(now);

				answer += (maxIndex*2);

				delCount = cap;
				maxIndex = 0;
			}
		}
		answer += (maxIndex*2);

		return answer;
	}

	public static class Data{
		long index;
		int value;

		public Data(long index, int value){
			this.index = index;
			this.value = value;
		}

		@Override
		public String toString(){
			return "index: "+index + ", value: "+value;
		}
	}
}
