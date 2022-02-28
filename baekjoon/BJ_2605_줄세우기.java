package day0227;

import java.io.*;
import java.util.*;

public class BJ_2605_줄세우기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= N; i++) {
			int studentNum = Integer.parseInt(st.nextToken());
			int point = list.size() - studentNum;
			list.add(point,i);
		}
		for(int i = 0; i < N; i++) {
			System.out.print(list.get(i)+" ");
			
		}
		
	}

}
