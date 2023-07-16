package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_1034_램프 {
    public static int N,M,K;
    public static int[][] data;
    public static boolean[] visited; // 행 방문 체크
    public static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[N][M];
        for(int i = 0; i < N; i++){
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                data[i][j] = input[j]-'0';
            }
        }
        K = Integer.parseInt(br.readLine());
        find();
    }
    public static void find(){
        result = 0;
        visited = new boolean[N];
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;

            int lamp = 0;
            for(int j = 0; j < M; j++){
                if(data[i][j] == 0) lamp++;
            }

            int cnt = 0;
            for(int x = 0; x < N; x++){
                boolean check = false;
                for(int y = 0; y < M; y++){
                    if(data[i][y] != data[x][y]){
                        check = true;
                        break;
                    }
                }
                if(!check){
                    cnt++;
                    visited[x] = true;
                }
            }
//            System.out.println("i: "+i + ", cnt: "+cnt);
//            System.out.println(lamp);
            if(lamp<=K && (K-lamp)%2==0){
                result = Math.max(result,cnt);
            }
        }
        System.out.println(result);
    }
}
