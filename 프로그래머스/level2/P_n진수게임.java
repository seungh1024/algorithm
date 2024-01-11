package algo_202401;

import java.util.*;

public class P_n진수게임 {
	public static void main(String[] args) {
		P_n진수게임 test = new P_n진수게임();
		int n = 8;
		int t = 8;
		int m = 5;
		int p = 3;
		String result = "27141126";
		String answer = test.solution(n, t, m, p);
		if (result.equals(answer)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}

	}
	public static Map<Integer,Character> map;
	public String solution(int n, int t, int m, int p) {
		String answer = "";
		initMap();


		int num = 0;
		int index = 0;
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < t; i++){
			int turn = p;
			while(true){
				String data = changeNum(num,n);
				// System.out.println("data: "+data + ", num: "+ num + ", index: "+index);
				int length = data.length();
				if(length-index < turn){
					turn -= (length-index);
					num++;
					index = 0;
				}else{
					index += turn-1;
					sb.append(data.charAt(index));

					if(index+1 == length){
						index = 0;
						num++;
					}else{
						index++;
					}
					break;
				}

			}
			int lastMember = m-p;
			while(true){
				String data = changeNum(num,n);
				// System.out.println("last member: " + "data: "+data + ", num: "+ num + ", index: "+index + ", lastMember: "+lastMember);
				int length = data.length();
				if(length - index < lastMember){
					lastMember -= (length-index);
					num++;
					index = 0;
				}else{
					index += lastMember-1;
					if(index+1 == length){
						index = 0;
						num++;
					}else{
						index++;
					}
					break;
				}
			}
		}

		return sb.toString();
	}

	public static String changeNum(int num, int n){
		if(num == 0){
			return "0";
		}
		StringBuilder sb = new StringBuilder();


		if(n == 10){
			String s = num+"";
			char[] data = s.toCharArray();
			for(char c : data){
				sb.append(c);
			}
		}else{
			Stack<Character> stack = new Stack<>();
			while(num > 0){
				stack.push(map.get(num%n));
				num /= n;
			}

			while(!stack.isEmpty()){
				sb.append(stack.pop());
			}
		}


		return sb.toString();
	}

	public static void initMap(){
		map = new HashMap<>();
		char input = '0';
		for(int i = 0; i < 10; i++){
			map.put(i,input++);
		}
		map.put(10,'A');
		map.put(11,'B');
		map.put(12,'C');
		map.put(13,'D');
		map.put(14,'E');
		map.put(15,'F');
	}
}
