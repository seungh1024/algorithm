package day0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1954_달팽이숫자 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
        int[] mx = {0,1,0,-1};
        int[] my = {1,0,-1,0};
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n =  Integer.parseInt(br.readLine());;
            int[][] snail = new int[n][n];
            int count = 0;
            int x = 0;
            int y = 0;
            snail[0][0] = 1;
            int size = n*n;
            for(int j = 2; j <= size; j++){
                x += mx[count%4];
                y += my[count%4];
                if(x<0 || x >= n || y < 0 || y >= n || snail[x][y] != 0){
                    x -= mx[count%4];
                    y -= my[count%4];
                    count ++;
                    x += mx[count%4];
                    y += my[count%4];
                }
                snail[x][y] = j;
			}//end moving
       		System.out.println("#"+test_case);
			for(int j =0; j < n; j++){
            	for(int k = 0; k < n; k++){
               		System.out.printf("%d ",snail[j][k]);
            	}
            	System.out.println();
        	}
        }
	}

}

