import java.util.*;

class Solution {
    public int[] arr;
    public boolean[] visited;
    public int N;
    public int M;
    public Set<String> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        N = user_id.length;
        M = banned_id.length;
        arr = new int[M];
        visited = new boolean[N];
        set = new HashSet<>();
        answer = find(0,0,user_id,banned_id);
        
        return answer;
    }
    
    public int find(int idx, int cnt,  String[] user_id, String[] banned_id){
        if(cnt == M){
            int index = 0;
            String key = "";
            int[] temp = new int[M];
            for(int i = 0; i < M; i++){
                temp[i] = arr[i];
            }
            Arrays.sort(temp);
            for(int i = 0; i < M; i++){
                key += temp[i];
            }
            if(set.contains(key)) return 0;
            // set.add(key);
            
            boolean[] check = new boolean[M];
            int m = 0;
            for(int i = 0; i < M; i++){
                char[] a = user_id[arr[i]].toCharArray();
                for(int j = 0; j < M; j++){
                    char[] b = banned_id[j].toCharArray();    
                    
                    if(a.length != b.length || check[j]) continue;
                    boolean flag = false;
                    for(int k = 0; k < a.length; k++){
                        if(b[k] == '*') continue;
                        if(a[k] != b[k]) {
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        check[j] = true;
                        m++;
                        break;
                    }
                }
                
                
            }
            // System.out.println(Arrays.toString(arr));
            if(m == M) {
                set.add(key);
                return 1;
            }
            return 0;
        }
        if(idx == N){
            return 0;
        }
        
        int result = 0;
        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[idx]=i;
            result += find(idx+1,cnt+1,user_id,banned_id);
            visited[i] = false;
        }
        
        return result;
    }
}