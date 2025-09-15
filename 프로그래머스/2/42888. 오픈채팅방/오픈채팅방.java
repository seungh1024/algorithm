import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        Map<String,String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<Boolean> isEnter = new ArrayList<>();
        
        for(String s : record){
            String[] input = s.split(" ");
            String e = input[0];
            String id = input[1];
            
            
            
            if(e.equals("Enter")){
                list.add(id);
                isEnter.add(true);
                String name = input[2];
                map.put(id,name);
            }else if(e.equals("Leave")){
                list.add(id);
                isEnter.add(false);
            }else{
                String name = input[2];
                map.put(id,name);
            }
        }
        
        String a = "님이 들어왔습니다.";
        String b = "님이 나갔습니다.";
        List<String> result = new ArrayList<>();
        
        for(int i = 0; i < list.size(); i++){
            String id = list.get(i);
            String name = map.get(id);
            if(isEnter.get(i)){
                name += a;
            }else{
                name += b;
            }
            result.add(name);
        }
        
        answer = result.stream().toArray(String[]::new);
        return answer;
    }
}