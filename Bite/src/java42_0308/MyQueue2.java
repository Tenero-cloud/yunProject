package java42_0308;


//使用数组来实现环形队列
public class MyQueue2 {
    private int[] data = new int[100];
    private int head = 0;
    private int tail = 0;
    private int size = 0;


    //核心操作
    //1.入队列
    public boolean offer(int val) {
        if (size == data.length) {
            //队列满了，此处也可以实现扩容逻辑。
            return false;
        }
        //把新元素放到 tail 对应的下标上，
        data[tail] = val;
        //自增 tail
        tail++;
        //一旦 tail 达到了数组的末尾，就需要让 tail 从头开始
        if (tail ==data.length) {
        tail = 0;
        }
        //这个代码还可以写作
        //tail = tail % data.length;
        //更新 size 的值
        size++;
        return true;
    }

    //2. 出队列
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        int ret = data[head];
        //更新 head 的位置
        head++;
        if (head == data.length) {
            head = 0;
        }
        size--;
        return ret;
    }

    //3. 取栈顶元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return data[head];
    }
}
