package util;

public class PrettyPrint {

    public static <T> void printResult(T result) {
        System.out.println("Result=" + result);
    }

    public static void printTimeMs(long time) {
        System.out.println("Elapsed time = " + time + " ms");
    }
}
