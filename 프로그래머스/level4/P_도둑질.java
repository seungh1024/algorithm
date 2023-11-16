package algo_202311;

import java.util.*;

public class P_도둑질 {
    public static void main(String[] args) {
        P_도둑질 test = new P_도둑질();
        int[] money = {1,2,3,1};
        int result = 4;
        int answer = test.solution(money);
        if(result == answer) System.out.println("success");
        else System.out.println("fail");
    }

    public int solution(int[] money) {
        int answer = 0;
        answer = find(money);
        return answer;
    }

    public static int find(int[] money){
        int result = 0;
        int length = money.length;
        int[] dp = new int[length+1];
        for(int i = 2; i <= length; i++){
            dp[i] = Math.max(dp[i-2]+money[i-1], dp[i-1]);
        }
        result = Math.max(dp[length-1],dp[length]);

        dp = new int[length+1];
        dp[1] = money[0];
        for(int i = 2; i < length; i++){
            dp[i] = Math.max(dp[i-2]+money[i-1], dp[i-1]);
        }
        result = Math.max(result, dp[length-1]);

        return result;
    }
}
