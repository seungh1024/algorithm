import java.util.*;

class Solution {
    String[][] data = {{"\\+","-","\\*"},{"\\+","\\*","-"},{"-","\\+","\\*"},{"-","\\*","\\+"},{"\\*","-","\\+"},{"\\*","\\+","-"}};
    
    public long solution(String expression) {
        long answer = 0;
        
        for(int i = 0; i < 6; i++){
            long result = Math.abs(find(0,data[i],expression));
            answer = Math.max(answer,result);
        }
        
        return answer;
    }
    
    public static long find(int idx, String[] arr, String s){
        if(idx == 3){
            // System.out.println("s = "+s);
            return Long.parseLong(s);
        }
        
        String[] split = s.split(arr[idx]);
        // System.out.println("idx = "+idx + ", arr = "+Arrays.toString(arr));
        // System.out.println(Arrays.toString(split));
        if(split.length <1){
            return find(idx+1,arr,s);
        }
        
        
        switch(arr[idx]){
            case "\\+":
                long sum = 0;
                for(String next : split){
                    // System.out.println("+ next = "+next);
                    sum += find(idx+1,arr,next);
                }
                // System.out.println("sum = "+sum);
                return sum;
            case "-":
                sum = find(idx+1,arr,split[0]);
                for(int i = 1; i < split.length;i++){
                    // System.out.println("- next = "+split[i]);
                    sum -= find(idx+1,arr,split[i]);    
                }
                
                // System.out.println("sum - ="+sum);
                return sum;
            case "\\*":
                sum = 1;
                for(String next : split){
                    // System.out.println("* next = "+next);
                    sum *= find(idx+1,arr,next);
                }
                // System.out.println("sum * ="+sum);
                return sum;
        }
        
        return 0;
    }
}