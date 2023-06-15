package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_3020_개똥벌레 {
    public static int N,H;
    public static int[] bottom;
    public static int[] top;
    public static int min,cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        top = new int[H+2];
        bottom = new int[H+1];
        int length = N/2;
        for(int i = 0; i < length; i++){
            bottom[Integer.parseInt(br.readLine())]++;
            top[H-Integer.parseInt(br.readLine())+1]++;
        }
        makeSum();
        find();
//        System.out.println(Arrays.toString(bottom));
//        System.out.println(Arrays.toString(top));
        System.out.println(min + " " +cnt);
    }
    public static void makeSum(){
        for(int i = 1; i <= H; i++){
            bottom[i] += bottom[i-1];
        }
        for(int i = H-1; i >= 1; i--){
            top[i] += top[i+1];
        }
    }
    public static void find(){
        min = Integer.MAX_VALUE;
        cnt = 0;
        for(int i = 1; i <= H; i++){
            int sum = bottom[H]-bottom[i-1] + top[1]-top[1+i];
//            System.out.println("sum: "+sum);
            if(sum < min){
                min = sum;
                cnt = 1;
            }else if(sum == min){
                cnt++;
            }
        }
    }
}
