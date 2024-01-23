package algo_202401;

import java.util.Arrays;

public class P_연속된부분수열의합 {
	public static void main(String[] args) {
		P_연속된부분수열의합 test = new P_연속된부분수열의합();
		int [] sequence = {1, 1, 1, 2, 3, 4, 5};
		int k = 5;
		int[] answer = test.solution(sequence, k);
		int[] result = {6, 6};
		if (Arrays.equals(result, answer)) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int[] solution(int[] sequence, int k) {
		int[] answer = new int[2];
		int left = 0;
		int right = 0;
		int length = sequence.length;
		int size = length;

		int sum = 0;
		for(; right < length; right++){

			sum += sequence[right];

			while(sum > k && left <= right){
				sum -= sequence[left++];
			}

			if(sum == k){
				if(right-left < size){
					answer[0] = left;
					answer[1] = right;
					size = right-left;
				}
			}

			// System.out.println("left: "+left + ", right: "+right);
		}
		// System.out.println("left: "+left + ", right: "+right);
		return answer;
	}
}
