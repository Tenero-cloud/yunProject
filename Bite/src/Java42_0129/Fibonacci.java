package Java42_0129;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字 : ");
        int num = scanner.nextInt();
        int ret = fibonacci(num);
        System.out.println(ret);

    }
    public static int fibonacci(int N) {
        if (N<2) {
            return N;
        }
        return fibonacci(N-1) * N;
    }
    //求第 N 个 fibonacci 数列的项是几
    public static int fib (int N) {
        if (N  == 1 || N == 2) {
            return 1;
        }
        return fib(N-1) + fib(N-2);
    }
}