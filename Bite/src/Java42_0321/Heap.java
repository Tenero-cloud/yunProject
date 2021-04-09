package Java42_0321;

import java.util.Arrays;

public class Heap {
    //array 存储堆的数组
    //size 当前有效数组
    //index 从哪个位置开始向下调整
    public static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = 2 * parent + 1;
        while (index  < size) {
            //第一次比较，找出左右子树的最大值
            if (array[child + 1] < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            //希望这次调整结束后，无论如何 child 都指向左右子树的最大值
            //第二次比较，拿刚刚的 child 位置元素和parent 进行比较
            //若不符合。则交换
            if (array[parent] < array[child]) {
                int tem = array[parent];
                array[parent] = array[child];
                array[child] = tem;

            } else {
                break;
            }
            //更新循环变量
            parent =child;
            child = 2* parent+1;
        }
    }

    //时间复杂度 O（N）
    public static void creatHeap(int[] array) {
        //最后一个元素的下标是 legth -1;
        //目的是从Uzi后一个飞叶子几点开始循环
        //最后一个飞叶子接待正式最后一个节点的父节点
        for ( int i = (array.length -1 -1) /2; i >= 0; i--) {
            shiftDown(array,array.length,i);
        }
    }

    //为了让后序对操作方便操作，使用成员变量保存堆对应的
     private int[] data = new int[1000];
      private  int size = 0;
      private Heap(int[] data, int size) {
          this.size = size;

      }

            public void offer (int val) {
                if (size >= data.length) {
                    return;
                    //这里可以扩容
                }
                data[size] =val;
                size++;
                //2. 加入新元素，向上调整
             shiftUp(data, size, size - 1);

            }
            //取堆顶元素，树根节点，固定在数组元素下标为0 的元素
    //获取堆顶元素
    public Integer peek(){
          if (size == 0) {
              return null;
          }
          return data[0];
    }

    //删除堆顶元素
    //移形换影大法
    //1，把堆顶元素和最后一个元素互换，
    //2.size-- 删除最后一个元素
    //3.从0号位置，向下调整即可。
    public  Integer poll() {
          if (size == 0) {
              return null;
          }
          Integer result = data [0] ;
          //把最后一个元素和第一个元素互换
          //或者直接把最后一个元素赋值到第一个元素
        data[0] = data[size-1];
        //删除最后一个元素
        size--;
        //从 0 号元素开始进行调整
        shiftDown(data,size,0);
        return result;
    }

            public static void shiftUp (int[] array, int size, int index) {
                int child = index;
                int parent = (child -1) / 2;
                while (child >0) {
                    if (array[parent] < array[child]) {
                        int tem = array[parent];
                        array[parent] = array[child];
                        array[child] = tem;
                    } else  {
                        break;
                    }
                    child = parent;
                    parent = (child+1) /2;
                }
            }


    public static void main(String[] args) {
        int[] array = {4,9,5,2,8};
        creatHeap(array);

        Heap heap = new Heap(array, array.length);
        System.out.println();


        heap.offer(10);
        Integer result = heap.poll();

        System.out.println(Arrays.toString(array));


    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();


        stringBuilder.append("[");
                for (int i = 0; i < size; i++) {


                }


                stringBuilder.append("]");
                return null;
    }
}
