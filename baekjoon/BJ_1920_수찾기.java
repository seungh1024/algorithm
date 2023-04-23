package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1920_수찾기 {
    public static int N,M;
    public static int[] A;
//    public static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M ;i++){
            int input = Integer.parseInt(st.nextToken());
            if(find(input)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }
    }

    public static boolean find(int num){
        int start = 0;
        int end = N-1;
        while(start<end){
            int mid = (start+end)/2;

            if(A[mid] >= num){
                end = mid;
            }else{
                start = mid +1;
            }
        }
//        System.out.println("start: "+start + " , A : "+A[start]+ ", num: "+num);
        if(A[start] == num){
            return true;
        }else{
            return false;
        }
    }
}
