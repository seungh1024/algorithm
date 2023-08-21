package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_1069_집으로 {
    public static int X,Y,D,T;
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        find();
    }

    public static  void find(){
        double normalValue = Math.sqrt(X*X + Y*Y);
        double shortValue = (int)(normalValue/D)*T + normalValue%D;
        double longValue = ((int)(normalValue/D)+1)*T + D - (normalValue%D);
        double roundValue = normalValue>D?((int)(normalValue/D)+1)*T : T*2;
//        System.out.println("n: "+normalValue+ ", s: "+shortValue + ", l: "+longValue + ", r: "+roundValue);
        System.out.println(Math.min(roundValue,Math.min(normalValue,Math.min(shortValue,longValue))));
    }
}
