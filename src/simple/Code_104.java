package simple;

/**
 * Description:
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 * @author: chengrongkai
 * Date: 2019-10-23
 * Time: 14:46
 */
public class Code_104 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static int maxDepth(TreeNode root) {
        return maxDepth(root,1);
    }

    public static int maxDepth(TreeNode root,int count){
        if (root == null){
            return 0;
        }else{
            int left = maxDepth(root.left,count);
            int right = maxDepth(root.right,count);
            int compare = left>right?left:right;
            return count+compare;
        }
    }

    public static  int maxDepthPlus(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepthPlus(root.left), maxDepthPlus(root.right)) + 1;
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
        two.right = four;
//        four.left = new TreeNode(2);
        System.out.println(maxDepth(p));
    }


}
