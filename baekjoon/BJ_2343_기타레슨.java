package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2343_기타레슨 {
    public static int N,M;
    public static int[] data;
    public static int sum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N];
        sum = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
            sum+=data[i];
        }

        find();
    }

    public static void find(){
        int start = 1;
        int end = sum;
        while(start<=end){
            int mid = (start+end)/2;

            int idx= 0;
            for(int i = 0; i < M; i++){
                int value = mid;
                while(true){
                    if(idx < N && value >= data[idx]){
                        value -= data[idx];
//                        System.out.println(data[idx]);
                        idx++;
                    }else{
                        break;
                    }
                }
//                System.out.println("////");
            }

            if(idx >= N){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        System.out.println(start);
    }
}
