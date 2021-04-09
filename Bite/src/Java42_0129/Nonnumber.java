package Java42_0129;

import java.util.Scanner;

public class Nonnumber {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个非负数： ");
        int n=sc.nextInt();
        int ret=add(n);
        System.out.println(ret);
        sc.close();
    }
    public static int add(int n){
        if(n<10){
            return n;
        }
        return n%10+add(n/10);
    }
}

