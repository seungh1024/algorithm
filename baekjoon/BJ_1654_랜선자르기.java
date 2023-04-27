package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1654_랜선자르기 {
    public static int K,N;
    public static long[] data;
    public static long min,max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        data = new long[K];
        min = Long.MAX_VALUE;
        max = 0;

        for(int i = 0; i < K; i++){
            data[i] = Long.parseLong(br.readLine());
            min = Math.min(min,data[i]);
            max = Math.max(max,data[i]);
        }

        if(N == 1){
            System.out.println(data[0]);
        }else{
            find();
        }

    }
    public static void find(){
        long start = 0;
        long end = max;
        long result = 0;
        while(start<end){
            long mid = (start+end)/2;
            long cnt = 0;
            for(int i = 0; i < K; i++){
                cnt += data[i] / mid;
            }
//            System.out.println("start:"+start + ", end: "+end + ", mid: "+mid +" ,cnt: "+cnt);
            if(cnt < N ){
                end = mid;
            }
            else{
                start = mid+1;
                result = Math.max(result,mid);
            }

        }
        long cnt = 0;
        for(int i = 0; i < K; i++){
            cnt += data[i] / start;
        }
        if(cnt >= N){
            result = Math.max(result,start);
        }
        System.out.println(result);
//        System.out.println(start);
    }
}
//4 8
//802
//743
//457
//539
