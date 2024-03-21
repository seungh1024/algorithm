package algo_202403;

import java.util.*;

public class R_P_주차요금계산 {
	public static Map<String,Integer> map; // <차량 번호, 시각>
	public static Map<String,Integer> result;

	public int[] solution(int[] fees, String[] records) {
		map = new HashMap<>();
		result = new TreeMap<>();
		int length = records.length;
		for(int i = 0; i < length; i++){
			String[] input = records[i].split(" ");
			String[] timeData = input[0].split(":");
			int time = Integer.parseInt(timeData[0])*60 + Integer.parseInt(timeData[1]);
			String num = input[1];

			if(input[2].equals("IN")){
				map.put(num,time);
			}else{
				plusCharge(num, time);
			}
			ArrayList
			RandomAccess;
		}
		int lastTime = 23*60+59;
		for(Map.Entry<String,Integer> entry : map.entrySet()){
			String carNum = entry.getKey();
			Integer time = entry.getValue();
			plusCharge(carNum,lastTime);


			// System.out.println(entry);
		}

		int size = result.size();
		int[] answer = new int[size];
		int index = 0;
		for(Map.Entry<String,Integer> entry : result.entrySet()){
			Integer time = entry.getValue();
			answer[index++] = chargeCalc(time,fees);
		}


		return answer;
	}

	public static int chargeCalc(int time, int[] fees){
		int charge = fees[1];
		time -= fees[0];

		if(time > 0){
			charge += ((time/fees[2])*fees[3]);
			if(time%fees[2] > 0){
				charge += fees[3];
			}
		}

		return charge;
	}

	public static void plusCharge(String carNum, int time){
		Integer startTime = map.get(carNum);
		if(startTime == null)return;
		int totalTime = time-startTime;

		Integer timeSum = result.get(carNum);
		if(timeSum == null){
			result.put(carNum,totalTime);
		}else{
			result.put(carNum,totalTime+timeSum);
		}

		map.put(carNum,null);
		// if(map.get(carNum) != null){
		//     map.remove(carNum);
		// }
		// map.remove(carNum);// ..?
	}
}
