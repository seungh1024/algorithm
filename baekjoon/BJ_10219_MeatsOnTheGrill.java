package algo_202307;

import java.io.*;
import java.util.*;

public class BJ_10219_MeatsOnTheGrill {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();
        for(int t= 0; t < T; t++){
            StringBuilder sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            for(int i = 0; i < H; i++){
                sb.insert(0,"\n").insert(0,br.readLine());
            }
            result.append(sb);
        }
        System.out.println(result);
    }
}
