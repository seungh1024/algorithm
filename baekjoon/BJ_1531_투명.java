package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_1531_투명 {
    public static int[][] picture;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        picture = new int[101][101];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());
            mosaic(lx,ly,rx,ry);
        }
        int result = 0;
        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++){
                if(picture[i][j] > M){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    private static void mosaic(int lx, int ly, int rx, int ry) {
        for(int i = lx; i <= rx; i++){
            for(int j = ly; j <= ry; j++){
                picture[i][j]++;
            }
        }
    }
}
