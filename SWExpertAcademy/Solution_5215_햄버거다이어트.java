package SWExpertAcademy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_5215_햄버거다이어트 {
	public static List<int[]> list = new ArrayList<>();
	public static int result = 0; //만족도
	public static boolean[] check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//test case
		
		for(int test_case = 1; test_case<=T; test_case++) {	
			int N = sc.nextInt();//menu num
			int L = sc.nextInt();//limit cal
			check = new boolean[N];
			//input
			for(int i = 0; i < N; i++) {
				int[] point = new int[2];//T,K
				point[0] = sc.nextInt();
				point[1] = sc.nextInt();
				list.add(point);
				
			}
			
			
			subset(0,N,L,0,0);
			System.out.println("#"+test_case+" "+result);
//			for(int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(list.get(i)));
//			}
			result = 0;
			list.clear();
		}
		
	}
	
	public static void subset(int cnt,int N,int L,int totalT,int totalC) {
//		System.out.println(result);
		if(totalC >L) {
			return;
		}
		if(cnt == N) {
			if(totalC <= L) {
//				System.out.println(Arrays.toString(check));
				result = totalT>=result?totalT:result;
//				System.out.println("total: "+totalT);
			}
			return;
		}
		
		check[cnt] = true; // 선택함
//		System.out.println(list.get(cnt)[0]+" / "+cnt);
		subset(cnt+1,N,L,totalT+list.get(cnt)[0],totalC+list.get(cnt)[1]);
		check[cnt] = false;
		subset(cnt+1,N,L,totalT,totalC);
		
	}

}

//5 1000
//100 200
//300 500
//250 300
//500 1000
//400 400

