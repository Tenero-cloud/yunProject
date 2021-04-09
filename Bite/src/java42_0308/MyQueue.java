package java42_0308;

//使用链表实现队列
public class MyQueue {
   static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    //创建一个链表的头结点
    //为了方便进行尾插，也记录尾节点
    private Node head = null;
   private Node tail = null;


   //队列的核心操作
    // 1. 入队列。 返回值表示插入成功/失败（也是为了和标准队列的 offer 接口看齐）
    public boolean offer(int val) {

        Node newNode = new Node(val);
        //插入到链表尾部。需要考虑当前链表是否为空
        if (head == null) {
            //直接让 head 和 tail 指向新节点即可
            head = newNode;
            tail = newNode;
            return true;

        }
        tail.next = newNode;
        tail = tail.next;
        return true;

    }



    //2. 出队列
    public Integer poll() {
        if  (head == null) {
            return null;
        }
        int ret = head.val;
        if (head.next == null) {
            head = null;
            return ret;
        }
        head = head.next;
        return ret;
    }



    //3.取栈顶元素


    public static void main(String[] args) {
        //测试一下入队出队操作
        MyQueue myQueue = new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);

        Integer ret = null;
        ret = myQueue.poll();
        System.out.println("ret=" + ret);
        ret = myQueue.poll();
        System.out.println("ret=" + ret);
        ret = myQueue.poll();
        System.out.println("ret=" + ret);
        ret = myQueue.poll();
        System.out.println("ret=" + ret);
        ret = myQueue.poll();
        System.out.println("ret=" + ret);

    }
}
