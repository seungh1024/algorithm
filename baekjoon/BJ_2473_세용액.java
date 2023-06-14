package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_2473_세용액 {
    public static int N;
    public static int[] data;
    public static int a,b,c;
    public static long check;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);
        int xr = N-2;
        int yr = N-1;
        check = Long.MAX_VALUE;
//        System.out.println(Arrays.toString(data));
        for(int i = 0; i < xr; i++){
            for(int j = i+1; j < yr; j++){
                find(i,j);
            }
        }
        System.out.println(data[a] + " "+data[b]+ " "+data[c]);
    }
    public static void find(int x, int y){
        int start = y+1;
        int end = N-1;
        int mid = 0;
        long xy = data[x]+data[y];
        long sum = 0;
//        System.out.println("x: "+x+", y: "+y + ", xy: "+xy + ", check: "+check);
        while(start < end){
            mid = (start+end)/2;

            sum = xy + data[mid];
//            System.out.println("start: "+start+ ", end: "+end +", mid: "+mid +" , sum : "+sum);

            if(Math.abs(sum) < check){
                check = Math.abs(sum);
                a = x;
                b= y;
                c = mid;
            }
            if(sum > 0 ){
                end = mid-1;
            }else if (sum < 0){
                start = mid+1;
            }else{
                start = mid;
                break;
            }

        }
        sum = Math.abs(xy + data[start]);
        if(sum < check){
            check = sum;
            a = x;
            b= y;
            c = start;
        }
//        System.out.println("------------------");
//        System.out.println("start: "+start+ ", end: "+end +",mid: "+mid+" , sum : "+sum);
//        System.out.println("/////////////");
    }
}

