package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1072_게임 {
    public static long x,y,z;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
        z = y*100/x;
        find();
    }
    public static void find(){
        long start = 1;
        long end = x;
        long min = Long.MAX_VALUE;
        while(start<=end){
            long mid = (start+end)/2;

            long value = (y+mid)*100/(x+mid);
//            System.out.println("z: "+z+", mid: "+mid + ", value:"+ value);
            if(value > z){
                end = mid-1;
                min = Math.min(min,mid);
            }else{
                start = mid+1;
            }
        }
        if(min == Long.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(min);
        }
    }
}
