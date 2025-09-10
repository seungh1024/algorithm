import java.util.*;

class Solution {
    public int[] solution(String msg) {
        List<String>[] list = new ArrayList[27];
        Map<String,Integer> map = new HashMap<>();
        char a = 'A';
        int idx = 1;
        for(int i = 1; i <= 26; i++){
            list[i] = new ArrayList<>();
            String s = a+"";
            list[i].add(s);
            map.put(s,idx++);
            a++;
        }
        
        char[] data = msg.toCharArray();
        int N = data.length;
    
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < N; i++){
            int max = 0;
            String key = "";
            for(String s : list[data[i]-'A'+1]){
                if(msg.startsWith(s,i)){
                    if(s.length() > max){
                        max = s.length();
                        key = s;
                    }
                }
            }
            result.add(map.get(key));
            if(i+max<N){
                String newKey = key+data[i+max];
                if(!map.containsKey(newKey)){
                    map.put(newKey,idx++);   
                }    
                list[data[i]-'A'+1].add(newKey);
            }
            i = i+max-1;
            
            
            // System.out.println("i = "+i + ", key = "+key + ", value = "+map.get(key));
        }
        // System.out.println(result);
        // System.out.println(map);
        
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}