package algo_202402;

import java.util.*;

public class P_우박수열정적분 {
	public double[] solution(int k, int[][] ranges) {
		Queue<Double> q = new ArrayDeque<>();

		int x = 0;
		double y = (double)k;
		double num = y;
		int temp = 10;
		while(num > 1){
			if(num % 2 == 0){
				num /= 2;
			}else{
				num = num*3+1;
			}
			double sum = Math.abs(num-y)/2 + Math.min(y,num);
			// System.out.println(sum + ", num: "+num + ", y: "+ y);
			q.offer(sum);
			y = num;
		}
		// System.out.println(q);
		int size = q.size();
		double[] data = new double[size+1];
		data[1] = q.poll();
		for(int i = 2; i <= size; i++){
			data[i] = q.poll() + data[i-1];
		}
		// System.out.println(Arrays.toString(data));

		int length = ranges.length;
		double[] answer = new double[length];
		for(int i = 0; i < length; i++){
			int[] range = ranges[i];
			if(size+range[1] >= range[0]){
				answer[i] = data[size+range[1]]-data[range[0]];
			}else{
				answer[i] = -1;
			}

		}


		return answer;
	}
}
