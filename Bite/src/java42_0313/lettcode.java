package java42_0313;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int  val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class lettcode {

    
    //先序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
            //不要 return null
        }
        //先访问根节点，此处的 “访问” 不是打印，而是插入 result 末尾
        result.add(root.val);
        //递归处理左子树,此时会得到一个左子树的遍历结果的 list ，这个结果也要加到 result 中
        result.addAll(preorderTraversal(root.left));
        //递归处理右子树
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //递归处理左子树
        result.addAll(inorderTraversal(root.left));
        //访问根节点
        result.add(root.val);
        //递归处理右子树
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    //后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if ( root == null) {
            return result;
        }
        //递归处理左子树
        result.addAll(postorderTraversal(root.left));
        //递归处理右子树
        result.addAll(postorderTraversal(root.right));
        //访问根节点
        result.add(root.val);
        return result;
    }

    //判定两棵二叉树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
//        if ((p == null && q != null)||(p != null && q == null)) {
//            return false;
//        }
        if (p == null || q == null) {
            //进入这个条件意味着，一定是 p 和 q 其中一个为空，一个不为空
            return false;
        }
        //都不为空，先判断根节点是否值相同
        if (p.val != q.val) {
            return false;
        }
        //根节点相同，再去比较左右子树
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);


    }


    //判定是一个树是否是另一个树的子树
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        boolean ret = isSameTree(s,t);
        if(ret) {
            return ret;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);

    }
    
    //求二叉树的高度
    public  int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return 1 + (leftHeight > rightHeight ? leftHeight : rightHeight);
    }

    //判定是否是平衡二叉树
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //针对当前节点计算左右子树的高度
        int leftLength = getHeight(root.left);
        int rightLenght = getHeight(root.right);
        if ((leftLength - rightLenght > 1) ||(leftLength - rightLenght < -1)) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        if (root ==null){
            return 0;
        }
        int leftHight = getHeight(root.left);
        int rightHight = getHeight(root.right);
        return 1 + (Math.max(leftHight, rightHight));
    }



    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        //判定根节点是否相同
        if (s.val != t.val) {
            return false;
        }
        return isMirror(s.left, t.right) && isMirror(s.right, t.left);
    }



    public static TreeNode build() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);
        TreeNode i = new TreeNode(9);
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.left = g;
        d.right = h;
        e.right = i;
        return a;
    }



    //层序遍历
    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        //创建一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        //把根节点入队列
        queue.offer(root);
        //循环取队列队首元素
        while (true) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                break;
            }
            //访问当前节点，直接打印
            System.out.print(cur.val);
            //把左右子树入队列
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }




    //完全二叉树
    public static boolean isCompleteTree( TreeNode root) {
        if (root == null){
            return true;
        }
        //层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        //为 ture 表示是第一阶段。如果是 false 表示第二阶段
        boolean isLevel1 = true;
        while (true) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                break;
            }
            if (isLevel1){
                //第一阶段的判定。要求同时具有左右子树
                if (cur.left != null &&  cur.right != null) {
                    //继续遍历
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                } else if (cur.left == null && cur.right != null) {
                    return false;
                } else if (cur.left != null && cur.right == null) {
                    //还需要继续判定，进入第二阶段了
                    isLevel1 = false;
                    queue.offer(cur.left);
                } else {
                    //cur.left 和 cur.right 都为 null
                    //进入第二阶段
                    isLevel1 = false;
                }
            } else {
                //第二阶段的判定,只要发现该节点有子树，则认为这棵树不是完全二叉树。
                if (cur.left != null || cur.right != null) {
                    return false;
                }
            }//end if
        }//end while
        //当遍历完了之后，都没有找到反例，就认为是完全二叉树。
        return true;
    }


    public static void main(String[] args) {
       TreeNode root = build();
        boolean result = isCompleteTree(root);
        System.out.println(result);

    }
}





