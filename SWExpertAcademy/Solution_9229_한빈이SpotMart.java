package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_한빈이SpotMart {
//	public static boolean[] check;
	public static int[] result;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case<=T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
//			check = new boolean[N]; //선택됐는지 체크를 위한 배열
			int[] data = new int[N]; //과자 봉지 무게
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				data[i] = Integer.parseInt(st.nextToken());
//				System.out.println(Arrays.toString(data));
			}
			result = new int[] {-1};
			com(0,0,N,M,0,data);
			System.out.println("#"+ test_case+" "+result[0]);
		}
	}
	
	public static void com(int index,int cnt,int N,int M, int sum,int[] data) {
		
		if(cnt == 2 && sum <=M) {
			result[0] = result[0]>sum?result[0]:sum;
//			System.out.println("#"+ test_case+" "+result);
//			System.out.println(Arrays.toString(check));
			return;
		}
		if(index == N || sum >M) {
			return;
		}
		
		
//		check[index] = true;
		com(index+1,cnt+1,N,M,sum+data[index],data);
//		check[index] = false;
		com(index+1,cnt,N,M,sum,data);
		
	}

}
