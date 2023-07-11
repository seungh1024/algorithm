package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_4307_개미_silver1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int I =Integer.parseInt(st.nextToken());
            int N= Integer.parseInt(st.nextToken());
            int min = Integer.MAX_VALUE;
            int max = Integer.MAX_VALUE;
            int half = I/2;
            int closeHalf = I;
            int farHalf = 0;
            for(int i = 0; i < N; i++){
                int num = Integer.parseInt(br.readLine());
                int abs = Math.abs(half-num); //가장 가운데 있는 수를 찾음
                if(abs <= max){ // 중간과 가장 가까운 거리의 수를 찾음
                    max = abs;
                    closeHalf = num;
                }
                min = Math.min(min,Math.min(num,I-num));
            }
            int longValue = Math.max(min,I-min);
            int shortValue = Math.min(I-closeHalf,closeHalf);
            sb.append(shortValue).append(" ").append(longValue).append("\n");
        }
        System.out.println(sb);
    }
}
