package algo_202401;

import java.util.*;

public class P_2개이하로다른비트 {
	public static void main(String[] args) {
		P_2개이하로다른비트 test = new P_2개이하로다른비트();
		long[] numbers = {2,7};
		long[] answer = test.solution(numbers);
		long[] result = {3,11};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}

	public long[] solution(long[] numbers) {
		int length = numbers.length;
		long[] answer = new long[length];

		for (int i=0;i<length;i++) {
			long number = numbers[i];
			long result = getNumber(number);
			answer[i] = result;
		}

		return answer;
	}

	public static long getNumber(long number){
		char[] data = ("0"+Long.toBinaryString(number)).toCharArray();
		int length = data.length;
		if(data[length-1] == '0'){
			data[length-1] = '1';
			return changeBinaryToLong(data, length);
		}else{
			int index = length-1;
			for(; index >= 0; index--){
				if(data[index] == '0'){
					break;
				}
			}
			data[index] = '1';
			data[index+1] = '0';
			return changeBinaryToLong(data,length);
		}

	}

	public static long changeBinaryToLong(char[] data, int length){
		long temp = 1;
		long result = 0;
		for(int i = length -1; i >= 0; i--){
			result += (data[i]-'0')*temp;
			temp*=2;
		}
		return result;
	}
}
