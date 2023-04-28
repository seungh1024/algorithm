package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_10815_숫자카드 {
    public static int N,M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            map.put(Integer.parseInt(st.nextToken()),0);
        }
        M = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            if(map.get(Integer.parseInt(st.nextToken())) != null){
                sb.append(1).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
