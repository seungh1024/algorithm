package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_20040_사이클게임 {
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        initParent(n);

        int result = 0;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            result++;
            if(isSameParent(p,c)){
                System.out.println(result);
                return;
            }
            unionParent(p,c);
        }
        System.out.println(0);
//        System.out.println(Arrays.toString(parent));
    }

    public static int getParent(int index){
        int myP = parent[index];

        if(myP == index) return myP;

        return parent[index] = getParent(parent[index]);
    }

    public static void unionParent(int a, int b){
        a = getParent(a);
        b = getParent(b);

        parent[b] = a;
    }

    public static boolean isSameParent(int a, int b){
        a = getParent(a);
        b = getParent(b);
        if(a == b) return true;
        return false;
    }

    public static void initParent(int n){
        for(int i = 1; i < n; i++){
            parent[i] = i;
        }
    }
}
