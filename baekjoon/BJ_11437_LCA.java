import java.io.*;
import java.util.*;

public class BJ_11437_LCA {
    public static int N,M,K;
    public static int[][] parent; // 해당 노드의 조상 정보를 담을 객체
    public static int[] depth; // 해당 노드의 깊이 정보를 담을 객체
    public static ArrayList<Integer>[] data; // 해당 노드의 연결된 정보를 담을 객체
    public static boolean[] visited; // 부모 연결할 때 방문체크 할 객체;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            data[i] = new ArrayList<>();
        }
        StringTokenizer st;
        int a,b;
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            data[a].add(b);
            data[b].add(a);
        }
        K = 1; //깊이 변수
        for(int i = 1; i <= N; i=i*2){ //2^n 만큼 깊이를 올려줌
            K++;
        }

        visited = new boolean[N+1];
        depth = new int[N+1];
        parent = new int[N+1][K];
        dfs(1,0);
        connecting();

//        for(int i = 0; i <= N; i++){
//            System.out.println(Arrays.toString(parent[i]));
//        }

        M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            System.out.println(lca(a,b));
        }
    }

    // 바로 위의 부모를 탐색하며 연결
    public static void dfs(int node, int deep){
        visited[node] = true;
        depth[node] = deep;

        for(int now : data[node]){
            if(visited[now]) continue;
            parent[now][0] = node;
            dfs(now,deep+1);
        }
    }
    // dfs를 바탕으로 전체 부모 관계 정보를 저장
    public static void connecting(){
        for(int i = 1; i < K; i++){
            for(int j = 1; j <= N; j++){
                // 부모의 2번째 조상의 값을 부모의 조상의 조상으로 접근해서 찾음
                // 맨 마지막에 [i-1]인 이유도 한 칸만 올라가고 거기서 또 해당 부모의 값을 찾는 그런 방식인 것
                parent[j][i] = parent[parent[j][i-1]][i-1];
            }
        }
    }
    public static int lca(int a, int b){
        // 무조건 a가 더 깊은걸로 만들어줌 -> 뒤에 비교할 때 항상 a가 크게 유지하기 위해서
        if(depth[a] <depth[b]){
            int tmp = b;
            b = a;
            a = tmp;
        }


        int jump;
        // 큰 수부터 비교하는 이유가 작은수부터 하면 1증가, 2증가 이런식으로 돼서 알맞은 높이 차이만큼 뺼 수가 없음
        // 큰 수부터 아래로 내려가서 차이만큼의 수가 되었을 때 해당 차이만큼 깊이를 맞춰줌
        for(int i = K-1; i >= 0; i--){
            jump = 1 << i;
            // 차이나는 만큼 깊이를 맞춰줌
            if(depth[a]-depth[b] >= jump){
                a = parent[a][i];
            }
        }
        if(a == b){
            return a;
        }

        // 큰 수부터 비교하는 이유는 최소 공통 부모를 찾기 위함임
        // 가장 높은 부모가 같으면 continue를 해서 업데이트하지 않음
        // 그렇게 한 칸씩 각각 부모에게 접근하면 맨 마지막이 공통을 부모로 가진 노드들이 될 것임
        for(int i = K-1; i >= 0; i--){
            //부모가 같으면 최소 조상이 아니니까 패스
            if(parent[a][i] == parent[b][i]) continue;

            //부모가 다르면 그만큼 올려도 상관없으니까 올림
            a = parent[a][i];
            b = parent[b][i];
        }

        return parent[a][0]; // 그 부모를 리턴하면 최소 공통 조상임

    }
}
