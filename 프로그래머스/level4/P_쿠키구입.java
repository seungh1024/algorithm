package algo_202311;

public class P_쿠키구입 {
    public static void main(String[] args) {
        P_쿠키구입 test = new P_쿠키구입();
        int[] cookie = {1,2,4,5};
        int result = 0;
        int answer = test.solution(cookie);
        if(result == answer) System.out.println("success");
        else System.out.println("fail");
    }

    public static int result;
    public int solution(int[] cookie) {
        int answer = -1;
        int length = cookie.length;
        int[] sum = new int[length];
        sum[0] = cookie[0];
        for(int i = 1; i < length; i++){
            sum[i] = cookie[i]+sum[i-1];
        }

        result = 0;
        find(cookie, sum , length);
        answer = result;

        return answer;
    }

    public static void find(int[] cookie, int[] sum, int length){
        for(int i = 0; i < length; i++){
            int left = i;
            int right = i;

            while(left>=0 && right < length){
                int leftSum = sum[i] - sum[left] + cookie[left] - cookie[i];
                int rightSum = sum[right] - sum[i] + cookie[i];



                if(leftSum == rightSum){
                    result = Math.max(result,leftSum);
                    right++;
                }else if(leftSum < rightSum){
                    left--;
                }else{
                    right++;
                }


            }
        }
    }
}
