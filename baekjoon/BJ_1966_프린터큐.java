package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1966_프린터큐 {
    public static int N,M;
    public static int[] weight;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t <T ; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N= Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            weight = new int[10];
            st = new StringTokenizer(br.readLine());
            Queue<int[]> q = new LinkedList<>();
            for(int i = 0; i < N; i++){
                int input = Integer.parseInt(st.nextToken());
                q.offer(new int[] {i,input});
                weight[input] ++;
            }

            int cnt = 0;
            while(!q.isEmpty()){
                int[] now = q.poll();
                int num = now[0];
                int value = now[1];
                boolean check = false;
                for(int i = value+1; i <= 9; i++){
                    if(weight[i]>0){
                        check = true;
                        break;
                    }
                }
                if(check){
                    q.offer(now);
                }else{
                    cnt++;
                    weight[value]--;
                    if(num == M){
                        break;
                    }
                }
//                System.out.println(num+", "+value);
//                System.out.println(Arrays.toString(weight));

            }
            System.out.println(cnt);
        }
    }

}
