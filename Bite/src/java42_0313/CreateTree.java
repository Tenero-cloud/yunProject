package java42_0313;

import java.util.Stack;

public class CreateTree {
    public static class TreeNode {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {

            this.val = val;
        }
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String line = scanner.next();
//            //这句代码至关重要！！！
//            //这个代码一旦忘了，就会导致两个用例之间相互影响！
//            index = 0;
//            TreeNode root = build(line);
//            inOrder(root);
//            System.out.println();
//        }
//    }


    //二叉树的构建
//    public static int index = 0;    //通过这个成员变量，记录 build 执行过程中，当前处理到了第几个节点
//    public static TreeNode build(String input) {
//        char ch = input.charAt(index);
//        if (ch =='#') {
//            //如果是 # 当前节点是一个空节点
//            return null;
//        }
//        //如果当前这个字符不是空节点，就创建出一个 TreedNode 对象
//        TreeNode root = new TreeNode(ch);
//        index++;//表示当前节点搞定了，继续处理下一个节点。
//        root.left = build(input);
//        index++;
//        root.right = build(input);
//        return root;
//    }
//    public static void inOrder(TreeNode root) {
//        if ( root == null) {
//            return;
//        }
//        inOrder(root.left);
//        System.out.print(root.val + " ");
//        inOrder(root.right);
//    }



    //非递归前序遍历二叉树
    public static void preOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        //创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        //把根节点入栈
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode cur =stack.pop();
            System.out.print(cur.val);
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left !=null){
                stack.push(cur.left);
            }
        }


    }

    public static TreeNode build() {
        TreeNode a = new TreeNode('1');
        TreeNode b = new TreeNode('2');
        TreeNode c = new TreeNode('3');
        TreeNode d = new TreeNode('4');
        TreeNode e = new TreeNode('5');
        TreeNode f = new TreeNode('6');
        TreeNode g = new TreeNode('7');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        e.left = g;
        c.right = f;
        return a;

    }




    // 非递归中序遍历二叉树

    public static void inOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        //创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (true) {
            //里层循环负责 cur 往左走并入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //当上面循环结束 cur 就是 null
            //取出栈顶元素并访问
            if (stack.isEmpty()) {
                //遍历完了
                break;
            }
            TreeNode top = stack.pop();
            System.out.print(top.val);

            //让 cur 从 top 的右子树出发，重复上述过程。
            cur = top.right;

        }
    }


    //非递归后序遍历
    public static void postOrderByLoop(TreeNode root) {
        if (root == null) {
            return;
        }
        //1. 创建一个栈
        Stack<TreeNode> stack = new Stack<>();
        //创建爱你一个引用，从 root出发
        TreeNode cur = root;
        TreeNode prev = cur;
        while (true) {
            while ( cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // 4，取出栈顶元素看能不能访问‘
            if (stack.isEmpty()){
                break;
            }
            //此树不能直接 pop 改节点能不能访问还不用去夜店
            //必须访问了才能出站
            TreeNode top = stack.peek();
            if (top.right == null || top.right == prev) {
                System.out.print(top.val);
                prev = stack.pop();
            }else {
                cur = top.right;
            }
        }
    }





    public static void main(String[] args) {
        TreeNode root = build();
        preOrderByLoop(root);
        System.out.println();
        inOrderByLoop(root);
        System.out.println();
        postOrderByLoop(root);

    }
}


