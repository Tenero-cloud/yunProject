package Java42_0328;

class HashNode {
    public int key;
    public int value;
    public HashNode next;

    public HashNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
// 开散列/哈希桶的方式来处理哈希冲突
public class MyHashMap {

    private HashNode[] array = new HashNode[16];
    private int size = 0;//当前hash表中一共有多少个元素


    public void put(int key, int value) {
        //1.先把 key 转成数组下标
        //  这里简单粗暴的使用除留取余的方式来计算 hash
        //  实际开发中会有一些更加高效的哈希函数。
        int index = key % array.length;
        //2. 先遍历该位置的链表，看看 key 是不是已经存在了
        //   如果 key 已经存在，就不必插入新的节点，直接修改 value 即可。
        for (HashNode cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key == key) {
                //找到了 key， 直接修改 value；
                cur.value = value;
                return;
            }
        }
        //3. 如果不存在相同的key 就创建一个新节点
        HashNode newNode = new HashNode(key, value);
        //   直接链表头插即可
        newNode.next = array[index];
        array[index] = newNode;
        size++;

        //4. 判定 size 是否达到一定的数值，如果达到数值就扩容
        //这里的负载因子达到多少才扩容呢？最好根据实际情况，做实验试试。
        //负载因子越小，此时空间利用率越低
        //负载因子越大，此时性能可能就会收到影响。
        //此处的 0.75 ,java 标准库的 HashMap 负载因子阈值的默认值就是 0.75
        if (loadFactor() > 0.75) {
            resize();
        }
    }

    private void resize() {
        //创建一个正常的数组，把我们原来的数组拷贝进去
        HashNode[] newArray = new HashNode[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            //遍历当前链表
            HashNode next = null;
            for (HashNode cur = array[i]; cur != null; cur = next) {
                cur = cur.next;//修改 cur.next 之前，先备份之前的位置
                //把当前 cur 指向的节点插入到新的数组上
                int indexNew = cur.key % newArray.length;
                //头插操作
                cur.next = newArray[indexNew];
                newArray[indexNew] = cur;

            }
        }
    }

    private double loadFactor(){
        return (double)size / array.length;
    }

    public Integer get(int key) {
        //先根据 key 计算得到一个 index
        //在遍历链表记即可
        int index = key % array.length;
        for (HashNode cur = array[index]; cur != null; cur = cur.next){
            if (cur.key == key) {
                return cur.value;
            }
        }
        return null;
    }
}
