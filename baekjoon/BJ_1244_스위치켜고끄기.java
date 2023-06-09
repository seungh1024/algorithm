package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1244_스위치켜고끄기 {
    public static int N, M;
    public static int[] data;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        M= Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(sex == 1){
                boy(num);
            }else{
                girl(num);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(data[i]).append(" ");
            if(i %20 == 0){
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
    public static void boy(int num){
        for(int i = num; i <= N; i+=num){
            data[i] = (data[i]+1)%2;
        }
    }
    public static void girl(int num){
        int left = num;
        int right = num;
        while(true){
            left -=1;
            right +=1;
            if(left <=0 || right >N || data[left] != data[right]) break;
        }
        left += 1;
//        System.out.println("left:"+left+", right: "+right);
        for(int i = left; i < right; i++){
            data[i] = (data[i]+1)%2;
        }
    }
}
