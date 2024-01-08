package algo_202401;

import java.util.*;

public class P_할인행사 {
	public static void main(String[] args) {
		P_할인행사 test = new P_할인행사();
		String[] want = {"banana", "apple", "rice", "pork", "pot"};
		int[] number = {3,2,2,2,1};
		String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice",
			"pot", "banana", "apple", "banana"};
		int answer = test.solution(want, number, discount);
		int result = 3;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		Map<String,Integer> map = new HashMap<>();
		int length =want.length;
		for(int i = 0; i < length; i++){
			map.put(want[i],i);
		}
		int[] count = new int[length];
		for(int i = 0; i < 10; i++){
			Integer num = map.get(discount[i]);
			if(num != null){
				count[num]++;
			}
		}
		if(isSame(number,count,length)){
			answer++;
		}
		int dLength = discount.length;
		for(int i = 10; i <dLength; i++){
			Integer startNum = map.get(discount[i-10]);
			Integer endNum = map.get(discount[i]);
			if(startNum != null){
				count[startNum]--;
			}
			if(endNum != null){
				count[endNum]++;
			}
			if(isSame(number,count,length)){
				answer++;
			}
		}
		return answer;
	}

	public static boolean isSame(int[] number, int[] count, int length) {
		for(int i = 0; i < length; i++){
			if(number[i] != count[i]){
				return false;
			}
		}

		return true;
	}
}
