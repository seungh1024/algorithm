package algoSolveAgain;

import java.io.*;
import java.util.*;

public class BJ_15661_링크와스타트 {
	
	public static boolean[] check;
	public static int N;
	public static int[][] array;
	public static int result = Integer.MAX_VALUE;

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		check = new boolean[N];
		array = new int[N][N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		subset(0,0);
		System.out.println(result);
		
	}
	
	public static void subset(int start, int cnt) {
		if(start ==N) {
			makeResult();
			return;
		}
		
		check[start] = true;
		subset(start+1,cnt+1);
		check[start] = false;
		subset(start+1,cnt);
	}
	
	public static void makeResult() {
		ArrayList<Integer> startTeam = new ArrayList<>();
		ArrayList<Integer> linkTeam = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			if(check[i]) {
				startTeam.add(i);
			}
			else {
				linkTeam.add(i);
			}
		}
		
		int startSum = sumPoint(startTeam);
		int linkSum = sumPoint(linkTeam);
		result = Math.min(Math.abs(startSum-linkSum), result);
	}
	
	public static int sumPoint(ArrayList<Integer> list) {
		int sum = 0;
		int size = list.size();
		
		for(int i = 0; i < size-1; i++) {
			for(int j = i+1; j < size; j++) {
				sum += array[list.get(i)][list.get(j)];
				sum += array[list.get(j)][list.get(i)];
			}
		}
		
		return sum;
	}
}
