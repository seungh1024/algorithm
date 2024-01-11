package algo_202401;

import java.util.*;

public class P_주차요금계산 {
	public static void main(String[] args) {
		P_주차요금계산 test = new P_주차요금계산();
		int[] fees= {180,5000,10,600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
			"18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] result = {14600,34400,5000};
		int[] answer = test.solution(fees, records);
		if (Arrays.equals(result, answer)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static Map<String,Integer> cost; // 차량 번호, 요금
	public static Map<String,String> data; // 입차 기록 <차량 번호, 시간>
	public static int maxTime = 23*60+59;

	// fees -> 0 : 기본 시간, 1: 기본 요금, 2: 단위 시간, 3: 단위 요금
	public int[] solution(int[] fees, String[] records) {

		cost = new TreeMap<>();
		data = new HashMap<>();

		StringTokenizer st;
		for(String record : records){
			st = new StringTokenizer(record);
			String time = st.nextToken();
			String carNumber = st.nextToken();
			String inOut = st.nextToken();
			if(inOut.equals("IN")){
				data.put(carNumber,time);
			}else{
				String lastTime = data.get(carNumber);
				st = new StringTokenizer(lastTime,":");
				int lastHour = Integer.parseInt(st.nextToken());
				int lastMinutes = Integer.parseInt(st.nextToken());
				int lastTotal = lastHour*60 + lastMinutes;

				st = new StringTokenizer(time,":");
				int nowHour = Integer.parseInt(st.nextToken());
				int nowMinutes = Integer.parseInt(st.nextToken());
				int nowTotal = nowHour*60 + nowMinutes;

				Integer value = cost.get(carNumber);
				if(value != null){
					cost.put(carNumber,value + nowTotal-lastTotal);
				}else{
					cost.put(carNumber,nowTotal-lastTotal);
				}

				data.remove(carNumber);
			}
		}
		// System.out.println(data);

		for(Map.Entry<String,String> entry : data.entrySet()){
			String carNumber = entry.getKey();
			String time = entry.getValue();
			st = new StringTokenizer(time, ":");
			int hour = Integer.parseInt(st.nextToken());
			int minutes = Integer.parseInt(st.nextToken());
			int total = hour*60+minutes;

			Integer value = cost.get(carNumber);
			if(value != null){
				cost.put(carNumber, value + maxTime - total);
			}else{
				cost.put(carNumber, maxTime-total);
			}

		}

		// System.out.println(cost);

		int size = cost.size();
		int[] answer = new int[size];
		int index = 0;
		for(Map.Entry<String,Integer> entry : cost.entrySet()){
			int time = entry.getValue();
			int plusTime = time-fees[0];
			if(plusTime > 0){
				answer[index++] = fees[1] + (plusTime + fees[2]-1)/fees[2]*fees[3];
			}else{
				answer[index++] = fees[1];
			}

		}

		return answer;
	}
}
