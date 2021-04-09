package java42_0308;


//使用链表来实现栈
class Node {
    int val;
    Node next;
    public Node(int val){
        this.val = val;
    }
}

public class MainStack2 {

    //此处使用不带傀儡节点的链表表示
    //如果使用带傀儡节点的链表的话，就更简单了
    private Node head = null;

    //核心操作
    //1. 入栈
    public void push(int val) {
        Node newNode = new Node(val);
        //把新结点进行头头插
        //由于当前是不带傀儡节点的，所以就需要判定当前链表是空还是非空
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }


    //2.出栈
    public Integer pop() {
        //进行头删。
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            int ret = head.val;
            head = null;
            return ret;
        }
        int ret = head.val;
        head = head.next;
        return ret;
    }


    //3. 取栈顶元素
    public Integer peek() {
        if (head ==null) {
            return null;
        }
        return head.val;
    }
}

