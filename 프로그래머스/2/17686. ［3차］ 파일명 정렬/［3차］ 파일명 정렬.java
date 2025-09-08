import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        int N = files.length;
        List<Data> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            String s = files[i];
            String data = s.toLowerCase();
            char[] arr = data.toCharArray();
            int idx = 0;
            StringBuilder head = new StringBuilder();
            while(idx < arr.length){
                if(arr[idx] >= '0' && arr[idx] <= '9'){
                    break;
                }
                head.append(arr[idx++]);
            }
            
            StringBuilder number = new StringBuilder();
            int range = 5;
            while(idx < arr.length && range-->0){
                if(arr[idx]>='0' && arr[idx]<='9'){
                    number.append(arr[idx++]);
                }else{
                    break;
                }
            }
            StringBuilder tail = new StringBuilder();
            while(idx < arr.length){
                tail.append(arr[idx++]);
            }
            
            list.add(new Data(i,s,head.toString(),Integer.parseInt(number.toString()),tail.toString()));
        }
        
        Collections.sort(list,Comparator.comparing((Data o)->o.head).thenComparingInt((Data o)->o.number).thenComparingInt((Data o)->o.idx));
        // System.out.println(list);
        
        String[] answer = list.stream().map(Data::getOrigin).toArray(String[]::new);
        return answer;
    }
    
    public static class Data{
        int idx;
        String origin;
        String head;
        int number;
        String tail;
        
        public Data(int idx, String origin, String head, int number, String tail){
            this.idx = idx;
            this.origin = origin;
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        public String getOrigin(){
            return origin;
        }
        
        public String toString(){
            return "idx = "+idx + ", head = "+head + ", number = "+number + ", tail = "+tail + ", origin = "+origin;
        }
    }
}