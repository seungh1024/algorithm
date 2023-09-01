package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_14864_줄서기 {
    public static int N, M;
    public static int[] card;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        card = new int[N+1];
        for(int i = 1; i <= N; i++){
            card[i] = i;
        }
        for(int i = 0; i < M; i++){
            st= new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            card[x]++;
            card[y]--;
        }
//        System.out.println(Arrays.toString(card));
        System.out.println(check());
    }
    public static String check(){
        boolean[] visited = new boolean[N+1];
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if(!visited[card[i]]){
                visited[card[i]] = true;
            }else{
                return "-1";
            }
            sb.append(card[i]).append(" ");
        }
        return sb.toString();
    }
}
