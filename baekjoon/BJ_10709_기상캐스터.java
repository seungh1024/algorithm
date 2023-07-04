package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_10709_기상캐스터 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < H; i++){
            char[] input = br.readLine().toCharArray();
            int cnt = 0;
            for(int j = 0; j < W; j++){
                if(input[j] == 'c'){
                    cnt = 1;
                    sb.append(0).append(" ");
                    continue;
                }
                else if(cnt > 0){
                    sb.append(cnt).append(" ");
                    cnt++;
                }else{
                    sb.append(-1).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
