package algo_202311.kakaorecruitment2023;

import java.util.*;

public class P_택배배달과수거하기 {
    public static void main(String[] args) {
        P_택배배달과수거하기 test = new P_택배배달과수거하기();
        int cap = 4;
        int n = 5;
        int[] deliveries = {1,0,3,1,2};
        int[] pickups = {0,3,0,4,0};
        long result = 16;
        long answer = test.solution(cap,n,deliveries,pickups);
        if(answer == result){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int d = 0;
        int p = 0;

        for(int i = n-1; i >= 0; i--){
            d-=deliveries[i];
            p-=pickups[i];

            int mul = 0;
            while(d< 0 || p < 0){
                d+=cap;
                p+=cap;
                mul++;
            }
            answer += ((i+1)*mul*2);
            // System.out.println(answer);
        }

        return answer;
    }
}
