package algo_202311;

import java.io.*;
import java.util.*;

public class RE_BJ_10837_동전게임 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < C; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M= Integer.parseInt(st.nextToken());
            int N= Integer.parseInt(st.nextToken());
            int result = makeResult(K,M,N);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    public static int makeResult(int K, int M, int N){
        int result = 0;
        if(M>N){
            if(M-(K-M+1+N) < 2){
                result = 1;
            }
        }else if(M < N){
            if(N-(K-N+M) < 2){
                result = 1;
            }
        }else{
            result = 1;
        }

        return result;
    }
}
