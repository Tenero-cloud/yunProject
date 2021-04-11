package Java42_0203;

import static jdk.nashorn.internal.objects.Global.print;

public class Main {
    public static Node createList() {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;
        return a;
    }

    //带傀儡节点的链表
    //本质区别就在于傀儡节点中值是不使用的。
    //认为下面的链表长度是 4 。
//    public static Node createListWithDummy() {
//        Node dummy = new Node(0);
//        Node a = new Node(1);
//        Node b = new Node(2);
//        Node c = new Node(3);
//        Node d = new Node(4);
//        dummy.next = a;
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = null;
//
//        return dummy;
//    }

    //尾插一个节点
    public static void insertTail(Node head, int val){
        //1. 先找到末尾节点
        if (head == null) {
            return;
        }
        Node prve = head;
        while (prve.next !=null ) {
            prve = prve.next;
        }
        //循环结束后 cur 就是最后一个节点了
        Node newNode = new Node(100);
        newNode.next = prve.next;
        prve.next = newNode;
    }

    //删除节点，此处是按照值来删除 时间复杂度 O（N）
//    public static void remove(Node head, int value){
//        //1.先找到 val 这个值对应的位置
//        //  同时也要找到 val 的前一个位置。
//        Node prev = head;
////        if (prev == null) {
////            return;
////        }
//        while(prev != null
//                && prev.next != null
//                && prev.next.val != value) {
//            prev = prev.next;
//        }
//        //循环结束之后，prev 就指向我们待删除节点的前一个节点了
//        if(prev == null || prev.next == null){
//            //表示没有找到值为 val 的节点
//            return;
//        }
//        //2.真正进行删除, toDelete 指向待删除节点
//        Node toDelete = prev.next;
//        prev.next = toDelete.next;
//    }

    //删除节点，此处是按照位置来删除 时间复杂度 O（N）
//    public static void remove2(Node head, Node value){
//        //1.先找到待删除节点的前一个节点
//        Node prev = head;
//        while (prev != null && prev.next != value){
//            prev = prev.next;
//        }
//        if(prev == null) {
//            //没找到
//            return;
//        }
//        //2.进行删除
//        prev.next = value.next;
//    }


    //删除更高效的方法
    //这个方法有一个重要的局限性！！就是无法处理最后一个节点！！
    public static void remove3(Node head, Node toDelete) {
        Node nextNode = toDelete.next;
        toDelete.val = nextNode.val;
        toDelete.next = nextNode.next;
    }


    public static int size(Node head) {
        int size =0;
        for(Node cur = head; cur != null; cur = cur.next) {
            size++;
        }
        return size;
    }


    //按照给定节点下标来删除
    public static void remove4(Node head, int index) {

        if( index < 0 || index >= size(head)) {
            return;
        }
        //如果 index 为 0 ，意味着要删除头结点（一会儿再考虑）

        if(index == 0) {
            // TODO
        }
        //1.先找到待删除元素的前一个节点的位置，就是 index -1 这个节点
        Node prev = head;
        for(int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //循环结束之后，prev就指向了待删除节点的前一个位置
        //2.真正的进行删除
        Node toDelete = prev.next;
        prev.next = toDelete.next;
    }


    public static void main(String[] args) {
        //删除节点
        Node head = createList();
        Node toDelete = head.next.next;
        remove3(head,toDelete);
        System.out.println(print(head));

        //一、不带傀儡节点链表的操作
//        Node head = createList();
//        // 0）创建新节点
//        Node newNode = new Node(100);
//
//
//        //1.把节点插入到 1 和 2 之间，
//        Node one = head;
//        // 1）先把 newNode 的 next 指向 one 的 next
//        newNode.next = one.next;
//        // 2) 再把 one 的 next 指向 newNode
//        one.next = newNode;
//
//        //2.把节点插入到链表头部
//        // 1) 让新节点的 next 指向 head;
//        newNode.next = head;
//        // 2) 再让 head 指向新节点
//        head = newNode;

        //3.链表插入到节点尾部（带头结点和不带头节点，差别不大）
//
//        Node head = createList();
//        insertTail(head,100);



        //4.



        //5.


        //二、带傀儡节点的链表操作
//        Node head = createListWithDummy();//head指向傀儡节点
//
//        //0.创建一个新节点
//        Node newNode = new Node(100);

        //1.往中间某个位置插入，需要知道待插入位置的前一个节点
        //  例如，还是给 1,2 之间插入
        //   prev就是指向 1 这个元素位置 它就是表示插入位置的前一个元素的位置。
//        Node prev = head.next;
//        newNode.next = prev.next;
//        prev.next = newNode;


        //2.头插：往链表头部插入（由于是带傀儡节点，其实是插入到 head 的后面）
//        Node prev = head;
//        newNode.next = prev.next;
//        prev.next = newNode;



    }
}
