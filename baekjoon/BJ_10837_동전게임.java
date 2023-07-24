package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_10837_동전게임 {
    public static int K,C,M,N, gap;
    public static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());
        sb= new StringBuilder();
        for(int i = 0 ; i < C; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            find();
        }
        System.out.println(sb);
    }

    public static void find(){
        if(M == N){
            sb.append(1);
        }else if(M < N){
            gap = K-N;
            if(gap+M+2 > N){
                sb.append(1);
            }else{
                sb.append(0);
            }

        }else if(M > N){
            gap = K-M;
            if(gap + N +2 >= M){
                sb.append(1);
            }else{
                sb.append(0);
            }

        }
        sb.append("\n");
    }
}
