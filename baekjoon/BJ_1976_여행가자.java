import java.io.*;
import java.util.*;

public class BJ_1976_여행가자 {
    public static int N,M;
    public static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        init();
        StringTokenizer st;
        int now;
        for(int i = 1; i <= N; i++){
//            System.out.println("/??????????");
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                now = Integer.parseInt(st.nextToken());
                if(now == 1){
                    union(i,j);
                }
            }
//            System.out.println(Arrays.toString(parent));
        }


        st = new StringTokenizer(br.readLine());
        int a= Integer.parseInt(st.nextToken());
        for(int i =1; i < M; i++){
            int b = Integer.parseInt(st.nextToken());
            if(!union(a,b)){
                System.out.println("NO");
                return;
            }
            a = b;
        }

        System.out.println("YES");
    }
    public static void init(){
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }
    }

    public static int setParent(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = setParent(parent[a]);
    }

    public static boolean union(int a, int b){
        int aRoot = setParent(a);
        int bRoot = setParent(b);
        if(aRoot == bRoot){
            return true;
        }
        parent[bRoot] = aRoot;
        return false;
    }
}
