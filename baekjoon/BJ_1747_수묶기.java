package algo_202311;

import java.io.*;
import java.util.*;

public class BJ_1747_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> minuspq = new PriorityQueue<>();
        Queue<Integer> pluspq = new PriorityQueue<>((num1, num2)->{
            return num2-num1;
        });

        int mi = 0;
        int pi = 0;
        for(int i = 0; i < N; i++){
            int input = Integer.parseInt(br.readLine());
            if(input <= 0){
                minuspq.offer(input);
                mi++;
            }else{
                pluspq.offer(input);
                pi++;
            }
        }

        int result = 0;
        while(mi >= 2){
            int a = minuspq.poll();
            int b = minuspq.poll();
            result += (a*b);
            mi-=2;
        }
        while(mi-- > 0){
            result += minuspq.poll();
        }
        while(pi >= 2){
            int a = pluspq.poll();
            int b = pluspq.poll();
            if(a > 1 && b > 1){
                result += (a*b);
            }else{
                result += a + b;
            }
            pi-=2;
        }
        while(pi-- > 0){
            result += pluspq.poll();
        }
        System.out.println(result);
    }
}
