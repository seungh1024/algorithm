package algo_202402;

import java.util.*;

public class P_N_Queen {
	public static void main(String[] args) {
		P_N_Queen test = new P_N_Queen();
		int n = 4;
		int answer = test.solution(n);
		int result = 2;
		if (answer == result) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public static int result;
	public static int[] data;
	public static boolean[] visited;

	public int solution(int n) {
		int answer = 0;
		result = 0;
		data = new int[n];
		visited = new boolean[n+1];
		find(n,0,0);
		System.out.println(result);
		return result;
	}

	public static void find(int n, int index, int count){

		if(count == n){
			// System.out.println(Arrays.toString(data));
			result++;
			return;
		}
		if(index >= n){
			// System.out.println("?");
			return;
		}



		for(int i = 1; i <= n; i++){ // 열 기준. 어떤 열이 가능한지(index,i)
			boolean check = false;
			// if(visited[i]) continue;
			for(int j = 0; j < index; j++) { // 다른 행 탐색 (j,data[j])
				if(i == data[j] || Math.abs(index-j) == Math.abs(i-data[j])){
					check = true;
					break;
				}
			}
			if(!check){

				data[index] = i;
				// System.out.println("index: "+index + ", i: "+ i + ", data: "+ Arrays.toString(data));
				visited[i] = true;
				find(n,index+1,count+1);
				visited[i] = false;
			}
		}
	}
}
