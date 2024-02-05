package algo_202402;

import java.util.*;

public class P_광물캐기 {
	public static void main(String[] args) {
		P_광물캐기 test = new P_광물캐기();
		int[] picks = {1,3,2};
		String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
		int answer = test.solution(picks, minerals);
		int result = 12;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static int[][] energy = {{1,1,1},{5,1,1},{25,5,1}};
	public int solution(int[] picks, String[] minerals) {
		int answer = 0;
		int length = minerals.length;
		for(int i = 0; i < 3; i++){
			picks[i]= picks[i]*5;
		}
		int total = picks[0]+picks[1]+picks[2];
		length = Math.min(length,total);

		Queue<Data> pq = new PriorityQueue<>();
		for(int i = 0; i < length; i+=5){
			Data data = new Data();
			int range = i+5;
			for(int j = i; j < length && j < range; j++){
				if(minerals[j].equals("diamond")){
					data.mineral[0]++;
				}else if(minerals[j].equals("iron")){
					data.mineral[1]++;
				}else{
					data.mineral[2]++;
				}
			}
			pq.offer(data);
		}

		int index = 0;

		while(!pq.isEmpty()){
			Data data = pq.poll();
			while(picks[index] <= 0){
				index++;
			}

			for(int i = 0; i < 3; i++){
				if(picks[index] > 0){
					answer += energy[index][i]*data.mineral[i];
				}
			}
			picks[index] -=5;
		}

		return answer;
	}

	public static class Data implements Comparable<Data>{
		int[] mineral;

		public Data(){
			mineral = new int[3];
		}

		@Override
		public int compareTo(Data d){
			if(d.mineral[0] == this.mineral[0]){
				if(d.mineral[1] == this.mineral[1]){
					return d.mineral[2] - this.mineral[2];
				}
				return d.mineral[1] - this.mineral[1];
			}
			return d.mineral[0] - this.mineral[0];
		}

		@Override
		public String toString(){
			return ", mineral: " + Arrays.toString(mineral);
		}
	}
}
