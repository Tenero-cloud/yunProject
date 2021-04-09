package Java42_0318;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class BinaryTree {

    //一、 求树中两个节点的最近公共祖先

    //通过 lca 来记录最终的结果。
    public TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //递归尝试查找 p 和 q
        //写一个辅助方法来进行递归
        findNode(root, p, q);
        return lca;
    }

    //如果 root 中能找到 p 和 q 找到一个就返回 true
    //如果 p 和 q 都没找到，就返回 false
    public boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        //进行查找，同三个渠道进行查找
        //1、判定根节点是不是 p 和 q
        int mid = (root == p || root == q) ? 1 : 0;
        //2、在左子树中查找p 和 q
        int left = findNode(root.left, p, q) ? 1 : 0;
        //3、在右子树中查找 p 和 q
        int right = findNode(root.right, p, q) ? 1 : 0;
        //最重要的步骤，判定该节点时是否是 lca
        //如果 p 和 q 是来自于三和渠道中的两个 ，就认为该节点时 lca
        if (mid + right + left == 2) {
            lca = root;
        }
        //方法的最终返回， 找到 p 或者 q 就返回 true
        return (mid + left + right) > 0;
    }


    //二、 二叉树搜索树转换成排序双向链表。
    public TreeNode Convert(TreeNode pRootOfTree) {

        //判定特殊情况
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        //一般情况
        //1、先递归的把左子树转成链表
        //得到的leftHead 可能是空的。为了防止出现空指针异常。我们加了判断条件。
        TreeNode leftHead = Convert(pRootOfTree.left);
        //2、把根节点尾插到 leftHead 这个链表中
        //需要找到 leftHead 的末尾节点才能尾插
        TreeNode leftTail = leftHead;
        while (leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if (leftHead != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        //3、递归的转换右子树
        TreeNode rightHead = Convert(pRootOfTree.right);
        //4、把当前节点头插到右侧链表的前面
        if(rightHead != null) {
            pRootOfTree.right = rightHead;
            rightHead.left = pRootOfTree;
        }
        //最终需要返回最终链表的头结点
        //注意 leftHead 可能为空，
        //如果为空就应该是 pRootOfTree
        return leftHead != null ? leftHead : pRootOfTree;
    }



    //三、根据先序中序还原二叉树
    //成员变量，index 表示当前访问到 先序 中的第几个元素
    public int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //由于输入的用例可能有多个
        //此处是方法的入口
        //把 index 还原成 0 ，防止多个用例之间互相影响。
        index = 0;
        //辅助方法中多出来的两个参数就表示当前这个子树对应中序遍历结果是啥
        //使用这一对下标表示当前子树的中序遍历结果是在 inorder 的哪个部分上
        return _buildTree( preorder, inorder,0, inorder.length);
    }

    //[inorderLeft，inorderRighgt）标注了一个人前闭后开的区间
    // inorder 数组上的这个区间中的内容，就是当前子树的中序遍历结果。
    public TreeNode _buildTree(int[] preorder, int[] inorder,
                               int inorderLeft,int inorderRight) {
        if(inorderLeft >= inorderRight) {
            //以为这当前中序区间是一个空区间
            //当前子树是空树
            return null;
        }
        if (index >= preorder.length) {
            //先序数组遍历完毕。整个数组处理完毕。
            return null;
        }

        //TreeNode left = _buildTree(preorder, inorder, inorderLeft, pos);
        //TreeNode right =  _buildTree(preorder, inorder, pos +1, inorderRight);


        //处理一般情况，仍然是先序遍历
        //访问节点操作不是打印，而是构建节点
        TreeNode root = new TreeNode(preorder[index]);
        //查找一下当前节点，在中序区间处在的位置
        //明确了这个位置才好进行下一步递归
        int pos = find(inorder,  inorderLeft,inorderRight, root.val);
        //有了这个 pos 之后，看就知道了当前面左子树的中门后续区间
        //[ inorder，pos）
        //右子树的中序区间 [pos +1 ,inorderRight)
        //递归处理左右子树

        //此此处的 index 只 ++ 一次
        //如果遍历结果中有 #(空节点)， 需要 ++ 两次
        //如果没有空节点，只需要 ++ 一次
        index++;

        // root.left = left;
        // root.right = right;

        root.left = _buildTree(preorder, inorder, inorderLeft, pos);
        root.right = _buildTree(preorder, inorder, pos +1, inorderRight);
        return root;
    }

    public int find(int[] arrary, int left, int right, int toFind) {
        for (int i = left; i < right; i++) {
            if (arrary[i] == toFind) {
               return i;
            }
        }
        return -1;
    }


    //四、根据中序和后序构造二叉树
    //成员变量，index 表示当前访问到 先序 中的第几个元素
    public int index2 = 0;
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        //由于输入的用例可能有多个
        //此处是方法的入口
        //把 index 还原成 0 ，防止多个用例之间互相影响。
        index2 = 0;
        //辅助方法中多出来的两个参数就表示当前这个子树对应中序遍历结果是啥
        //使用这一对下标表示当前子树的中序遍历结果是在 inorder 的哪个部分上

        //把preorder的内容逆置一下


        return _buildTree2( preorder, inorder,0, inorder.length);
    }

    //[inorderLeft，inorderRighgt）标注了一个人前闭后开的区间
    // inorder 数组上的这个区间中的内容，就是当前子树的中序遍历结果。
    public TreeNode _buildTree2(int[] preorder, int[] inorder,
                               int inorderLeft,int inorderRight) {
        if(inorderLeft >= inorderRight) {
            //以为这当前中序区间是一个空区间
            //当前子树是空树
            return null;
        }
        if (index2 >= preorder.length) {
            //先序数组遍历完毕。整个数组处理完毕。
            return null;
        }

        //处理一般情况，仍然是先序遍历
        //访问节点操作不是打印，而是构建节点
        TreeNode root = new TreeNode(preorder[index2]);
        //查找一下当前节点，在中序区间处在的位置
        //明确了这个位置才好进行下一步递归
        int pos = find(inorder,  inorderLeft,inorderRight, root.val);
        //有了这个 pos 之后，看就知道了当前面左子树的中门后续区间
        //[ inorder，pos）
        //右子树的中序区间 [pos +1 ,inorderRight)
        //递归处理左右子树

        //此此处的 index 只 ++ 一次
        //如果遍历结果中有 #(空节点)， 需要 ++ 两次
        //如果没有空节点，只需要 ++ 一次
        index2++;


        //镜像解决这个问题
        root.right = _buildTree2(preorder, inorder, pos +1, inorderRight);
        root.left = _buildTree2(preorder, inorder, inorderLeft, pos);

        return root;
    }

    public int find2(int[] arrary, int left, int right, int toFind) {
        for (int i = left; i < right; i++) {
            if (arrary[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //五、根据二叉树创建字符串

    //还是使用一个成员变量，通过这个成员变量来记录我们的最终结果。
    //方便我们随手在递归过程中把得到的结果拼接到 result 里面
    public StringBuilder result = new StringBuilder();
    public String tree2str(TreeNode t) {
        result = new StringBuilder();
        if (t == null) {
            return "";
        }
        //通过 helper 方法辅助进行先序遍历递归
        // 在递归过程中，逐渐构造出 result 了
        helper(t);
        //手动把最外层括号给删除了
        result.deleteCharAt(0);
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }

    public void helper (TreeNode root) {
        if (root == null) {
            return;
        }
        //访问根节点
        result.append("(");
        result.append(root.val);
        helper(root.left);
        if(root.left ==null && root.right != null){
            result.append("()");
        }
        helper(root.right);
        result.append(")");
    }
}
