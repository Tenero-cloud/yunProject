package Java42_0328;


class BinaryNode {
    public int key;
    public int value;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode(int key, int value) {
        this.key = key;
        this.value = value;

    }
}
public class BinarySearchTree {

    //1、查找
    //空树用 null 表示
    BinaryNode root = null;

    public Integer get(int key) {

        BinaryNode  cur = root;
        //创建一个引用 cur 从根节点出发
        //当树非空时，判断 key 和 cur.key的值，再决定走哪个方向
        while(cur != null) {
            if (key < cur.key) {
                //往左子树走
                cur= cur.left;
            } else if (key > cur.key) {
                cur = cur.right;
            } else {
                //找到了
                return cur.key;
            }
        }
        //若遍历完循环出来都没找到说明没有找到
        return null;
    }

    //2、插入
    //让 cur 从根节点开始出发，找到一个合适的插入位置
    public void put(int key, int value) {
        BinaryNode  cur = root;
        if (cur == root) {
            return;
        }

    }




    //3、删除
}
