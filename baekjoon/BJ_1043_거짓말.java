import java.io.*;
import java.util.*;

public class BJ_1043_거짓말 {
    public static int N,M,T;
    public static boolean[] trueMan;
    public static ArrayList<Integer>[] data;
    public static int[] parent;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trueMan = new boolean[N+1];
        parent = new int[N+1];
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        if(T<1){
            System.out.println(M);
            return;
        }
        else{
            for(int i = 0; i < T; i++){
                trueMan[Integer.parseInt(st.nextToken())] = true;
            }
        }

        data = new ArrayList[M];
        for(int i = 0; i < M; i++){
            data[i] = new ArrayList<>();
        }

        init();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int last = Integer.parseInt(st.nextToken());
            data[i].add(last);
            if(A>=2){
                for(int j = 2; j <= A; j++){
                    int now = Integer.parseInt(st.nextToken());
                    union(last,now);
                    data[i].add(now);
                }
            }
        }

        for(int i = 0; i <= N; i++){
            setParent(i);
        }
        for(int i = 1; i <= N; i++){
            if(trueMan[i]){
                for(int j = 1; j <= N; j++){
                    if(parent[j] == parent[i]){
                        trueMan[j] = true;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(parent));
//        System.out.println(Arrays.toString(trueMan));

        int cnt = 0;
        for(int i = 0; i < M; i++){
            for(int human :data[i]){
                if(trueMan[parent[human]]){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(M-cnt);


    }

    public static void init(){
        for(int i = 0; i <= N; i++){
            parent[i] = i;
        }
    }
    public static int setParent(int a){
        if(parent[a] == a){
            return a;
        }
        return parent[a] = setParent(parent[a]);
    }

    public static boolean union(int a, int b){
        int aRoot = setParent(a);
        int bRoot = setParent(b);
        if(aRoot == bRoot) return true;
        parent[bRoot] = aRoot;
        return false;
    }
}
