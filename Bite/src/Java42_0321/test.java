package Java42_0321;

import java.util.Comparator;
import java.util.PriorityQueue;
class BoyFriend implements Comparable<BoyFriend>{
    //    implements Comparable<BoyFriend>
    public String name;
    public int money; //资产
    public int face; //颜值

    public BoyFriend(String name, int money, int face) {
        this.name = name;
        this.money = money;
        this.face = face;
    }

    @Override
    public int compareTo(BoyFriend o) {
        return o.face-this.face;
    }
}
//    class BoyFriendComprator implements Comparator<BoyFriend> {
//        @Override
//        public int compare(BoyFriend o1, BoyFriend o2) {
//            return o1.money - o2.money;
//        }
//    }


    public class test {
        //    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.offer(9);
//        queue.offer(5);
//        queue.offer(2);
//        queue.offer(7);
//
//        while (!queue.isEmpty()) {
//            Integer cur = queue.poll();
//            System.out.println( cur);
//        }
//    }
        public static void main(String[] args) {
            PriorityQueue<BoyFriend> queue = new PriorityQueue<>();

            queue.offer(new BoyFriend("马云", 1000, 5));
            queue.offer(new BoyFriend("蔡徐坤", 500, 7));
            queue.offer(new BoyFriend("汤老湿", 50, 6));

            while (!queue.isEmpty()) {
               BoyFriend boy = queue.poll();
               System.out.println(boy.name);
            }
        }

    }

