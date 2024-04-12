package algo_202403;

import java.util.*;

public class P_이중우선순위큐 {
	public int[] solution(String[] operations) {
		int[] answer = {0,0};

		List<Integer> list = new ArrayList<>();
		int left = 0;
		int right = 0;
		for(String o : operations){
			String[] input = o.split(" ");
			int num = Integer.parseInt(input[1]);
			if(input[0].equals("I")){
				list.add(num);
				right++;
			}else{
				if(right == 0) continue;
				if(num == 1){ // 최댓값 삭제
					Collections.sort(list);
					list.remove(right-1);
					right--;
				}else{ // 최솟값 삭제
					list.remove(0);
					right--;
				}
			}
		}
		if(list.size() > 0){
			int max = 0;
			int min = Integer.MAX_VALUE;

			for(int i : list){
				max = Math.max(max,i);
				min = Math.min(min,i);
			}
			answer = new int[]{max,min};
		}


		return answer;
	}
}
