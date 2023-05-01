package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2512_예산 {
    public static int N,M;
    public static int[] data;
    public static int max;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
            max = Math.max(data[i],max);
        }
        M = Integer.parseInt(br.readLine());
        find();
    }
    public static void find(){
        long start = 1;
        long end = max;
        long result = 0;
        while(start <= end){
            long mid = (start+end)/2;
            long sum = 0;
            for(int i = 0; i < N; i++){
                if(data[i] < mid){
                    sum += data[i];
                }else{
                    sum+=mid;
                }
            }
//            System.out.println("sum: "+sum + " , mid: "+mid);
            if(sum > M){
                end = mid-1;
            }else{
                start = mid+1;
                result = Math.max(result,mid);
            }
        }
//        System.out.println(start);
        System.out.println(result);
    }
}
