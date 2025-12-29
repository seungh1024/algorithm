import java.beans.IntrospectionException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ans = 0;
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            // 일단 전곡을 1회는 들어야하기 때문에 누적합 더해주기
            ans += arr[i];
        }
        long[] Ldp = new long[N];
        long[] maxLdp = new long[N];
        maxLdp[0] = Ldp[0] = arr[0];
        for (int i = 1; i < N; i++) {
            // 전칸이 최대부분합으로 이어지는지, 새로 끊어가야하는지 판단
            Ldp[i] = Math.max(Ldp[i - 1] + arr[i], arr[i]);
            // 최대부분합을 구해주기
            maxLdp[i] = Math.max(maxLdp[i - 1], Ldp[i]);
        }
        long[] Rdp = new long[N];
        long[] maxRdp = new long[N];
        maxRdp[N - 1] = Rdp[N - 1] = arr[N - 1];
        for (int i = N - 2; i > 0; i--) {
            Rdp[i] = Math.max(Rdp[i + 1] + arr[i], arr[i]);
            maxRdp[i] = Math.max(maxRdp[i + 1], Rdp[i]);
        }
        long maxsum = 0;
        // 전곡 다시듣기가 더 좋을지도?
        maxsum = Math.max(0, maxLdp[N - 1]);
        for (int i = 0; i < N - 2; i++) {
            maxsum = Math.max(maxsum, maxLdp[i] + maxRdp[i + 1]);
        }
        ans += maxsum;
        System.out.println(ans);
    }
}
