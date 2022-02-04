package day0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1208_Flatten {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//start test
		for(int test_case = 1; test_case<=10; test_case++) {
			List<Integer> box = new ArrayList<>();
			// moving count
			int num = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {//start input box
				 box.add(Integer.parseInt(st.nextToken()));
			}//end input box
//			System.out.println(box.toString());
			Collections.sort(box);
//			System.out.println(box.toString());
			
			int head = 0; //head index 
			int tail = 99; //tail index
			for(int i = 0; i < num; i++) {//start moving
				if(box.get(head) < box.get(tail)) {
					box.set(head, box.get(head)+1);
					box.set(tail, box.get(tail)-1);
				}
				if(box.get(head)>box.get(head+1)) {
					while(box.get(head)>box.get(head+1))
						head +=1;
				}
				else if(head >0 && box.get(head-1)<=box.get(head)) {
					while(head >0 && box.get(head-1)<=box.get(head))
						head -=1;
				}
				if(box.get(tail)<box.get(tail-1)) {
					while(box.get(tail)<box.get(tail-1))
						tail-=1;
				}
				else if(tail <99 && box.get(tail+1)>=box.get(tail)) {
					while(tail <99 && box.get(tail+1)>=box.get(tail))
						tail+=1;
				}
			}//end moving
//			System.out.println(box.get(tail));
//			System.out.println(box.get(head));
//			System.out.println(box.toString());
//			Collections.sort(box);
//			System.out.println(box.get(99)-box.get(0));
			System.out.println("#"+test_case+ " "+(box.get(tail)-box.get(head)));
			
		}//end test
	
	}


