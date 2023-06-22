package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_10158_개미 {
    public static int w,h;
    public static int p,q;
    public static int t;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken()); // y
        h = Integer.parseInt(st.nextToken()); // x
        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken()); // y
        q = Integer.parseInt(st.nextToken()); // x
        t = Integer.parseInt(br.readLine());

//        System.out.println(p + " " +q);
//        int px = t%(2*w);
//        int py = t%(2*h);

//        p = p+px;
//        q = q+py;
//        System.out.println(q+t + " " + 2*h);
        p = (p+t)%(2*w);
        q = (q+t)%(2*h);
//        System.out.println(p+ " " +q);
        if(p>w){
            p = w-(p-w);
        }
        if(q>h){
            q = h-(q-h);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(p).append(" ").append(q);
//        System.out.println(p + " " +q);
        System.out.println(sb);


    }

}
