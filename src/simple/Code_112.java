package simple;

import util.TreeNode;

/**
 * Description:
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @author: chengrongkai
 * Date: 2019-10-24
 * Time: 15:57
 */
public class Code_112 {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
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
        one.left = new TreeNode(5);
        two.right = three;
        three.right = new TreeNode(2);
        int sum = 7;
        System.out.println(hasPathSum(p,sum));
    }


}
