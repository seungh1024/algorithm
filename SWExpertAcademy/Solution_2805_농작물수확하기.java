package day0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2805_농작물수확하기 {
    public static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			
			int N = Integer.parseInt(br.readLine());
			int fy = N/2;
			int ey = N/2;
			int plus = 1;
//            char[][] farm = new char [N][N];
            for(int i = 0; i < N; i++) {
            	char[] farm = br.readLine().toCharArray();
            	for(int j = fy; j<=ey; j++) {
            		result+= farm[j]-'0';
            	}
            	if(i == N/2) {
            		plus = -1;
            	}
            	fy -= plus;
            	ey += plus;
            }
            
            System.out.println("#"+test_case+" "+result);
            result = 0;

		}
	}
	

}
