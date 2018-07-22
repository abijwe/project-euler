package util;

public class Arithmetic {

    public static long sumN(int n) {
        return n * (n+1) / 2;
    }

    public static long sumNSquare(int n) {
        return n * (n+1) * (2*n + 1) / 6;
    }

    public static long sumNCube(int n) {
        return n * n * (n + 1) * (n + 1) / 4;
    }
}
