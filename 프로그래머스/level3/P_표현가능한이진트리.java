package algo_202311.kakaorecruitment2023;

import java.util.*;

public class P_표현가능한이진트리 {
    public static void main(String[] args) {
        P_표현가능한이진트리 test = new P_표현가능한이진트리();
        long[] numbers = {7,42,5};
        int[] result = {1,1,0};
        int[] answer = test.solution(numbers);
        if(result==answer) System.out.println("success");
        else System.out.println("fail");
    }

    public int[] solution(long[] numbers) {
        int arraySize = numbers.length;
        int[] answer = new int[arraySize];

        for(int i = 0; i < arraySize; i++){
            String input = Long.toBinaryString(numbers[i]);
            int length = input.length();
            // 1입력 -> 무조건 참
            if(length == 1 && input.equals("1")){
                answer[i] = 1;
            }
            // 2부터는 10(2) 이니까
            else{
                Form form = changeForm(numbers[i],input,length);

                answer[i] = check(form.s,form.size);
            }
        }
        return answer;
    }

    public static int check(String input, int length){
        char[] data = input.toCharArray();

        // (0,2), (4,6)... 이렇게 사용하려고 큐에 넣음
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < length; i+=2){
            q.offer(i);
        }
        int mid = length/2;

        while(true){
            int li = q.poll();
            int ri = q.poll();

            // 기본 더미 노드 = 0
            int rv = 0;
            int lv = 0;
            if(ri>=0){
                rv = data[ri]-'0';
            }
            if(li >= 0){
                lv = data[li]-'0';
            }

            int pv = rv|lv; // or 연산 -> 하나라도 1이면 부모는 1이어야 함
            int pi = (li+ri)/2;

            // 자식이 1인데 부모가 0이면 안됨
            if(pv == 1 && data[pi]=='0'){
                return 0;
            }
            if(pi == mid && pi == 0) return 0;
            if(pi == mid) break; // 가운데 부모 도달하면 탈출

            q.offer(pi); // 아무것도 못하면 부모 노드 삽입
        }

        return 1;
    }

    public static Form changeForm(long number, String s, int length){
        int cnt = 1;
        while(cnt <= length){
            cnt*=2;
        }
        cnt--;

        int cutSize = cnt - length;
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < cutSize; j++){
            sb.append("0");
        }
        sb.append(s);


        return new Form(sb.toString(),cnt);
    }

    public static class Form{
        String s;
        int size;

        public Form(String s, int size){
            this.s = s;
            this.size = size;
        }
    }
}
