package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1759_암호만들기 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		ArrayList<String> data = new ArrayList<>();
		//문자 입력
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i <C; i++) {
			data.add(st.nextToken());
		}
		
		int check = 0;
		//정렬
		Collections.sort(data);
//		System.out.println(data.toString());
		StringBuilder sb = new StringBuilder();
		permutation(L,C,0,0,data,"",0,0);
	}
	
	public static void permutation(int L,int C,int cnt,int start,ArrayList<String> data,String s,int check,int aeiou) {
		if(cnt == L) {
			if(check>=2 && aeiou >=1) {
				System.out.println(s);
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
			String alpha = data.get(i);
			if("bcdfghjklmnpqrstvwxyz".contains(alpha)) {
//				check+=1;
				permutation(L,C,cnt+1,start+1,data,s+alpha,check+1,aeiou);
				System.out.println("check: "+check+","+alpha);
//				System.out.println(alpha);
			}else if("aeiou".contains(alpha)) {
				permutation(L,C,cnt+1,start+1,data,s+alpha,check,aeiou+1);
				System.out.println("aeiou: "+aeiou);
			}
			
			start++; //한 사이클 돌고 다음 사이클로 넘어갈 때 i값이 증가하는데 start는 고정이
			//i값 증가만큼 올려줘야 함
//			System.out.println("///////////");
		}
	}

}
