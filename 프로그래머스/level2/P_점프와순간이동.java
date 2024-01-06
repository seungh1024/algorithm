package algo_202401;

import java.util.*;

public class P_점프와순간이동 {
	public static void main(String[] args) {
		P_점프와순간이동 test = new P_점프와순간이동();
		int n = 5000;
		int result = test.solution(n);
		if (result == 5) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
	public int solution(int n) {
		int ans = 0;

		while(n != 0){
			if(n%2 == 0){
				n/=2;
			}else{
				n-=1;
				ans++;
			}
		}

		return ans;
	}
}
