package java42_0308;

//使用顺序表实现栈
public class MainStack {
    private int[] data = new int[100];
    private int size = 0;

    //基本操作
    //入栈
    public void push(int val) {
        if(size >= data.length) {
            //在这里可以扩容
            return;
        }
        data[size] = val;
        size++;
    }
    //出栈。返回值就是出栈的那个元素
    public Integer pop() {
        if (size == 0) {
            return null;

        }
        //站定元素就是最后一个元素
        int ret = data [size-1];
        size--;
        return ret;
    }
    //3.取栈顶元素
    public Integer Peek() {
        if (size == 0) {
           return null;
        }
        return data[size-1];
    }
}
