package java42_0313;


import java.util.ArrayList;
import java.util.List;

class Node {
    String val;
    Node left;
    Node right;

    public Node(String val) {
        this.val = val;
    }
}

public class BinaryTree {
    //创建一棵树（手动写死的方式）
    public static Node build() {
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;

    }


    //1. 先序遍历
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        //访问根节点，此处访问就是打印
        System.out.print(root.val);
        //递归遍历左子树
        preOrder(root.left);
        //递归遍历右子树
        preOrder(root.right);
    }


    //2. 中序遍历
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        //先递归处理左子树
        inOrder(root.left);
        //再访问根节点
        System.out.print(root.val);
        //最后递归处理右子树
        inOrder(root.right);
    }

    //3. 后序遍历
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        //先递归处理左子树
        postOrder(root.left);
        //再递归处理右子树
        postOrder(root.right);
        //最后访问根节点
        System.out.print(root.val);
    }

    //4. 使用成员变量 count 来记录元素的个数
    public static int count = 0;

    public static void length(Node root) {
        if (root == null) {
            return;
        }
        //访问根节点，此时的访问操作就是count++
        count++;
        //递归处理左子树
        length(root.left);
        //递归处理右子树
        length(root.right);
    }

    //5. 接下来还是实现 length ，此时通过方法的返回值来记录元素个数
    public static int length2(Node root) {
        if (root == null) {
            return 0;
        }
        //当前树的节点个数 = 根节点的个数 + 左子树的节点个数 + 右子树的节点个数
        return 1 + length2(root.left) + length2(root.right);
    }


    //6. 求子节点的个数
    public static int leafSize = 0;

    public static void getLeafSize(Node root) {
        //针对二叉树遍历，判断当前节点是否是叶子节点，如果是就 size++;
        if (root == null) {
            return;
        }
        //判断当前节点是否是叶子结点
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafSize(root.left);
        getLeafSize(root.right);
    }

    //7.求叶子节点的个数2
    public static int getLeafSize2(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafSize2(root.left) + getLeafSize2(root.right);
    }


    //8.求第K层节点数
    public static int getKLevelSize(Node root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            //如果当前树非空，第一层节点一定是 1 个元素
            return 1;
        }
        return getKLevelSize(root.left, k - 1) + getKLevelSize(root.right, k - 1);

    }


    //9.求树的深度
    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }


    //10. 查找树上的某一元素
    public static Node find(Node root, String toFind) {
        if (root == null) {
            return null;
        }
        if (root.val.equals(toFind)) {
            return root;
        }
        Node result = find(root.left, toFind);
        if (result != null) {
            return result;
        }
        return find(root.right, toFind);
    }


    public static void main(String[] args) {
        Node root = build();
//               Node result = find(root, "B");
//        System.out.println(result.val);


//        find(root,"B");
//        System.out.println(root.val);

//        System.out.println(getHeight(root));


//        preOrder(root);
//        inOrder(root);
//        postOrder(root);
//        length(root);
//        System.out.println(count);
//        System.out.println(length2(root));
//        getLeafSize(root);
//        System.out.println(leafSize);
//        System.out.println(getLeafSize2(root));
//        System.out.println(getKLevelSize(root,3));


    }


    //层序遍历，leetcode问题解决。用链表实现层序遍历。
    //还是使用一个成员变量来记录最终结果
    //及时代码递归的很深，我们也能随时操作这个成员变量。
    public static List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> levelOrder2(TreeNode root) {
        //为了保证多组用例互相不干扰，需要每次把 result 进行初始化
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        helper(root,0);
        return result;
    }
    
    public void helper(TreeNode root, int level) {
        if (level == result.size()) {
            //刚开始创建的 result 长度是 0 ， 如果直接 get 取下标
            //就会产生下标越界异常
            //就需要提前把对应的实例创建好，并且插入到 result 中
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level+1);
        }
        if (root.right != null) {
            helper(root.right, level+1);
        }
    }
}


