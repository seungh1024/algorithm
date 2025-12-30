import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) { this.in = in; }

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do { c = readByte(); } while (c <= ' ' && c != -1);
            int sign = 1;
            if (c == '-') { sign = -1; c = readByte(); }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static int upperBound(long[] a, long target) {
        int l = 0, r = a.length; // [l, r)
        while (l < r) {
            int m = (l + r) >>> 1;
            if (a[m] <= target) l = m + 1;
            else r = m;
        }
        return l; // <= target 개수
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int T = fs.nextInt();
        int[] queries = new int[T];
        int maxL = 0;
        for (int i = 0; i < T; i++) {
            int L = fs.nextInt();
            queries[i] = L;
            if (L > maxL) maxL = L;
        }

        // 1) primitive 후보들의 perimeter p = 2*(w+h) 수집 (p <= maxL)
        ArrayList<Integer> perims = new ArrayList<>();

        // m, n (m > n > 0)
        // p_min for n=1 roughly 2*(m^2 + 2m - 1). 이것이 maxL보다 커지면 더 볼 필요 없음.
        for (int m = 2; ; m++) {
            long minSum = (long)m * m + 2L * m - 1;   // (m^2 - 1) + 2m
            long minP = 2L * minSum;
            if (minP > maxL) break;

            for (int n = 1; n < m; n++) {
                // primitive 조건: 서로소 + m,n의 홀짝 다름
                if (((m - n) & 1) == 0) continue;
                if (gcd(m, n) != 1) continue;

                long a = (long)m * m - (long)n * n; // x^2 - y^2
                long b = 2L * m * n;                // 2xy

                long w = Math.min(a, b);
                long h = Math.max(a, b);

                long p = 2L * (w + h);
                if (p <= maxL) perims.add((int)p);
            }
        }

        Collections.sort(perims);

        // 2) prefix sum 만들기 (prefix가 maxL 넘는 순간까지만 유지)
        long[] prefix = new long[perims.size()];
        long acc = 0;
        int usable = 0;
        for (int i = 0; i < perims.size(); i++) {
            acc += perims.get(i);
            prefix[i] = acc;
            if (acc <= maxL) usable = i + 1;
            else break; // 이후는 어차피 더 커지기만 함
        }
        if (usable < prefix.length) prefix = Arrays.copyOf(prefix, usable);

        // 3) 쿼리 처리: prefix <= L 인 개수
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int L = queries[i];
            int ans = upperBound(prefix, L);
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
