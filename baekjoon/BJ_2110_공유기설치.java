package before230401;

import java.io.*;
import java.util.*;

public class BJ_2110_공유기설치 {
    public static int N,C;
    public static int[] data;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        data = new int[N];
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(data);
//        System.out.println(Arrays.toString(data));

        find();
    }

    public static void find(){
        int start = 1;
        int mid = 0;
        int end = data[N-1] - data[0];
        int result = 0;
        if(C == 2){
            System.out.println(end);
            return;
        }
        while(start < end){
            mid = (start+end)/2;
            int cnt = 1;
            int house = data[0]; //마지막에 설치된 위치
            for(int i = 0; i < N; i++){
                if(data[i]-house >= mid){
                    cnt++;
                    house = data[i];
                }
            }

//            System.out.println(cnt);
//            System.out.println(mid);
//            System.out.println("////");
            if(cnt >= C){
                start = mid + 1;
                result = mid;
            }else{
                end = mid;
            }
        }
        System.out.println(result);
    }
}
