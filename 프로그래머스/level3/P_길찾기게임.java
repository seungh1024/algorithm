package algo_202403;

import java.util.*;

public class P_길찾기게임 {
	public static int top;
	public static int leftIndex;
	public static int rightIndex;

	public int[][] solution(int[][] nodeinfo) {
		int length = nodeinfo.length;
		Data[] input = new Data[length];
		for(int i = 0; i < length; i++){
			input[i] = new Data(nodeinfo[i][0],nodeinfo[i][1],i+1);
		}
		Arrays.sort(input);
		// System.out.println(Arrays.toString(input));



		int[][] answer = new int[2][length];

		leftIndex = 0;
		rightIndex = 0;
		find(0,length,length,answer,input);
		System.out.println(Arrays.toString(answer[0]));
		System.out.println(Arrays.toString(answer[1]));

		return answer;
	}

	public static void find(int start, int end, int length, int[][] answer, Data[] input){
		if(start > end || leftIndex >= length || rightIndex >= length){
			return;
		}

		// System.out.println("start = "+start + ", end = "+end);
		Data now = null;
		int maxY = 0;
		int myIndex = 0;
		for(int i = start; i < end; i++){
			if(maxY <= input[i].y){
				maxY = input[i].y;
				now = input[i];
				myIndex = i;
			}
		}
		// System.out.println("myIndex = "+myIndex);
		if(now == null) return;
		answer[0][leftIndex++] = now.num;
		find(start,myIndex,length,answer,input);
		find(myIndex+1,end,length,answer,input);
		answer[1][rightIndex++] = now.num;
	}





	public static class Data implements Comparable<Data>{
		int x;
		int y;
		int num;

		public Data(int x, int y, int num){
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public int compareTo(Data d){
			return this.x-d.x;
		}

		@Override
		public String toString(){
			return "x = "+x + ", y = "+y + ", num = "+num;
		}
	}
}
