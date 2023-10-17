package algo_202310;

import java.io.*;
import java.util.*;

public class BJ_10252_그리드그래프 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] dy = {-1,1};
        for(int t = 0; t < T; t++){
            int d = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(1).append("\n");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int j = y-2;
            for(int i = 0; i < x; i++){
                while(j >= 0 && j <y-1){
                    sb.append("(").append(i).append(",").append(j).append(")").append("\n");
                    j += dy[d];
//                    System.out.println("j:"+j);
                }
                j -= dy[d];
                d = (d+1)%2;
            }
            j = y-1;
            for(int i = x-1; i >= 0; i--){
                sb.append("(").append(i).append(",").append(j).append(")").append("\n");
            }
        }
        System.out.println(sb);
    }
}
