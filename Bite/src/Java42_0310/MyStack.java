package Java42_0310;

import java.util.LinkedList;
import java.util.Queue;

//使用两个队列实现栈

class MyStack {
    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();


    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        //入栈，直接往A中插入
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {

        //出栈的时候，把 A 中的元素往 B 中倒腾，当 A 中只有一个元素的时候，
        // 最后这个元素就是要删除的元素
        if (A.isEmpty() && B.isEmpty()) {
            //针对空栈的判定，题目给的是 integer ,没法返回 null ，只能随便返回个值了。
            //在线OJ 一定不要抛出异常，否则会被系统认定你代码出错！！！
            return 0;
        }
        while(A.size() >1) {
            int tem = A.poll();
            B.offer(tem);
        }
        //当上面的循环结束，此时A 中就只剩下一个元素了
        //把这个最后的元素作为出栈的元素
        int ret = A.poll();
        //最终完成操作之后，要交换 A 和 B 的身份。保证下次入栈的时候，还是往 A 中插入
        swapAB();
        return ret;
    }

    private void swapAB() {
        Queue<Integer> tem = A ;
        A = B;
        B = tem;
    }
    /** Get the top element. */
    public int top() {
        //取栈顶元素和出栈类似唯一的区别是，出栈操作是把A 的最后一个元素删除了
        //取栈顶元素是要把A 的最后一个元素还要再塞回到B中
        if (A.isEmpty() && B.isEmpty()) {
            //针对空栈的判定，题目给的是 integer ,没法返回 null ，只能随便返回个值了。
            //在线OJ 一定不要抛出异常，否则会被系统认定你代码出错！！！
            return 0;
        }
        while(A.size() >1) {
            int tem = A.poll();
            B.offer(tem);
        }
        //当上面的循环结束，此时A 中就只剩下一个元素了
        //把这个最后的元素作为出栈的元素
        int ret = A.poll();

        //这个操作是唯一的区别
        B.offer(ret);

        //最终完成操作之后，要交换 A 和 B 的身份。保证下次入栈的时候，还是往 A 中插入
        swapAB();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {

        return A.isEmpty() && B.isEmpty();
    }
}
