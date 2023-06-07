package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_13335_트럭 {
    public static int N,W,L; // W -> 다리 길이, L -> 다리 하중
    public static int[] truck;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        truck = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            truck[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(move()+1);
    }
    public static int move(){
        int result = 0;
        int idx = 0;
        int sum = 0;
        int[] bridge = new int[W];
        while(idx <N){
            int last = bridge[W-1];
            if(sum +truck[idx] -last <= L){
                push(bridge);
                bridge[0] = truck[idx];
                sum += truck[idx]-last;
                idx++;
            }else{
                push(bridge);
                sum -= last;
            }
//            System.out.println("idx: "+idx + ", sum: "+ sum + ", last: "+last);
//            System.out.println(Arrays.toString(bridge));
//            System.out.println("///////////////");
            result ++;
        }
        return result + W-1;
    }
    public static int go(int[] bridge){
        int cnt = 0;
        for(int i = W-1; i >= 0; i--){
            if(bridge[i] != 0){
                break;
            }
            cnt++;
        }
        for(int i = W-1; i >= cnt; i--){
            bridge[i] = bridge[i-cnt];
        }
        for(int i = 0; i < cnt; i++){
            bridge[i] = 0;
        }
        return cnt;
    }
    public static void push(int[] bridge){
        for(int i = W-1; i > 0; i--){
            bridge[i] = bridge[i-1];
        }
        bridge[0] = 0;
    }
}
