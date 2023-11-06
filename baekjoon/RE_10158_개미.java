package algo_202311;

import java.io.*;
import java.util.*;

public class RE_10158_개미 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        makeResult(w,h,p,q,t);
    }

    public static void makeResult(int w, int h, int p, int q, int t){
        p += t;
        q += t;
        p = p % (2*w);
        q = q % (2*h);

        if(p > w){
            p = w - (p-w);
        }
        if(q > h){
            q = h - (q-h);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(p).append(" ").append(q);
        System.out.println(sb);
    }
}
