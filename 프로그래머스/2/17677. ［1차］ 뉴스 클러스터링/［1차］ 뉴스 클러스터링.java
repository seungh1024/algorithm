import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        char[] data1 = str1.toCharArray();
        char[] data2 = str2.toCharArray();
        
        List<String> list1 = makeList(data1);
        List<String> list2 = makeList(data2);
        boolean[] visited = new boolean[list2.size()];
        
        int cnt = 0;
        for(String s : list1){
            for(int i = 0; i < list2.size(); i++){
                if(!visited[i]&&s.equals(list2.get(i))){
                    visited[i] = true;
                    cnt++;
                    break;
                }
            }
        }
        
        int temp = list1.size()-cnt + list2.size();
        if(temp == 0 && cnt == 0){
            cnt = 1;
            temp = 1;
        }
        answer = cnt*65536/temp;
        // System.out.println(list1);
        // System.out.println(list2);
        // System.out.println(list1.size() + ", "+list2.size());
        
        return answer;
    }
    
    public List<String> makeList(char[] data){
        List<String> list = new ArrayList<>();
        for(int i = 1; i < data.length;i++){
            if(data[i] <'a' || data[i] > 'z' || data[i-1]<'a' || data[i-1] > 'z') continue;
            list.add(""+data[i-1]+data[i]);
        }
        
        return list;
    }
}