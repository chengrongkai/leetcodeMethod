package simple;

import java.util.ArrayDeque;

/**
 * Description:
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的
 * @author: chengrongkai
 * Date: 2019-10-22
 * Time: 10:36
 */
public class Code_100 {
    public static boolean isSameTreeMy(TreeNode p, TreeNode q) {
        if (p == null || q==null){
            return p == q;
        }
        return isLeftSmall(p,q)&&isRightSmall(p,q);
    }

    public static boolean isLeftSmall(TreeNode p, TreeNode q){

        if (p.left == null || q.left == null){
            return p.val==q.val && p.left == q.left;
        }else{
            return isLeftSmall(p.left,q.left)&&isLeftSmall(p.right,q.right);
        }
    }
    public static boolean isRightSmall(TreeNode p, TreeNode q){
        if (p.right == null || q.right == null){
            return p.val==q.val && p.right == q.right;
        }else{
            return isRightSmall(p.right,q.right)&&isLeftSmall(p.left,q.left);
        }
    }

    /**
     * 递归法
     * @param p
     * @param q
     * @return
     */
    public  boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }

    public boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }

    /**
     * 迭代
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (!check(p, q)) return false;

        // init deques
        ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
        deqP.addLast(p);
        deqQ.addLast(q);

        while (!deqP.isEmpty()) {
            p = deqP.removeFirst();
            q = deqQ.removeFirst();

            if (!check(p, q)) return false;
            if (p != null) {
                // in Java nulls are not allowed in Deque
                if (!check(p.left, q.left)) return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if (!check(p.right, q.right)) return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;
    }



    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode p = new TreeNode(0);
        p.left = one;
        p.right = two;
        TreeNode q = new TreeNode(0);
        q.left = one;
        q.right =two;
//        System.out.println(isSameTree(p,q));
    }
}
