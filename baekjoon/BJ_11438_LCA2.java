import java.io.*;
import java.util.*;

public class BJ_11438_LCA2 {
    public static int N,M,K;
    public static ArrayList<Integer>[] data;
    public static int[][] parent;
    public static boolean[] visited;
    public static int[] depth;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new ArrayList[N+1];
        for(int i = 1; i <= N;i++){
            data[i] = new ArrayList<>();
        }
        K = 1;
        for(int i = 1; i <= N; i= i*2){
            K++;
        }
        parent = new int[N+1][K];
        depth = new int[N+1];
        visited = new boolean[N+1];
        StringTokenizer st;
        int a,b;
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            data[a].add(b);
            data[b].add(a);
        }

        dfs(1,0);
//        for(int i = 1; i <= N; i++){
//            System.out.println(Arrays.toString(parent[i]));
//        }
        connectiong();
//        for(int i = 1; i <= N; i++){
//            System.out.println(Arrays.toString(parent[i]));
//        }

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            System.out.println(LCA(a,b));
        }
    }

    public static void dfs(int node, int deep){
        visited[node] = true;
        depth[node] = deep;

        for(int next :data[node]){
            if(visited[next]) continue;
            parent[next][0] = node;
            dfs(next,deep+1);
        }
    }

    public static void connectiong(){
        for(int i = 1; i < K; i++){
            for(int j = 1; j <= N; j++){
                parent[j][i] = parent[parent[j][i-1]][i-1];
            }
        }
    }

    public static int LCA(int a, int b){
        if(depth[a] < depth[b]){
            int tmp = b;
            b = a;
            a = tmp;
        }

        for(int i = K-1; i >=0; i--){
            int jump = 1 << i;
            if(depth[a] - depth[b] >= jump){
                a = parent[a][i];
            }
        }

        if(a == b){
            return a;
        }
//        System.out.println("?: "+a + ", "+b);

        for(int i = K-1; i >=0; i--){
            if(parent[a][i] == parent[b][i]) continue;
            a = parent[a][i];
            b = parent[b][i];
        }

        return parent[a][0];
    }
}
