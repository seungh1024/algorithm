package algo_202401;

import java.util.*;

public class P_호텔대실 {
	public static void main(String[] args) {
		P_호텔대실 test = new P_호텔대실();
		String[][] book_time = {{"09:10", "10:10"}, {"10:20", "12:20"}};
		int answer = test.solution(book_time);
		int result = 1;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	public int solution(String[][] book_time) {
		int answer = 0;
		Queue<Data> pq = new PriorityQueue<>();
		for(String[] time : book_time){
			String[] startTime = time[0].split(":");
			String[] endTime = time[1].split(":");
			int start = Integer.parseInt(startTime[0])*60 + Integer.parseInt(startTime[1]);
			int end = Integer.parseInt(endTime[0])*60 + Integer.parseInt(endTime[1])+10;
			pq.offer(new Data(start,end));
		}

		Queue<Data> times = new PriorityQueue<>(); // 정렬된 시간 정보
		Data first = pq.poll();
		first.flag = true;
		times.offer(first);
		while(!pq.isEmpty()){
			Data data = pq.poll();
			Data time = times.poll();
			// System.out.println("data.start: "+data.start + ", data.end: "+data.end);
			// System.out.println("time.start: "+time.start + ", time.end: "+time.end);
			if(time.end <= data.start){
				time.end = data.end;
				times.offer(time);
			}else{
				times.offer(time);
				data.flag = true;
				times.offer(data);
			}
		}


		return answer = times.size();
	}

	public static class Data implements Comparable<Data>{
		int start, end;
		boolean flag;

		public Data(int start, int end){
			this.start = start;
			this.end = end;
			this.flag = false;
		}

		@Override
		public int compareTo(Data d){
			if(d.flag){
				return this.end - d.end;
			}else{
				return this.start-d.start;
			}

		}
	}
}
