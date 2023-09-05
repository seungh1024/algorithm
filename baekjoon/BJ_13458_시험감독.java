package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_13458_시험감독 {
    public static int N;
    public static int[] A;
    public static int B,C;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        long result = 0;
        for(int i = 0; i < N; i++){
            result++;
            if(A[i] > B){
                A[i]-=B;
                result += A[i]/C;
            }else{
                A[i] = 0;
            }

            if(A[i]%C>0){
                result++;
            }
        }
        System.out.println(result);
    }
}
