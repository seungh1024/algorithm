package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_11054_가장긴바이토닉부분수열 {
    public static int N;
    public static int[] data;
    public static int[][] dp;
    public static int idx;
    public static int[] array;
    public static int length;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N+1];
        dp = new int[2][N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<= N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        find();
//        printDp();

    }
    public static void find(){
        idx = 1;
        array = new int[N+1];
        length = 0;
        for(int i = 1; i <= N; i++){
            dp[0][i] = where(data[i]);
        }
//        System.out.println(Arrays.toString(array));
        idx = 1;
        array = new int[N+1];
        length = 0;
        for(int i = N; i >0; i--){
            dp[1][i] = where(data[i]);
        }
//        System.out.println(Arrays.toString(array));

        int result = 0;
        for(int i = 1; i <= N; i++){
            result  = Math.max(dp[0][i]+dp[1][i],result);
        }
        System.out.println(result-1);

    }
    public static int where(int num){
        int left = 1;
        int right = idx;
        if(num > array[idx-1]){
            array[idx] = num;
            idx++;
            return ++length;
        }
        while(left < right){
            int mid = (left+right)/2;
            if(num > array[mid]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        array[left] = num;
//        System.out.println("data: "+num + ", left: "+left + ", idx: "+idx);
        return length;
    }
    public static void printDp(){
        for(int i = 0; i <2; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
