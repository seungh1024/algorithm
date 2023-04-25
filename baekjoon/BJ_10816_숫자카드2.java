package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_10816_숫자카드2 {
    public static int N,M;
    public static HashMap<Integer,Integer> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(st.nextToken());
            int b = 1;
            if(map.get(a) != null){
                b = map.get(a)+1;
            }
            map.put(a,b);
        }
//        System.out.println(map);
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int a = Integer.parseInt(st.nextToken());
            int b = 0;
            if(map.get(a)!=null){
                b = map.get(a);
            }
            sb.append(b).append(" ");
        }
        System.out.println(sb);
    }
}
