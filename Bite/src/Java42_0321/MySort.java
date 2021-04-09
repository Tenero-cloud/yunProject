package Java42_0321;

import java.util.Arrays;

public class MySort {

    //两个性质！
    // a) 若当前数组很短，这时速度很快~~
    // b) 若当前数组相对有序，这个时候速度也很快~~
    //插入排序的改进排序。shell排序

    //1.插入排序是一个稳定排序,时间复杂度 O（N^2）,空间复杂度O（1）。（只有三个额外的临时变量，bound, v, cur）
    public static  void insetSort(int [] arr) {
        //这个循环控制代码进行N次插入过程
        int bound = 1;
        for (;bound < arr.length ; bound++) {
            //循环内部实现插入一次的过程
            //需要找到待排序区间的一个元素，放哪里合适，并且搬运
            //已排序区间：【 0,bound）
            //带排序区间【bound length）
            //出的 v 就是第一个人元素。要插入的元素
            int v = arr[bound];
            int cur = bound-1;
            for(; cur >= 0; cur--){
                if (arr[cur] > v){ //改成小于，就是降序排序。（不加等于号，排序稳定，若加了等于号就不是稳定排序了）
                    //如果 cur 大于 v
                    //将 v 插入 arr[cur] 的前面
                    //将 arr[cur] 搬运位置
                    arr[cur+1] = arr[cur];
                } else {
                    //此时找到了要排序的位置
                 break;
                }
            }
            arr[cur +1] = v;
        }

    }

    public static void main(String[] args) {
        int[] arr={9,5,3,7,2,8};
        insetSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

