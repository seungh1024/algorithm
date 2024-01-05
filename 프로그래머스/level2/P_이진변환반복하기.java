package algo_202401;

import java.util.*;

public class P_이진변환반복하기 {
	public static void main(String[] args) {
		P_이진변환반복하기 test = new P_이진변환반복하기();
		int[] result = test.solution("110010101001");
		if (Arrays.equals(result, new int[] {3, 8})) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	public int[] solution(String s) {
		int[] answer = new int[2];

		while(true){
			char[] data = s.toCharArray();
			int size = data.length;
			int count = 0;
			for(char c : data){
				if(c == '0'){
					count++;
				}
			}
			answer[0]++;
			answer[1]+=count;
			size-=count;
			s = Integer.toBinaryString(size);

			if(s.equals("1")){
				break;
			}

		}
		return answer;
	}
}
