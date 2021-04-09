package Java42_0131;
import java.util.*;

public class PockGame {
    //使用这个数组把这四种花色都提前准备好。
    public static  final String[] suits = {"♥","♠","♣","♦"};

    private static List<Card> buyPoker() {
        List<Card> poker = new ArrayList<>();
        //这个循环处理四种花色
        for (int i = 0; i < 4; i++) {
            //里面处理每种花色的 13 张牌
            for(int j = 2; j <= 10; j++) {
                poker.add(new Card(suits[i],String.valueOf(j)));
                //int 转 String  第二种方法 “ ” +j;
            }
            poker.add(new Card(suits[i],"J"));
            poker.add(new Card(suits[i],"Q"));
            poker.add(new Card(suits[i],"K"));
            poker.add(new Card(suits[i],"A"));
        }
        poker.add(new Card(""," big Joker"));
        poker.add(new Card("","small Joker"));
        return poker;
    }


    //洗牌
    //List 自身是可变对象， 直接修改 poker 的内容就会对 List 本身造成影响。
    //就不需要额外返回 List<Card>
    private static void shuffle(List<Card> poker){
        Random random = new Random();
        for(int i = poker.size()-1; i >0; i--) {
            //产生[0.i）的随机数，要和哪个位置的元素交换
            int pos = random.nextInt(i);
            swap(poker,i,pos);
        }
    }
    public static void  swap(List<Card> poker, int i, int j) {
        Card tem = poker.get(i);
        poker.set(i,poker.get(j));

    }

    public static void main(String[] args) {
        //1. 先创建吗出一幅扑克牌
        List<Card> poker = buyPoker();
        System.out.println(poker);
        //洗牌 实际可以用标准库里面自带的洗牌方法，可以直接拿来使用
//        shuffle(poker);
        Collections.shuffle(poker);
        System.out.println(poker);
        //3. 发牌，假设有三个玩家，每个玩家，给发 5 张牌
        //每个玩家手里有 5 张牌，这 5 张牌就使用另一个 ArrayList 表示
        //此时可以把这三个玩家也放到一个 List 中
//        List<Card> player1 = new ArrayList<>();
//        List<Card> player2 = new ArrayList<>();
//        List<Card> player3 = new ArrayList<>();
        //players 类型上仍然是 List,泛型参数，是一个 List<Card> , 每个元素就是一个 List<Card> 。
        List<List<Card>> players = new ArrayList<>();
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        players.add(new ArrayList<>());
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card top = poker.remove(0);
               List<Card> player = players.get(j);
               player.add(top);
            }
        }

        //4. 展示手牌
        for (int i = 0; i < players.size(); i++) {
            List<Card> player = players.get(i);
            System.out.println("玩家" + i + "的手牌是：" + player);
        }
    }
}
