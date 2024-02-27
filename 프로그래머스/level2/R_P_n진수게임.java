package algo_202402;

import java.util.*;

public class R_P_n진수게임 {
	private static Map<Integer,Character> map;
	private static int totalSize;
	public String solution(int n, int t, int m, int p) {
		String answer = "";
		initMap();
		totalSize = t*m-1;

		int num = 1;
		StringBuilder sb = new StringBuilder();
		sb.append(0);
		Stack<Integer> stack = new Stack<>();
		while(totalSize > 0){
			int target = num;
			while(target > 0){
				stack.push(target%n);
				target /= n;
			}
			num++;

			while(!stack.isEmpty() && totalSize > 0){
				int now = stack.pop();
				Character value = map.get(now);
				if(value == null){
					sb.append(now);
				}else{
					sb.append(value);
				}
				totalSize--;
			}

		}
		String data = sb.toString();
		System.out.println(data);
		StringBuilder find = new StringBuilder();
		int index = p-1;
		for(int i = 0; i < t; i++){
			find.append(data.charAt(index));
			index+=m;
		}
		answer = find.toString();

		return answer;
	}

	private static void initMap(){
		map = new HashMap<>();
		map.put(10,'A');
		map.put(11,'B');
		map.put(12,'C');
		map.put(13,'D');
		map.put(14,'E');
		map.put(15,'F');

	}
}
