import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        int[] count = new int[N+2];
        for(int i : stages){
            count[0]++;
            count[i]--;
        }
        for(int i = 1; i <= N; i++){
            count[i] += count[i-1];
        }
        // System.out.println(Arrays.toString(count));
        
        List<double[]> list = new ArrayList<>();
        double total = stages.length;
        for(int i = 1; i <= N; i++){
            double fail = total-count[i];
            if(total == 0){
                list.add(new double[]{i,0});
                continue;
            }
            list.add(new double[]{i,fail/total});
            // System.out.println("i = "+i + ", fail = "+fail);
            total -= fail;
        }
        Collections.sort(list,Comparator.comparingDouble((double[] o)->-o[1]).thenComparingDouble((double[] o)->o[0]));
        
        
        answer = list.stream().mapToInt(o->(int)o[0]).toArray();
        return answer;
    }
}