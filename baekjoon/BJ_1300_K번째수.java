package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1300_K번째수 {
    public static long N,k;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
//        while(k != -1){
            k = Long.parseLong(br.readLine());
            find();
//        }

//        System.out.println(Long.MAX_VALUE);
    }

    public static void find(){
        long start = 1;
        long end = k;
        int result = 0;

        while(start<end){
            long mid = (start+end)/2;

            int sum = 0;
            for(int i = 1; i <= N; i++){
                long min = Math.min(mid/i , N);
                sum += min;
            }

            if(sum >= k){
                end = mid;
            }else{
                start = mid +1;
            }
        }
        System.out.println(start);
    }
}
