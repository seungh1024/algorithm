package algo_202401;

import java.util.*;

public class P_테이블해시함수 {
	public static void main(String[] args) {
		P_테이블해시함수 test = new P_테이블해시함수();
		int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
		int col = 2;
		int row_begin = 2;
		int row_end = 3;
		int result = 4;
		int answer = test.solution(data, col, row_begin, row_end);
		if (result == answer) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(int[][] data, int col, int row_begin, int row_end) {
		int answer = 0;

		Arrays.sort(data,(o1,o2)->{
			if(o1[col-1] == o2[col-1]){
				return o2[0]-o1[0];
			}
			return o1[col-1] - o2[col-1];
		});

		// for(int[] d : data){
		//     System.out.println(Arrays.toString(d));
		// }

		for(int i = row_begin-1; i < row_end; i++){
			int sum = 0;
			for(int num : data[i]){
				sum += (num%(i+1));
			}
			if(answer != 0){
				answer = answer^sum;
			}else{
				answer = sum;
			}
			// System.out.println("sum: "+sum + ", answer: "+answer + ", data: "+Arrays.toString(data[i]));
		}

		return answer;
	}
}
