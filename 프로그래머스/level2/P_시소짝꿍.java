package algo_202401;

import java.util.*;

public class P_시소짝꿍 {
	public static void main(String[] args) {
		P_시소짝꿍 test = new P_시소짝꿍();
		int[] weights = {100, 180, 360, 100, 270};
		long answer = test.solution(weights);
		long result = 4;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public long solution(int[] weights) {
		long answer = 0;
		int length = 1000;
		Arrays.sort(weights);
		Map<Double,Long> map = new HashMap<>();
		double[] x = {1.0,2.0,1.0, 3.0};
		double[] y = {1.0,3.0,2.0, 4.0};
		for(int w : weights){
			// System.out.println(w);
			for(int i = 0; i < 4; i++){
				double d = w*x[i]/y[i];
				// System.out.println("d: "+d + ", w: "+w + ", x: "+x[i] + ", y: "+y[i]);
				Long count = map.get(d);
				if(count != null){
					answer += count;
				}
			}
			double d = w*1.0;
			Long count = map.get(d);
			if(count == null){
				map.put(d,1L);
			}else{
				map.put(d,count+1L);
			}
			// System.out.println("answer: "+answer);
		}
		// System.out.println(map);

		return answer;
	}
}
