package algo_202403;

import java.util.*;

public class P_광고삽입 {
	public String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";
		String[] playInput = play_time.split(":");
		int totalTime = stringTimeToInt(playInput)+2;
		String[] advInput = adv_time.split(":");
		int advTime = stringTimeToInt(advInput);
		System.out.println("davTime = "+advTime);

		int[] timeSlice = new int[totalTime];
		for(String log : logs){
			String[] input = log.split("-");
			String[] startInput = input[0].split(":");
			String[] endInput = input[1].split(":");
			int startTime = stringTimeToInt(startInput);
			int endTime = stringTimeToInt(endInput);
			timeSlice[startTime+1] ++;
			// System.out.println("mark = "+timeSlice[startTime]);
			// System.out.println("startTime = "+startTime + ", endtime = "+endTime);
			timeSlice[endTime+1]--;
			// System.out.println("unmark = "+timeSlice[endTime+1] + ", index= "+(endTime+1));
		}
		long[] partSum = new long[totalTime];
		for(int i = 1; i <totalTime; i++){
			timeSlice[i] = timeSlice[i] + timeSlice[i-1];
			partSum[i] = timeSlice[i];
		}


		for(int i = 1; i < totalTime; i++){
			partSum[i] = partSum[i] + partSum[i-1];
			// timeSlice[i] = timeSlice[i] + timeSlice[i-1];
		}
		long max = 0;
		int lastTime = 0;
		for(int i = 1; i+advTime < totalTime; i++){
			// int nowTime = partSum[i+advTime-1] - partSum[i] + timeSlice[i];
			long nowTime = partSum[i+advTime-1] - partSum[i-1];
			if(nowTime > max){
				max = nowTime;
				lastTime = i-1;
			}
		}
		System.out.println(lastTime + ", max = "+max);

		answer = intTimeToString(lastTime);


		return answer;
	}

	public static String intTimeToString(int time){
		int second = time%60;
		time/=60;
		int minute = time%60;
		time/=60;
		int hour = time;
		StringBuilder sb = new StringBuilder();
		if(hour < 10){
			sb.append("0");
		}
		sb.append(hour).append(":");
		if(minute < 10){
			sb.append("0");
		}
		sb.append(minute).append(":");
		if(second < 10){
			sb.append("0");
		}
		sb.append(second);

		return sb.toString();
	}

	public static int stringTimeToInt(String[] input){
		return Integer.parseInt(input[0])*3600 + Integer.parseInt(input[1])*60+Integer.parseInt(input[2]);
	}
}
