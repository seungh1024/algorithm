package algo_202311;

public class P_올바른괄호의갯수 {
    public static void main(String[] args) {
        P_올바른괄호의갯수 test = new P_올바른괄호의갯수();
        int n = 3;
        int result = 5;
        int answer = test.solution(n);
        if(result == answer) System.out.println("success");
        else System.out.println("fail");
    }

    public static int result;
    public int solution(int n) {
        int answer = 0;
        result = 0;
        dfs(n,0,0);
        return result;
    }

    public static void dfs(int left, int right, int index){
        if(left == 0 && right == 0){
            result++;
            return;
        }
        if(left > 0){ // left = true
            dfs(left-1,right+1, index+1);
        }
        if(right > 0){
            dfs(left, right-1, index+1);
        }
    }
}
