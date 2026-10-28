package test1;

import java.io.InputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int n = sc.nextInt();
        if (n == -1) return; // 处理无输入的情况

        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        int MOD = 998244353;
        long[] inv = new long[n + 1];
        if (n >= 1) inv[1] = 1;
        for (int i = 2; i <= n; i++) {
            inv[i] = (MOD - MOD / i) * inv[MOD % i] % MOD;
        }
        long[] H = new long[n + 1];
        H[0] = 0;
        for (int i = 1; i <= n; i++) {
            H[i] = (H[i - 1] + inv[i]) % MOD;
        }
        long[] C = new long[n + 1];
        C[1] = H[n];
        for (int i = 2; i <= n; i++) {
            // C[i] = C[i-1] + H[N - i + 1] - H[i - 1]
            C[i] = (C[i - 1] + H[n - i + 1] - H[i - 1]) % MOD;
            if (C[i] < 0) {
                C[i] += MOD;
            }
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = (ans + a[i - 1] * C[i]) % MOD;
        }
        System.out.println(ans);
    }
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1024 * 64];
        private int head = 0;
        private int tail = 0;
        public FastScanner(InputStream in) {
            this.in = in;
        }
        private int read() {
            if (head >= tail) {
                head = 0;
                try {
                    tail = in.read(buffer, 0, buffer.length);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (tail <= 0) return -1;
            }
            return buffer[head++];
        }
        public long nextLong() {
            int c = read();
            while (c <= 32) {
                if (c == -1) return -1;
                c = read();
            }
            long res = 0;
            while (c > 32) {
                if (c < '0' || c > '9') {
                    throw new RuntimeException("Invalid digit");
                }
                res = res * 10 + c - '0';
                c = read();
            }
            return res;
        }
        public int nextInt() {
            return (int) nextLong();
        }
    }
}