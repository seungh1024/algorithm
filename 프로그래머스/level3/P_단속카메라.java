package algo_202403;

import java.util.*;

public class P_단속카메라 {
	public static int N,M;

	public int solution(int[][] routes) {
		int answer = 0;
		N = routes.length;
		M = routes[0].length;

		Data[] data = new Data[N];
		for(int i = 0; i < N; i++){
			int start = routes[i][0];
			int end = routes[i][1];
			data[i] = new Data(start,end);
		}

		Arrays.sort(data);

		Data last = data[0];
		answer = 1; // 기본 1개
		for(int i = 1; i < N; i++){
			Data now = data[i];
			if(data[i].start <= last.start){
				continue;
			}
			if(data[i].start >= last.start && data[i].start <= last.end){
				last.start = data[i].start;
			}else{
				last = data[i];
				answer++;
			}
		}


		return answer;
	}

	public static class Data implements Comparable<Data>{
		int start;
		int end;

		public Data(int start, int end){
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Data data){
			return this.end-data.end;
		}
	}
}
