package algo_202401;

import java.util.Arrays;

public class P_n2배열자르기 {
	public static void main(String[] args) {
		P_n2배열자르기 test = new P_n2배열자르기();
		int n = 3;
		long left = 2;
		long right = 5;
		int[] answer = test.solution(n, left, right);
		int[] result = {3,2,2,3};
		if (Arrays.equals(answer, result)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int[] solution(int n, long left, long right) {

		int index = 0;
		int size = (int)(right-left)+1;
		int[] data = new int[size];

		for(long i = left; i <= right; i++){
			int x = (int)(i/n);
			int y = (int)(i%n);
			if(y < x){
				data[index++] = x+1;
			}else{
				data[index++] = y+1;
			}
		}


		return data;
	}
}
