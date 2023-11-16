package algo_202311.kakaointern2020;

import java.util.*;

public class P_동굴탐험 {
    public static void main(String[] args) {
        P_동굴탐험 test = new P_동굴탐험();
        int n = 9;
        int[][] path = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int[][] order = {{8,5},{6,7},{4,1}};
        boolean result = true;
        boolean answer = test.solution(n,path,order);
        if(result == answer){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }
    public static boolean[] visited;
    public static Map<Integer, Integer> map;
    public static List<Integer>[] data;
    public boolean solution(int n, int[][] path, int[][] order) {
        initData(n,path,order);
        boolean answer = find(n);
        return answer;
    }

    public static boolean find(int n){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);

        if(map.containsKey(0)) return false;

        int[] before = new int[n]; // 이동할 수 없는 지점에 먼저 도착한 경우 기록. a -> b라면 before[a] = b로 하고 a를 방문했을 때 b도 같이 큐에 넣어줌

        int count = 1;

        while(!q.isEmpty()){
            int now = q.poll();

            if(visited[now]) continue;
            visited[now] = true;

            if(before[now] > 0){
                q.offer(before[now]);
                count++;
                before[now] = 0;
            }

            for(int next : data[now]){
                if(!visited[next]){
                    if(map.containsKey(next) && !visited[map.get(next)]){
                        before[map.get(next)] = next;
                    }else{
                        q.offer(next);
                        count++;

                    }

                }
            }

        }

        if(count == n){
            return true;
        }
        return false;
    }

    public static void initData(int n, int[][] path, int[][] order){
        visited = new boolean[n];
        map = new HashMap<>();
        data = new ArrayList[n];
        for(int i = 0; i < n; i++){
            data[i] = new ArrayList<>();
        }

        for(int[] p : path){
            data[p[0]].add(p[1]);
            data[p[1]].add(p[0]);
        }

        for(int[] o : order){
            map.put(o[1],o[0]); // B조건은 A임을 저장함
        }
    }
}
