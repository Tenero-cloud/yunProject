package Exercise;

import java.util.Scanner;

public class ArraryOrder {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5,7};
        frequency(arr);
    }

    public static void frequency(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int count = 0;//判断出现次数

            for (int j = 0; j < a.length; j++) {
                if (a[i] == a[j]) count++;
            }
            if (count == 1)
                System.out.println("只出现一次的数字是:" + a[i]);//只出现一次则输出该数据

        }
    }
}




//        public static void main(String[] args) {
//            Scanner sc=new  Scanner(System.in);
//            System.out.println("请输入数字 n :");
//            int n=sc.nextInt();
//            int i;
//            int sum=1;
//            int result=0;
//            for(i=1;i<=n;i++){
//                sum*=i;
//                result+=sum;
//            }
//            System.out.println(result);
//            sc.close();
//        }
//}



//    //求N 的阶乘
//    public static int factoral(int N) {
//        if ( N < 2) {
//            return N;
//        }
//        return factoral(N * (N-1) );
//    }
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入你想求阶乘的数字 ：");
//        int num = scanner.nextInt();
//        int ret = factoral(num);
//        System.out.println(ret);
//    }
//
//}

//
//
//    public static int factoral(int N){
//        if(N<2) {
//            return N;
//        }
//        return factoral(N-1) * N;
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入数字:");
//        int num = scanner.nextInt();
//        int ret = factoral(num);
//        System.out.println(ret);
//    }
//}




//调整数组顺序使得奇数位于偶数之前。调整之后，不关心大小顺序
//    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,7,8,9};
//
//        for (int i = 0; i < arr.length-1; i++ ) {
//            for (int j = 0;j < arr.length-1-i;j++) {
//                if (arr[j] % 2 == 0) {
//                    int tem = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = tem;
//                }
//            }
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] +" ");
//        }
//    }

