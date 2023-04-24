package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1003_피보나치함수 {
    public static int[][] fibo;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        fibo = new int[41][3];
        fibo[0][0] = 1;
        fibo[0][2] = 1;
        fibo[1][1] = 1;
        fibo[1][2] = 1;
        for(int t = 0; t < T; t++){
            int input = Integer.parseInt(br.readLine());
            fibonacci(input,0);
            sb.append(fibo[input][0]).append(" ").append(fibo[input][1]).append("\n");
        }
//        System.out.println(Arrays.toString(fibo[2]));
//        System.out.println(Arrays.toString(fibo[3]));
        System.out.println(sb);
    }

    public static int[] fibonacci(int num,int idx){
        if(fibo[num][2] == 1){
            return fibo[num];
        }

        int[] data1 = fibonacci(num-1,0);
        int[] data2 = fibonacci(num-2,0);
        fibo[num][0] = data1[0]+data2[0];
        fibo[num][1] = data1[1]+data2[1];
        fibo[num][2] = 1;
//        fibo[num][0] = fibonacci(num-1,0)+fibonacci(num-2,0);
//        fibo[num][1] = fibonacci(num-1,1)+fibonacci(num-2,1);
//        fibo[num][2] = 1;

        return fibo[num];
    }
}
