package algo_202401;

import java.util.*;

public class P_3차압축 {
	public static void main(String[] args) {
		P_3차압축 test = new P_3차압축();
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		int[] answer = test.solution(msg);
		int[] result = {20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34};
		if (Arrays.equals(result, answer)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	public static Map<String,Integer> map;
	public int[] solution(String msg) {
		initMap();
		Queue<Integer> q = new ArrayDeque<>();
		char[] data = msg.toCharArray();
		int length = data.length;
		int newIndex = 27;

		int i = 0;
		int size = length-1;
		StringBuilder sb = new StringBuilder();
		int number = 0;
		while(i < length){
			sb.append(data[i]+"");
			Integer findNumber = map.get(sb.toString());
			// System.out.println(findNumber + ", sb: "+sb);
			if(findNumber != null){
				i++;
				number = findNumber;
			}else{
				q.offer(number);
				map.put(sb.toString(),newIndex++);
				sb = new StringBuilder();
			}
		}
		q.offer(map.get(sb.toString()));
		// System.out.println(q);
		// System.out.println(map);
		int[] answer = new int[q.size()];
		int answerIndex = 0;
		while(!q.isEmpty()){
			answer[answerIndex++] = q.poll();
		}
		return answer;
	}

	public static void initMap(){
		map = new HashMap<>();
		char c = 'A';
		for(int i = 1; i <= 26; i++){
			map.put(c+"",i);
			c++;
		}
		// System.out.println(map);
	}
}
