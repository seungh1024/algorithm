package algo_202309;

import java.io.*;
import java.util.*;

public class BJ_16637_괄호추가하기 {
    public static int N;
    public static char[] data;
    public static int[] indexes;
    public static boolean[] visited;
    public static long result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int maxIndex = N/2;
        indexes = new int[maxIndex];
        int index = 0;
        for(int i = 1; i < N; i+=2){
            indexes[index] = i;
            index++;
        }

        data = br.readLine().toCharArray();
        visited = new boolean[maxIndex];
        result = Long.MIN_VALUE;
        find(0,maxIndex);
        System.out.println(result);
    }

    public static void find(int index, int maxIndex){
        if(index == maxIndex){
//            System.out.println(Arrays.toString(visited));
            makeSum(maxIndex);
            return;
        }

        if(index-1>=0){
            if(!visited[index-1]){
                visited[index] = true;
                find(index+1,maxIndex);
                visited[index] = false;
                find(index+1,maxIndex);
            }else{
                find(index+1,maxIndex);
            }
        }else if(index == 0){
            visited[index]=true;
            find(index+1,maxIndex);
            visited[index]=false;
            find(index+1,maxIndex);
        }

    }

    public static void makeSum(int length){
        ArrayList<Long> list = new ArrayList<>();
        ArrayList<Character> valueList = new ArrayList<>();
        boolean[] numberCheck = new boolean[N];
        for(int i = 0; i < length; i++){
            int index = indexes[i];
            if(visited[i]){
                long num = calculate(data[index-1]-'0',data[index+1]-'0',data[index]);
                list.add(num);
                numberCheck[index-1] = true;
                numberCheck[index+1] = true;
            }else{
                if(!numberCheck[index-1]){
                    list.add((long)(data[index-1]-'0'));
                    numberCheck[index-1] = true;
                }
                valueList.add(data[index]);
            }
        }
        if(!numberCheck[N-1]){
            list.add((long)(data[N-1]-'0'));
        }
        int size = valueList.size();
//        System.out.println(size);
//        System.out.println("listSize:"+list.size());
//        System.out.println(list.toString());
        long sum = list.get(0);
        int index = 1;
        for(int i = 0; i < size; i++){
            char value = valueList.get(i);
            long left = sum;
            long right = list.get(index);
            index++;
//            System.out.println("left: "+left+", right: "+right +", value: "+value);
            sum = calculate(left,right,value);

        }
//        System.out.println("sum: "+sum);
        result = Math.max(result,sum);
    }

    /**
     * 정수형 파라미터로 바꿔주기
     * @param a
     * @param b
     * @param value
     * @return
     */
    public static long calculate(long a, long b, char value){
        long num = 0;
        if(value =='+'){
            num = a + b;
        }else if(value == '*'){
            num = a * b;
        }else if(value == '-'){
            num = a - b;
        }
        return num;
    }
}
//19
//3-2*8-9*9+9*8-9*9+9
