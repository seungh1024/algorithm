package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_5052_전화번호목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        for(int t = 0; t < T; t++){
            int n = Integer.parseInt(br.readLine());
            String[] data = new String[n];
            Map<String,Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                data[i] = br.readLine();
                char[] input = data[i].toCharArray();

                StringBuilder sb = new StringBuilder();
                for(char c : input){
                    sb.append(c);
                    if(map.containsKey(sb.toString())){
                        map.put(sb.toString(),map.get(sb.toString())+1);
                    }else{
                        map.put(sb.toString(),1);
                    }

                }

            }
            boolean isBreak = false;

            for(int i = 0; i < n; i++){
                if(map.get(data[i]) > 1){
                    isBreak = true;
                    result.append("NO\n");
                    break;
                }
            }
            if(!isBreak) result.append("YES\n");
        }
        System.out.println(result);
    }
}
