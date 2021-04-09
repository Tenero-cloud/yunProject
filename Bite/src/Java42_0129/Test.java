package Java42_0129;

import java.util.Scanner;

public class Test {
    public static int factoral(int N){
        if(N<2) {
            return N;
        }
        return factoral(N-1) * N;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数字:");
        int num = scanner.nextInt();
        int ret = factoral(num);
        System.out.println(ret);
    }
}
