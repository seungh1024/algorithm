import java.io.*;
import java.util.*;

public class BJ_1717_집합의표현 {
    public static int N,M;
    public static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        init();
        int a,b,c;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 0){
                union(b,c);
            }else if(a == 1){
                if(findParent(b) == findParent(c)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
//            System.out.println(Arrays.toString(parent));
        }

    }
    public static void init(){
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }
    }
    public static int findParent(int a){
        if(a == parent[a]){
            return a;
        }
        return parent[a] = findParent(parent[a]);
    }
    public static void union(int a, int b){
        int aRoot = findParent(a);
        int bRoot = findParent(b);
        if(aRoot == bRoot) return;
        parent[bRoot] = aRoot;
    }
}

//7 10
//0 1 3
//1 1 7
//0 7 6
//1 7 1
//0 3 7
//0 4 2
//0 1 1
//1 1 1
//1 1 7
//1 6 7