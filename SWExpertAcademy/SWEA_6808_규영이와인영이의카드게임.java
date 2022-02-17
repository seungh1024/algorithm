package day0214;

import java.io.*;
import java.util.*;

public class SWEA_6808_규영이와인영이의카드게임 {
	static boolean[] check;
	static int[] number;
	static boolean[] numCheck;
	static int win;
	static int lose;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		for(int test_case = 1; test_case<=T; test_case++) {//start test cases
			check = new boolean[9];
			number = new int[9];
			numCheck = new boolean[19];
			win = 0;
			lose = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] gyu = new int[9];
			for(int i = 0; i < 9; i++) {//규영이 카드 입력
				int input = Integer.parseInt(st.nextToken());
				gyu[i] = input;
				numCheck[input] = true;
			}//규영이 카드 입력 끝
			
			int[] inyoung = new int[9]; 
			int index = 0;
			for(int i = 1; i <19; i++) {//인영이 카드 입력
				if(numCheck[i]) {//이미 규영이가 가져간 카드면 넣지 않음
					continue;
				}
				inyoung[index] = i;
				index++;
			}//인영이 카드 입력 끝
//			System.out.println(Arrays.toString(gyu));
//			System.out.println(Arrays.toString(numCheck));
//			System.out.println(Arrays.toString(inyoung));
			
			permutation(0,gyu,inyoung);
			System.out.println("#"+test_case+ " "+win+" "+lose);
		}//end test cases
		
		
	}//end main
	
	public static void permutation(int index,int[] gyu, int[]inyoung) {
		if(index >= 9) {
//			System.out.println(Arrays.toString(gyu));
//			System.out.println(Arrays.toString(number));
			int gyuPoint = 0;
			int inPoint = 0;
			for(int i = 0; i<9; i++) {
				if(gyu[i] > number[i]) {
					gyuPoint += gyu[i]+number[i];
				}else {
					inPoint += gyu[i]+number[i];
				}
			}
			if(gyuPoint>inPoint) {
				win++;
			}else {
				lose++;
			}
			return;
		}

		
		for(int i = 0; i < 9; i++) {
			if(!check[i]) {
				check[i] = true;
				number[index] = inyoung[i];
				permutation(index+1,gyu,inyoung);
				check[i] =false;
			}
		}
	}
}
//총 362880 개
