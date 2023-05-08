package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1010_다리놓기 {
    public static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp = new long[30];
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long left = Long.parseLong(st.nextToken());
            long right = Long.parseLong(st.nextToken());



            long a = right;
            long num1 = 1;
            long b = left;
            long num2 = 1;
            for(int i = 0; i < left; i++){
                num1 = num1*a;
                a--;
                if(num1%b == 0){
                    num1 = num1/b;
                }else{
                    num2= num2*b;
                }
                b--;
            }
//            System.out.println(num1);
//            System.out.println(num2);
            System.out.println(num1/num2);

        }

    }
}
