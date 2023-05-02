package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2748_피보나치수2 {
    public static int N;
    public static long[] fibo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        fibo = new long[N+1];
        fibo[1] = 1;
//        fibo[2] = 1;
        for(int i = 2; i <= N; i++){
            fibo[i] = fibo[i-1]+fibo[i-2];
        }
        System.out.println(fibo[N]);
    }
}
