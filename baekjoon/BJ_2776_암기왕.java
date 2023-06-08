package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2776_암기왕 {
    public static int T,N,M;
    public static int[] data;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t <T; t++){
            N= Integer.parseInt(br.readLine());
            data = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                data[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(data);
            M= Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < M; i++){
                int input = Integer.parseInt(st.nextToken());
                if(set.contains(input)){
                    sb.append(1).append("\n");
                }else if(find(input)){
                    set.add(input);
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean find(int input){
        int left = 0;
        int right = N-1;
        while(left <right){
            int mid = (left+right)/2;
            if(data[mid] >= input){
                right = mid;
            }else{
                left = mid+1;
            }
//            System.out.println("left: "+left + ", right: "+right);
        }
//        System.out.println("/////////////////");
//        System.out.println("left:"+left+", right: "+right);
        if(data[left] == input){
            return true;
        }else{
            return false;
        }
    }
}
