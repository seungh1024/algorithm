package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_2980_도로와신호등 {
    public static int N,L;
    public static int D,R,G;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int result = 0;
        int last = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            D= Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            result += (D-last);
            last = D;
            int num = result %(R+G);
//            System.out.println(num);
            if(num < R){
                result += (R-num);
//                System.out.println("result: "+result);
            }
        }
        System.out.println(result + (L-last));
    }
}
