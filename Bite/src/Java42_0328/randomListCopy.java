package Java42_0328;


import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class randomListCopy {
    public Node copyRandomList(Node head) {
        // 1.先遍历旧链表，把每个旧节点都创建对应的新节点，并且插入到 Map 中
        Map<Node,Node> map = new HashMap<>();
        for(Node cur = head; cur != null; cur = cur.next) {
            map.put(cur,new Node(cur.val));
        }
        // 2.再次遍历旧链表，构造 next/ random 的指向
        for (Node oldNode = head; oldNode != null; oldNode = oldNode.next) {
            //把 next 想回连接
            Node newNode = map.get(oldNode);
            Node newNodeNext = map.get(oldNode.next);
            newNode.next = newNodeNext;
            //把 random 相互连接
            Node newNodeRandom = map.get(oldNode.random);
            newNode.random = newNodeRandom;
        }
        return map.get(head);
    }




    //二、借助 Map 可以有更加方便的方案
    //1)遍历就链表，根据旧链表的值创建新节点，以旧节点为 key 新节点为 value
    //2) 再次遍历旧链表，给新节点的 next进行赋值
    //   例如，预期是 让新1。next = 新2
    //   可以通过map。get（旧1）=> 新1， map。get（旧1.next） =》新2
    //3）再次遍历旧链表，给新节点的 random进行赋值
    //   例如，新1.random = 新 3
    //   map.get (旧1) => 新1

//    public Node copyRandomList(Node head) {
//
//
//    }




}
