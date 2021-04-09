package Java42_0310;



//使用两个栈实现队列

import java.util.Stack;

class MyQueue {

    //首先创建两个栈
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();

    public MyQueue(){

    }

    public void push(int x) {
    //入队列的时候，需要先把 B 中的元素 倒腾到 A 中，再往 A 中插入新元素
        while(!B.isEmpty()) {
            int tem = B.pop();
            A.push(tem);
        }
        A.push(x);
    }

    public int pop(){
        //出队列的时候先判断 B 中的元素是否为空，
        if (A.isEmpty() && B.isEmpty()) {
           return 0;
        }
//        //把 A 中的元素往 B 中倒腾，剩下的最后一个元素就是要被出队列的元素
//        while(A.size() > 1) {
//            int tem = A.pop();
//            B.push(tem);
//        }
//        //此时取到的就是 A 的最后一个元素，也就是队首元素。
//        int ret = A.pop();

        //使用上面的代码，再连续使用户多次 pop/peek 的时候会存在问题
        //为了更优雅的解决问题，我们换个角度。先把 A 的所有元素都倒腾到 B 中。然后再通过 B 进行 pop
        while (!A.isEmpty()) {
            int tem = A.pop();
            B.push(tem);
        }
        //删除 B 中的元素
        return B.pop();
    }



    //取队首元素
    public int peek() {
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        //把 A 中的元素往 B 中倒腾，剩下的最后一个元素就是要被出队列的元素
        while (!A.isEmpty()) {
            int tem = A.pop();
            B.push(tem);
        }
        //删除 B 中的元素
        return B.peek();

        //清空队列元素
//        /** Returns whether the queue is empty.*/
//         public boolean empty() {
//             return   A.isEmpty() && B.isEmpty();
//        }


    }

//
//    private boolean empty() {
//        return A.isEmpty() && B.isEmpty();
//    }


    public static void main(String[] args) {
        //尝试在本地重现我们刚才的问题
        //按照人家给的用例，一步一步操作，看看是不是会有一样好的现象。
        MyQueue myqueue = new MyQueue();
        myqueue.push(1);
        myqueue.push(2);
        int ret = myqueue.peek();
        System.out.println("ret= " + ret);
        myqueue.pop();
        System.out.println("ret= " + ret);


    }

}
