package Exercise;

import java.util.Scanner;

public class Method {



    //1、在同一个类中定义多个方法：要求不仅可以求两个整数的最大值，
    // 还可以求两个小数的最大值，以及两个小数和一个整数的大小关系

    public static void main(String[] args) {
        System.out.println("请输入两个任意整数 ：");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("MAX1=" + Max1(a,b));
        System.out.println("请输入两个任意小数 ：");
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        System.out.println("Max2=" + Max2(c,d));
        System.out.println("请输入三个任意小数 ：");
        double r = scanner.nextDouble();
        double y = scanner.nextDouble();
        double x = scanner.nextDouble();
        System.out.println("Max=" +Max3(r,y,x));
    }
    public static int Max1(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    public static double Max2(double c, double d) {
        if (c >=d) {
            return c;
        }
        return d;
    }

    public static double Max3(double r, double y, double x) {
        double tem1 = Max2(r, y );
        if (x >Max2(r,y)) {
            return x;
        }
        return Max2(r,y);

    }



}
