package day0203;

import java.util.Scanner;

public class Solution_1289_원재의메모리복구 {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();
		// TODO Auto-generated method stub
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			char[] data = sc.nextLine().toCharArray();
            int check = 0;
            int count = 0;
            for(char bit : data){
                if(bit-'0' != check){
                    count ++;
                    if(check == 0){
                        check = 1;
                    }else{
                        check = 0;
                    }
                }
            }
            
            System.out.println("#" + test_case + ' ' + count);

		}
	}

}
