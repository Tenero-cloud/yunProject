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
    private BinaryNode root = null;

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
        if (root == null) {
            //直接把新节点挂到 root 上即可
            root = new BinaryNode(key,value);
            return;
        }

        //创建一个 cur 从 root 出发，找到 一个合适的插入位置。
        BinaryNode  cur = root;
        BinaryNode  parent = null;//记录 cur 的父节点，
        while (cur !=null) {
            if(key < cur.key){
                parent = cur;
                cur = cur.left;
            }else if (key > cur.key) {
                parent = cur;
                cur = cur.right;
            } else {
                //当 key 相同时，并不真的插入新节点
                //而是用 value 来替换旧的节点的值
                cur.value = value;
                return;
            }
        }

        //当循环结束 cur 为空，说明已经找到了要插入的位置
        //cur 为空的时候就说明新节点要插入到parent下面
        BinaryNode newNode = new BinaryNode(key,value);
        if (newNode.key < parent.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }




    //3、删除节点
    public void remove(int key){
        //1.先查找待删除节点的位置，也需要同步记录该节点的父节点信息
        BinaryNode cur = root;
        BinaryNode parent = null;
        while (cur != null) {
            if (key < cur.key) {
                //往左走
                parent = cur;
                cur = cur.left;
            } else if (key >cur.key) {
                //往右走
                parent = cur;
                cur = cur.right;
            } else {
                //key 相等，找到了待删除节点
                //2.key 相等，找到了待删除节点
                removeNode(parent,cur);
                return;
            }
        }
    }
    //由于当前的 removeNode 方法只是给类自己的 remove 方法来使用的
    //没有其他用途了，所以不应该暴露到类的外部
    private void removeNode(BinaryNode parent,BinaryNode cur) {
        if(cur.left == null){
            //1.待删除节点的左子树为null
            if(cur == root ){
                //待删除节点正是根节点
                root = cur.right;
            } else if (cur == parent.left) {
                //1.2 待删除节点不是树根，且是父亲的左子树
                parent.left = cur.right;
            } else if (cur == parent.right) {
                //1.3 待删除节点不是树根且，是父亲的右子树
            }
        } else if (cur.right == null) {
            //2.待删除节点的右子树为 null
            if (cur == null) {
                //2.1 待删除节点正是根节点
                root = cur.left;
            } else if (cur == parent.left) {
                //2.2 待删除节点不是根节点，且为父亲的左子树
                parent.left = cur.left;
            } else if (cur == parent.right) {
                //2.3 待删除节点不是根节点，且为父亲的右子树
                parent.right = cur.left;
            }
        } else {
            //3.左右子树都存在的情况
            //  需要在右子树中找到最小值，作为替罪羊节点
            //  把替罪羊节的 key 和 value 赋值给待删除节点
            //  删除替罪羊节点即可
            BinaryNode goat = cur.right;
            BinaryNode goatParengt = cur;
            while (goat.left != null) {
                goatParengt = goat;
                goat = goat.left;
            }
             cur.key = goat.key;
             cur.value = goat.value;
             //删除替罪羊节点，根据替罪羊是左右子树来采取不同的删除方式
            if (goat == goatParengt.left) {
                goatParengt.left = goat.left;
            } else {
                goatParengt.right = goat.right;
            }
        }
    }

}
