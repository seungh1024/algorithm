import java.io.*;
import java.util.*;

public class BJ_1761_정점들의거리 {
    public static int N,M,K;
    public static ArrayList<Node>[] data;
    public static int[] depth;
    public static int[][] parent;
    public static int[][] distance;
    public static boolean[] visited;
    public static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            data[i] = new ArrayList<>();
        }
        depth = new int[N+1];
        visited = new boolean[N+1];
        K = 1;
        for(int i = 1; i <= N; i= i*2){
            K++;
        }
        parent = new int[N+1][K];
//        distance = new int[N+1][N+1];
        dist = new int[N+1];

        StringTokenizer st;
        int a,b,c;
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            data[a].add(new Node(b,c));
            data[b].add(new Node(a,c));
        }

        dfs(1,0);
//        System.out.println(Arrays.toString(dist));
        connecting();

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = LCA(a,b);
            System.out.println(dist[a] + dist[b] - 2*dist[c]);
//            System.out.println(distance[a][c]+distance[b][c]);
//            System.out.println(c+ " , " +distance[a][c] + " , " + distance[b][c]);
        }
    }
    public static void dfs(int node, int deep){
        visited[node] = true;
        depth[node] = deep;
        for(Node next: data[node]){
            if(visited[next.to]) continue;
            parent[next.to][0] = node;
            dist[next.to] = dist[node] +next.weight;
//            distance[next.to][node] = next.weight;
//            distance[node][next.to] = next.weight;
            dfs(next.to,deep+1);
        }
    }
    public static void connecting(){
        for(int i = 1; i < K; i++){
            for(int j = 1; j <= N; j++){
                parent[j][i] = parent[parent[j][i-1]][i-1];
//                distance[j][parent[j][i]] = distance[j][parent[j][i-1]]+ distance[parent[j][i-1]][parent[j][i]];
//                distance[parent[j][i]][j] = distance[j][parent[j][i-1]]+ distance[parent[j][i-1]][parent[j][i]];
            }
        }
    }
    public static int LCA(int a, int b){
        if(depth[a] <depth[b]){
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
//        System.out.println("a : "+a);
        if(a == b){
            return a;
        }

        for(int i = K-1; i >= 0; i--){
            if(parent[a][i] == parent[b][i]) continue;
            a = parent[a][i];
            b = parent[b][i];
        }
        return parent[a][0];
    }

    public static class Node{
        int to,weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight =weight;
        }
    }
}
