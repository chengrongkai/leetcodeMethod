package simple;

import java.util.ArrayDeque;

/**
 * Description:
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * @author: chengrongkai
 * Date: 2019-10-22
 * Time: 11:26
 */
public class Code_101 {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 递归方法
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null){return true;}
        TreeNode left = root.left;
        TreeNode right = root.right;
        return compare2(left,right);
    }

    public static boolean compare(TreeNode left,TreeNode right){
        if (left==null && right == null){
            return true;
        }
        if (left==null || right == null){
            return false;
        }
        if (left.val == right.val){
            return compare(left.left,right.right)&&compare(left.right,right.left);
        }else {
            return false;
        }
    }

    public static boolean compare2(TreeNode p,TreeNode q){
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
                if (!check(p.left, q.right)) return false;
                if (p.left != null) {
                    deqP.addLast(p.left);
                    deqQ.addLast(q.right);
                }
                if (!check(p.right, q.left)) return false;
                if (p.right != null) {
                    deqP.addLast(p.right);
                    deqQ.addLast(q.left);
                }
            }
        }
        return true;
    }


    public static boolean check(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return true;
    }


    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode p = new TreeNode(0);
        p.left = one;
        p.right = two;
        one.left = new TreeNode(5);
        two.right = new TreeNode(1);
        System.out.println(isSymmetric(p));
     }
}
