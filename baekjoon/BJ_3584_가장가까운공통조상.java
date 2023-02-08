import java.io.*;
import java.util.*;

public class BJ_3584_가장가까운공통조상 {
    public static int T,N,K;
    public static int[] depth;
    public static int[][] parent;
    public static boolean[] visited;
    public static ArrayList<Integer>[] data;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());
            data = new ArrayList[N+1];
            for(int i = 1; i <= N; i++){
                data[i] = new ArrayList<>();
            }
            depth = new int[N+1];
            visited = new boolean[N+1];
            K = 1;
            for(int i = 1; i <= N; i*=2){
                K++;
            }
            parent = new int[N+1][K];
            StringTokenizer st;
            int a,b;
            for(int i = 1; i < N; i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                data[a].add(b);
//                data[b].add(a);
            }

            // 이렇게 전체를 돌지 말고 리스트 연결할 때 자식들은 카운트를 해서 카운트 안된 루트를 찾아서 기존 LCA 방식으로 풀면 더 효율적일듯
            for(int i = 1; i <= N; i++){
                dfs(i);
            }

            connecting();

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            System.out.println(LCA(a,b));
        }

    }
    public static void dfs(int node){
        visited[node] = true;
        for(int next :data[node]){
            parent[next][0] = node;
            depth[next]++;
            dfs(next);
        }
    }
    public static void connecting(){
        for(int i =1; i < K; i++){
            for(int j = 1; j <=N; j++){
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

        for(int i = K-1; i >= 0; i--){
            int jump = 1<<i;
            if(depth[a]-depth[b] >= jump){
                a = parent[a][i];
            }
        }
        if(a == b){
            return a;
        }

        for(int i = K-1; i >=0; i--){
            if(parent[a][i] == parent[b][i]) continue;
            a = parent[a][i];
            b = parent[b][i];
        }

        return parent[a][0];
    }

}
