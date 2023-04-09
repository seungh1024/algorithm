package algo_202304;

import java.io.*;
import java.util.*;

public class BJ_1068_트리 {
    public static int N,parent, result,delete;
    public static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N];
        for(int i = 0; i < N; i++){
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(st.nextToken());
            if(a == -1){
                parent = i;
            }else{
                tree[a].add(i);
            }
        }
        delete = Integer.parseInt(br.readLine());
        tree[delete] = new ArrayList<>();
        result = 0;
        find();
        System.out.println(result);
    }
    public static void find(){
        if(parent == delete) return;
        Queue<Integer> q = new LinkedList<>();
        q.offer(parent);
        boolean[] visited = new boolean[N];
        visited[parent] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int now = q.poll();
//            if(now == delete) continue;
//            System.out.println(now);
//            cnt ++;
            if(tree[now].size() == 0) result ++;
            for(int next : tree[now]){
                if(!visited[next] && next != delete){
                    q.offer(next);
                    visited[next] = true;
                }else if(next == delete && tree[now].size() == 1){
                    result++;
                }
            }
        }
//        if(cnt == 1) result++;
    }
}
