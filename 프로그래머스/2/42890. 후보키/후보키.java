import java.util.*;

class Solution {
    int N;
    boolean[] visited;
    List<Integer> list;
    
    public int solution(String[][] relation) {
        int answer = 0;
        
        N = relation[0].length;
        visited = new boolean[N];
        list = new ArrayList<>();
        
        for(int i = 1; i <= N; i++){
            answer += find(0,0,i,relation);    
        }
        
        System.out.println(list);
        
        return answer;
    }
    
    public int find(int idx, int cnt, int range, String[][] relation){
        
        if(cnt == range){
            Set<String> set = new HashSet<>();
            for(int i = 0; i < relation.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < N; j++){
                    if(visited[j]){
                        sb.append(j).append(":").append(relation[i][j]).append("/");
                    }
                }
                set.add(sb.toString());
            }
            
            int key = 0;
            for(int i = 0; i < N; i++){
                if(visited[i]){
                    key |= (1<<i);    
                }
            }
            
            boolean flag = false;
            for(int i : list){
                if((i&key) == i){
                    flag = true;
                    break;
                }
            }
            // System.out.println("cnt = "+cnt + ", size = "+set.size());
            // System.out.println("flag = "+flag);
            // System.out.println(set);
            // System.out.println("key = "+key);
            if(set.size() == relation.length && !flag){
                list.add(key);
                return 1;
            }
            
            return 0;
        }
        
        if(idx >= N) return 0;
        
        int result = 0;
        visited[idx] = true;
        result += find(idx+1,cnt+1,range,relation);
        visited[idx] = false;
        result += find(idx+1,cnt,range,relation);
        
        return result;
    }
}