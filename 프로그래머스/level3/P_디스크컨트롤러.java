package algo_202404;

import java.util.*;

public class P_디스크컨트롤러 {
	public int solution(int[][] jobs) {
		int answer = 0;

		Queue<Job> array = new PriorityQueue<>((o1,o2)->{
			if(o1.start == o2.start){
				return o1.time-o2.time;
			}
			return o1.start - o2.start;
		});

		Queue<Job> pq = new PriorityQueue<>();

		int length = jobs.length;
		Job[] data = new Job[length];
		for(int i = 0; i < length; i++){
			int[] job = jobs[i];
			// pq.offer(new Job(i,job[0],job[1]));
			data[i] = new Job(i,job[0],job[1]);
			array.offer(new Job(i,job[0],job[1]));
		}

		Arrays.sort(data,(o1,o2)->{
			return o1.time-o2.time;
		});

		int end = 0;
		boolean[] visited = new boolean[length];
		while(!array.isEmpty()){
			Job now = array.poll();
			if(visited[now.index]) continue;

			if(now.start >= end){
				end = now.start+now.time;
				answer += now.time;
				visited[now.index] = true;
			}else{
				array.offer(now);
				for(int i = 0; i < length; i++){
					Job next = data[i];

					if(visited[next.index]) continue;

					if(next.start < end){
						// System.out.println(next);
						visited[next.index] = true;
						end += next.time;
						answer += end-next.start;
						break;
					}
				}
			}

		}



		return answer/length;
	}

	public static class Job implements Comparable<Job>{
		int index;
		int start;
		int time;

		public Job(int index, int start, int time){
			this.index = index;
			this.start = start;
			this.time = time;
		}

		@Override
		public int compareTo(Job j){
			return this.time - j.time;
		}

		@Override
		public String toString(){
			return "index = "+ index + ", start = "+start + ", time = "+time;
		}

	}
}
