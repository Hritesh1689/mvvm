package com.agicent.mvvmdemo.Activity;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Stack;
@RequiresApi(api = Build.VERSION_CODES.N)
class Anothermaximumproblem {

    static class FastIO {
        private final InputStream is;
        private final byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public FastIO() {
            this(System.in);
        }

        public FastIO(final InputStream is) {
            this.is = is;
        }

        public int[] nextArray(final int n) {
            final int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public int read() {
            if (numChars == -1) {
                throw new RuntimeException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = is.read(buf);
                } catch (final IOException e) {
                    throw new RuntimeException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }

            return buf[curChar++];
        }

        public String nextLine() {
            return readLine();
        }

        public String readLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            final StringBuilder sb = new StringBuilder();
            do {
                sb.append(c);
                c = read();
            } while (!isEndOfLine(c));
            return sb.toString();
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            final StringBuilder sb = new StringBuilder();
            do {
                sb.append((char) c);
                c = read();
            } while (!isSpaceChar(c));
            return sb.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(final int c) {
            return (c == ' ') || (c == '\n') || (c == '\r') || (c == '\t') || (c == -1);
        }

        public boolean isEndOfLine(final int c) {
            return (c == '\n') || (c == '\r') || (c == -1);
        }
    }

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         //  br.n


        FastIO f = new FastIO();
        PrintWriter pw = new PrintWriter(System.out);
        int n = f.nextInt();
        int[] a = new int[n];
        long[] cPlace = new long[n];
        HashMap<Integer, Long> count = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            a[i] = f.nextInt();
            while (!st.empty() && a[st.peek()] <= a[i]) {
                int j = st.pop();
                long temp = count.getOrDefault(a[j], 0L);
                temp += (i - j) * cPlace[j] + (i - j);
                count.put(a[j], temp);
            }
            if (st.isEmpty()) {
                cPlace[i] = i;
            } else {
                int k = st.peek();
                cPlace[i] = i - k - 1;

            }
            st.push(i);
        }
        int k = n;
        while (!st.empty()) {
            int j = st.pop();
            long temp = count.getOrDefault(a[j], 0L);
            temp += (k-j) * cPlace[j] + (n-j);
            count.put(a[j], temp);
        }
        int t = f.nextInt();
        while (t-- > 0) {
            int x = f.nextInt();
            pw.println(count.getOrDefault(x, 0L));
        }
        pw.flush();
    }

}
