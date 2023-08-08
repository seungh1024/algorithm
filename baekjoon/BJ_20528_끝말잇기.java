package algo_202308;

import java.io.*;
import java.util.*;

public class BJ_20528_끝말잇기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Character> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            char first = st.nextToken().charAt(0);
            set.add(first);
        }

        if(set.size() >1){
            System.out.println(0);
        }else{
            System.out.println(1);
        }
    }
}
