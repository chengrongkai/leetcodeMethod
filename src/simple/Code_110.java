package simple;

import util.TreeNode;

import static simple.Code_108.sortedArrayToBST;

/**
 * Description:
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 * @author: chengrongkai
 * Date: 2019-10-24
 * Time: 15:12
 */
public class Code_110 {
    /**
     * 方法一
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private static int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        if(left == -1) return -1;
        int right = depth(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }

    /**
     * 方法二
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root) {
        if (root == null) return true;
        return Math.abs(depth1(root.left) - depth1(root.right)) <= 1 && isBalanced1(root.left) && isBalanced1(root.right);
    }

    private int depth1(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depth1(root.left), depth1(root.right)) + 1;
    }



    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(isBalanced(root));
    }



}
