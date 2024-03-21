package algo_202403;

import java.util.*;

public class P_다단계칫솔판매 {
	public static Map<String,Integer> map;
	public static Map<Integer,Integer> parent;
	public static int N;
	public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		map = new HashMap<>();
		N = enroll.length;
		for(int i = 1; i <= N; i++){
			map.put(enroll[i-1],i);
		}
		parent = new HashMap<>();

		for(int i = 0; i < N; i++){
			String ref = referral[i];
			if(ref.equals("-")){ // center
				parent.put(i+1,0);
				continue;
			}
			int index = map.get(ref); // 부모 인덱스
			parent.put(i+1,index);
		}

		int length = amount.length;
		int[] money = new int[N+1];
		for(int i = 0; i < length; i++){
			// amount[i]*=100;
			int index = map.get(seller[i]);
			int plusMoney = amount[i]*100;
			while(true){
				money[index] += plusMoney;
				plusMoney = plusMoney/10;
				money[index] -= plusMoney;
				index = parent.get(index);
				if(plusMoney == 0 || index == 0){
					break;
				}

			}
		}

		int[] answer = new int[N];
		for(int i = 0; i < N; i++){
			int index = map.get(enroll[i]);
			answer[i] = money[index];
		}
		return answer;
	}
}
