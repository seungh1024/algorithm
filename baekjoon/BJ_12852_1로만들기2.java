package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_12852_1로만들기2 {
    public static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        dp = new int[X+1];
        find(X,0);
        System.out.println(dp[1]);
//        System.out.println(Arrays.toString(dp));

        int index = 1;
        StringBuilder sb = new StringBuilder();
        sb.append(index).append(" ");

        while(true){
            if(index*3 <= X && dp[index*3]+1 == dp[index]){
                index = index*3;
                sb.insert(0," ").insert(0, index);
//                sb.append(index).append(" ");
            }else if(index*2 <= X && dp[index*2]+1 == dp[index]){
                index = index*2;
//                sb.append(index).append(" ");
                sb.insert(0," ").insert(0, index);
            }else if(index+1 <= X && dp[index+1]+1 == dp[index]){
                index = index+1;
//                sb.append(index).append(" ");
                sb.insert(0," ").insert(0, index);
            }


            if(index == X) break;
        }
        System.out.println(sb);
    }

    public static void find(int index, int count){
        for(int i = 2; i <= 3; i++){
            if(index>=i && index%i == 0){
                if(dp[index/i] == 0){
                    dp[index/i] = count+1;
                    find(index/i, count+1);
                }else if(dp[index/i] > count+1){
                    dp[index/i] = count+1;
                    find(index/i, count+1);
                }
            }
        }
        if(index-1 >0){
            if(dp[index-1] == 0){
                dp[index-1] = count+1;
                find(index - 1, count+1);
            }else if(dp[index - 1] > count+1){
                dp[index - 1] = count+1;
                find(index- 1, count+1);
            }
        }
    }
}
