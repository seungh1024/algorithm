package algo_202403;

import java.util.*;

public class R_P_셔틀버스 {
	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";

		Map<Integer,Integer> map = new HashMap<>();
		int max = 60*24-1;
		for(String time : timetable){
			String[] input = time.split(":");
			int key = Integer.parseInt(input[0])*60 + Integer.parseInt(input[1]);

			Integer value = map.get(key);
			if(value == null){
				map.put(key,1);
			}else{
				map.put(key,value+1);
			}
		}

		Queue<Data> pq = new PriorityQueue<>();
		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			int key = entry.getKey();
			int value = entry.getValue();
			pq.offer(new Data(key,value));
		}

		int startBusTime = 540;
		int maxBusTime = 540 +(n-1)*t;
		int lastTime = 0;
		int seat = 0;
		for(int i = startBusTime; i <= maxBusTime; i+=t){
			seat = m;
			while(!pq.isEmpty() && seat > 0){
				Data now = pq.poll();
				if(now.time > i) {
					pq.offer(now);
					break;
				}
				lastTime = now.time;
				if(now.count <= seat){
					seat -= now.count;
				}else{
					now.count -= seat;
					pq.offer(now);
					seat = 0;
				}
			}

			// if(pq.isEmpty()){
			//     lastTime = maxBusTime;
			//     break;
			// }
		}

		int myTime = 0;
		if(seat > 0){ // 좌석이 남았으면 큐에서 꺼내봄.
			Data now = null;
			System.out.println(seat);
			if(!pq.isEmpty()){
				now = pq.poll();
			}
			if(now == null){
				myTime = Math.max(lastTime,maxBusTime);
			}
			if(now != null){
				if(now.count < seat){
					myTime = now.time;
				}else{
					myTime = now.time-1;
				}
			}
			myTime = Math.max(myTime,lastTime);
		}else{
			myTime = lastTime-1;
		}
		if(myTime > maxBusTime){
			myTime = maxBusTime;
		}
		answer = makeResult(myTime);
		return answer;
	}

	public static String makeResult(int time){
		StringBuilder sb = new StringBuilder();
		int hour = time/60;
		int minute = time % 60;
		if(hour < 10){
			sb.append("0");
		}
		sb.append(hour).append(":");
		if(minute<10){
			sb.append("0");
		}
		sb.append(minute);

		return sb.toString();
	}

	public static class Data implements Comparable<Data>{
		int time;
		int count;

		public Data(int time, int count){
			this.time = time;
			this.count = count;
		}

		@Override
		public int compareTo(Data d){
			return this.time - d.time;
		}

		@Override
		public String toString(){
			return "time = "+time + ", count = "+count;
		}
	}
}
