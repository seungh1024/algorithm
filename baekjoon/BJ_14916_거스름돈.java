package algo.study;

import java.io.*;
import java.util.*;

public class BJ_14916_거스름돈 {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		while(n>=1) {
			if(n == 3 || n == 1) {
				count = -1;
				break;
			}
			if(n%5 == 0) {
				n-=5;
				count++;
			}else if(n%2 == 0) {
				n-= 2;
				count++;
			}else {
				if(n>=5) {
					n-=5;
					count++;
				}else {
					n-=2;
					count++;
				}
			}
		}
		
		System.out.println(count);
		
	}

}
