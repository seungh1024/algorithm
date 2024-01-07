package algo_202401;

import java.util.*;

public class P_연속부분수열합의개수 {
	public static void main(String[] args) {
		P_연속부분수열합의개수 test = new P_연속부분수열합의개수();
		int[] elements = {7,9,1,1,4};
		int answer = test.solution(elements);
		int result = 18;
		if (result == answer) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(int[] elements) {
		int answer = 0;

		Set<Integer> set = new HashSet<>();
		int length = elements.length;
		int[] data = new int[length*2];
		int sum = 0;
		for(int i = 0; i < length; i++){
			data[i] = elements[i];
			sum += data[i];
		}
		set.add(sum);
		int doubleLength = length*2;
		for(int i = length; i < doubleLength; i++){
			data[i] = elements[i-length];
		}

		for(int i = 0; i < length; i++){
			sum = 0;
			int size = i+length-1;
			for(int j = i; j < size; j++){
				sum += data[j];
				set.add(sum);
			}
		}
		answer = set.size();

		return answer;
	}
}
