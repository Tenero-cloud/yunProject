package Java42_0323;

import java.util.Arrays;
import java.util.Stack;

public class MySort {

    //2.希尔排序，空间复杂度 O（1），不稳定排序。
    public static void shellSort(int[] arr){
        //现制定 gap 序列，此处使用希尔序列
        int gap = arr.length/2;
        while(gap >= 1) {
            //通过这个辅助方法，进行分组插排
            _shellSort(arr,gap);
            gap = gap / 2;
        }

    }
    public static void _shellSort(int[] arr,int gap ) {
        //分组的时候，同组中的相邻元素的下表差就是 gap
        //注意取的顺序，先取 0 组元素中的第 1 个元素，尝试往前插入排序
        //注意取的顺序，先取 1 组元素中的第 1 个元素，尝试往前插入排序
        //注意取的顺序，先取 2 组元素中的第 1 个元素，尝试往前插入排序
        //....
        //再取第 0 组元素中的 第2 个元素，尝试往前插入排序
        for(int bound = gap; bound < arr.length; bound++) {
            //循环内部完成比较搬运的 过程
            //比较搬运的是组呢你的元素，不同组之间不能相互会影响
            int v= arr[bound];
            int cur = bound - gap ;

            for(;cur >= 0; cur -= gap) {
                if (arr[cur] > v) {
                    //需要进行搬运
                    //v 要插入到 arr[cur] 的前面
                    //就得把 、arr[cur] 往后搬运一个格子 给 v 腾出一个位置
                    arr[cur + gap] = arr[cur];
                } else {
                    break;
                }
            }
            //若发现 v 比 arr[cur] 大，就把 v 放到arr[cur]的后米N
            //后面的位置不是 arr[cur]+1 而是 arr[cur]+ gap;
            arr[cur +gap] = v;
        }
    }



    //3.选择排序，核心思路：基于打擂台的思想，每次从待排序区间，取出最小值，
    //放到擂台上（擂台就是待排序区间的最开始的位置）
    //空间复杂度 O（1），不稳定排序
    public static void selectSort(int[] arr) {
        //[0,bound)已排序区间
    //[bound arr，length） 带排序区间
        int bound = 0;
        for (; bound < arr.length; bound++) {
            //里层循环打擂台
            for(int cur = bound + 1; cur <arr.length; cur++) {
                //擂台就是bound 位置的元素
                //取cur位置和擂台进行比较
                if (arr[cur] < arr[bound]) {
                    //新元素胜出了，就需要交换两个元素的位置
                    swap(arr, cur, bound);
                }
            }
        }
}
    public static void swap(int[] arr, int cur, int bound) {

        int tem = arr[cur];
         arr[cur] = arr[bound];
         arr[bound] = tem;

}
    //4、堆排序
    //堆排序可以理解为是一种选择排序的优化~
    //直观上。如果是升序排序的话，我们可以建立一个小堆。每次取堆顶元素，循环取 N 次。就得到了一个有序排序
    //建立一个大堆，把对顶元素（当前最大值），和数组最后一个元素交换（最大值来到了数组末尾）。
    //前面的部分从 0 进行调整。
    //1、建堆，
    //2、先把根节点和最后一个元素进行交换，并且把最后一个元素从堆上删除。此时最后一个元素就是已排序区间，前面是待区间
    //3、继续 2 步骤，若干次之后，排序完成
    public static void heapSort(int[] arr) {
        //1、先进行建堆
        createHeap(arr);
        //2. 循环进行交换堆顶元素和最后一个元素的过程，并且删除最后一个元素
        int heapSize = arr.length;
        for(int i = 0; i < arr.length; i++) {
            swap(arr,0,heapSize-1);
            //删除最后一个元素
            heapSize--;
            //从 0 这个元素进行向下调整
            shiftDown(arr,heapSize,0);
        }
    }
    public static void shiftDown(int[] arr, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (child  < size) {
            //第一次比较，找出左右子树的最大值
            if (arr[child + 1] < size && arr[child + 1] > arr[child]) {
                child = child + 1;
            }
            //希望这次调整结束后，无论如何 child 都指向左右子树的最大值
            //第二次比较，拿刚刚的 child 位置元素和parent 进行比较
            //若不符合。则交换
            if (arr[parent] < arr[child]) {
                int tem = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tem;

            } else {
                break;
            }
            //更新循环变量
            parent =child;
            child = 2* parent+1;
        }
}
    public static void createHeap(int[] arr) {
      for (int i = (arr.length - 1-1) / 2; i >= 0; i--) {
          shiftDown(arr, arr.length, i);
      }
}
    //5、冒泡泡排序
    //时间复杂度O（N^2）,空间复杂度O（1）,稳定排序
    //基本思路
    //比较两个相邻的元素，看是否符合升序要求，不符合就交换，
    //一趟遍历下来就能找到最大值（从前往后遍历）
    //一趟遍历下来就能找到最小值（从后往前遍历）
    public static void BubbleSort(int[] arr) {

        //[0,bound)已排序区间
        //[bound，length)待排序区间
        int bound = 0;
        for (; bound < arr.length; bound++) {

            for(int cur = arr.length-1; cur > bound; cur--) {
                if (arr[cur]<arr[cur-1]) {
                    //不符合升序，交换
                    swap(arr, cur, cur-1);
                }
            }
        }
    }
    //6、快速排序
    public static void quickSort(int[] arr) {
        //使用一个附中方法进行递归
        //辅助方法多多了两个参数，用来针对数组上的哪个区间
        _quickSort(arr,0,arr.length-1);
    }
    public static void _quickSort(int[] arr, int left, int right) {
        if(left >= right) {
            return;
        }
        //使用 partition 方法来进行整理
        //index是left和right的重合位置
        int index= partition (arr,left, right);
        _quickSort(arr,left,index -1);
        _quickSort(arr,index+1,right);
    }
    public static  int partition(int[] arr, int left, int right) {
        //选取基准值
        int v = arr[right];
        int i = left;
        int j = right;

        //如果是先从左往右，后重右往左找，重合的时候 ij 指向的一定是比 ij 大的元素
        //如果是先重右往左找，后从左往右 重合的时候 ij 指向的一定是比 ij 小的元素

        while(i <j) {
            //从做往右找一个比基准值大的元素
            while(i < j &&arr[i] <= v) {
                i++;
            }
            //从右往左找一个比基准值小的元素
            while(i <j && arr[j] >= v) {
                j--;
            }
            swap(arr, i, j);
        }
        //若 i 和 j 重叠了。此时需要把当前基准值元素和 i j重叠位置进行交换
        //当 i  和 j 重合是的时候， i j 一定指向的元素是比基准值大的元素。！！！
        swap(arr, i,right);
        return i;
    }
    public static void quickSortByLoop(int[] arr) {
    //1、创建一个栈
        Stack<Integer> stack = new Stack<>();
    //2、把第一组要去处理的区间入栈
        stack.push(0);
        stack.push(arr.length-1);
    //3、循环取栈顶的元素的区间，进行 partition操作
    while(!stack.isEmpty()) {
        int end = stack.pop();
        int beg = stack.pop();
        if (beg >= end) {
            //只有哦一个元素/空区间，不需要处理
            continue;
        }
        //4.调用， partition 方法 进行调整
        int index= partition(arr, beg, end);
        //5、 把得到的子区间在入栈
        //[beg,index-1]  [index+1.end]
        stack.push(index + 1);
        stack.push(end);

        stack.push(beg);
        stack.push(index-1);
    }
}


    //7.归并排序
    public static void mergeSort(int[] arr) {
        //创建一个新的方法辅助递归，新方法中多了两个参数、
        //表示是针对当前数组中的哪个部分进行排序
        //也是一个前闭后开区间
        _mergeSort(arr,0,arr.length);
    }
    //[left ,right) 前闭后开区间
    //right - left 区间中的元素个数
    public static void _mergeSort(int[] arr,int left, int right) {
        if (right - left <= 1) {
            //如果当前待排序区间里只有 1 个元素或者没有元素
            //就直接返回。不需要任何排序动作
            return;
        }
        //先把当前 [left,right) 区间一分为二
        int mid = (left + right) / 2;
        // 分成了两个区间
        // [left， mid), [mid,right)
        //当左侧区间的 _mergeSort 执行完毕后，
        // 就认为 [left, mid）就已经是有序区间了
        _mergeSort(arr, left, mid);
        //当右侧区间的 _mergeSort 执行完毕后，
        // 就认为 [mid， right）就已经是有序区间了
        _mergeSort(arr,mid,right);
        //接下来把两个有序数组合并到一起
        merge(arr,left,mid,right);
    }
    // merge 方法本身功能是把两个有序数组合并成一个有序数组
    //待合并的两个数组就分别是：
    //[left,mid）、[mid,right）
    public static void merge(int[] arr, int left, int mid, int right) {
        //创建一个临时的数组，用来存放临时的合并结果。
        //希望这个数组能存下合并后的结果 right - left
        int[] tem = new int[right - left];
        //当前要把新的元素放到 tem 数组的哪个下标（temSize）上
        int temSize = 0;
        int l = left;
        int r = mid;
        while (l <mid && r <right) {
            //归并排序是稳定排序！！！
            // 前提是，此处的判断条件不要写成 arr[l] < arr[r];
            if (arr[l] <= arr[r]) {
                //arr[l] 比较小，就把这个元素先插入到 tem 数组末尾
                tem[temSize] = arr[l];
                temSize++;
                l++;
            } else {
                //arr[r] 比较小，就把这个元素插入到 tem 数组的末尾
                tem[temSize] = arr[r];
                temSize++;
                r++;
            }
        }
        //当其中一个数组遍历完了之后，就把另外一个数组的剩余部分都拷贝过来
        while (l < mid) {
            //剩下的是左半边数组
            tem[temSize] = arr[l];
            temSize++;
            l++;
        }
        while (r < right) {
            //剩下的是右半边数组
            tem[temSize] = arr[r];
            temSize++;
            r++;
        }
        //最后一步，再把临时空间的内容都拷贝回参数数组中
        //需要把 tem 中的内容拷贝回 arr 的 [left ,right) 这一段空间里
        // [left ,right) 很可能不是从 0 开始的
        for (int i = 0; i < tem.length; i++) {
            arr[left +i] = tem[i];
        }
    }

    //7.1 归并排序的非递归实现
    public static void mergeSortByLoop(int[] arr) {
        //gap 就表示当前待合并的有序数组的长度
        for (int gap = 1; gap < arr.length; gap *= 2 ) {
            //外层循环：
            // 第一次是把所有长度为 1 的有序数组两两合并
            //第二次是把所有长度为 2 的所有有序数组两两合并
            //第三次是把所有长度为 4 的有序数组两两合并
            for (int i = 0; i < arr.length; i += 2*gap) {
                //里层循环执行一次就是让两个 gap 长的相邻数组合并一次，
                //两个数组分别就是 [left, mid) 和 [mid, right)
                int left = i;
                int mid = i + gap;
                if (mid >= arr.length) {
                    mid = arr.length;
                }
                int right = i + 2 * gap;
                if (right >= arr.length) {
                    right = arr.length;
                }
                merge(arr, left, mid, right);
            }
        }
    }



    public static void main(String[] args) {
        int[] arr = {4,5,7,8,9,2,3};
//        shellSort(arr);
//        selectSort(arr);
//        heapSort(arr);
//        BubbleSort(arr);
//        quickSort(arr);
//        quickSortByLoop(arr);
//        mergeSort(arr);
        mergeSortByLoop(arr);
        System.out.println(Arrays.toString(arr));
    }
}
