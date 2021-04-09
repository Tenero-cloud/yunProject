package Exercise;

import java.util.Scanner;



public class test1 {
    private static int  Fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in) ;
        int N = scanner.nextInt();
        int i = 0;
        for (;i < N; i++) {
            if (Fibonacci(i) >= N) {
                break;
            }
        }
        int p = Math.abs(Fibonacci(i) - N);
        int q =Math.abs(Fibonacci(i-1) - N);
        if(p > q) {
            System.out.println(q);
        } else {
            System.out.println(p);
        }
    }
}
