package algo_202402;

public class R_P_시소짝꿍 {
	public long solution(int[] weights) {
		long answer = 0;
		long[] weightsCount = new long[1001];
		for(int w : weights){
			weightsCount[w]++;
		}


		int[][] array = {{2,1},{3,2},{4,3}};
		for(int i = 100; i <= 1000; i++){
			if(weightsCount[i]>0){
				long count = 0;
				for(long j = weightsCount[i]-1; j > 0; j--){
					count += j;
				}
				answer += count;
				for(int j = 0; j < 3; j++){
					int index = (i*array[j][0]) / array[j][1];
					int check = (i*array[j][0]) % array[j][1];
					if(check == 0 && index <= 1000){
						answer += (weightsCount[index] * weightsCount[i]);
					}
				}
			}
		}
		return answer;
	}
}
