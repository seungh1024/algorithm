package algo_202402;

import java.util.*;

public class P_과제진행하기 {
	public static void main(String[] args) {
		P_과제진행하기 test = new P_과제진행하기();
		String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
		String[] answer = test.solution(plans);
		String[] result = {"korean", "english", "math"};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public String[] solution(String[][] plans) {
		Stack<Task> stack = new Stack<>(); // 중간에 멈춘 과제
		Queue<Task> pq = new PriorityQueue<>(); // 시간 순서대로 넣을 과제
		for(String[] plan : plans){
			String[] start = plan[1].split(":");
			int startTime = Integer.parseInt(start[0])*60 + Integer.parseInt(start[1]);
			int lastTime = Integer.parseInt(plan[2]);
			int endTime = startTime + lastTime;

			Task input = new Task(plan[0],startTime,endTime,lastTime);
			pq.offer(input);
		}

		int index = 0;
		int length = plans.length;
		String[] answer = new String[length];

		int nowTime = 0;
		while(!pq.isEmpty()){
			Task now = pq.poll();
			if(!stack.isEmpty()){
				while(!stack.isEmpty()){
					Task last = stack.pop();
					if(nowTime+last.lastTime <= now.startTime){
						answer[index++] = last.name;
						nowTime +=last.lastTime;
					}else{
						last.lastTime -= (now.startTime-nowTime);
						stack.push(last);
						break;
					}
				}
				stack.push(now);
				nowTime = now.startTime;

			}else{
				stack.push(now);
				nowTime = now.startTime;
			}
		}

		while(!stack.isEmpty()){
			Task data = stack.pop();
			answer[index++] = data.name;
		}
		return answer;
	}

	public static class Task implements Comparable<Task>{
		String name;
		int startTime;
		int endTime;
		int lastTime;

		public Task(String name, int startTime, int endTime, int lastTime){
			this.name = name;
			this.startTime = startTime;
			this.endTime = endTime;
			this.lastTime = lastTime;
		}

		@Override
		public int compareTo(Task t){
			return this.startTime - t.startTime;
		}

		@Override
		public String toString(){
			return " name: "+ name + ", startTime: "+startTime + ", endTime: "+ endTime + ", lastTime: "+lastTime;
		}
	}
}
