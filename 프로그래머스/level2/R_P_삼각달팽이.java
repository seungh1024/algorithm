package algo_202402;

public class R_P_삼각달팽이 {
	public int[] solution(int n) {
		int size = 0;
		for(int i = 1; i <= n; i++){
			size += i;
		}
		System.out.println(size);

		int[] answer = new int[size];

		boolean d = true;
		int index = 0;
		int jump = 1;

		for(int i = 1; i <= size; i++){
			answer[index] = i;
			if(d){ // 정방향
				if(index + jump < size && answer[index+jump] == 0){
					index += jump;
					jump++;
				}else if(index + 1 < size && answer[index+1] == 0){
					index++;
				}else{
					d = !d;
					index -= jump;
					jump--;
				}
			}else{ // 역방향
				if(index - jump >= 0 && answer[index-jump] == 0){
					index -= jump;
					jump--;
				}else{
					d = !d;
					index += jump;
					jump++;
				}
			}

		}

		return answer;
	}
}
