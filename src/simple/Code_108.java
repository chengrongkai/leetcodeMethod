package simple;

import util.TreeNode;

/**
 * Description:
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @author: chengrongkai
 * Date: 2019-10-24
 * Time: 10:51
 */
public class Code_108 {

    public static TreeNode sortedArrayToBST(int[] nums) {
       if (null==nums || nums.length==0){return null;}
       int middle = nums.length/2;
        TreeNode root = new TreeNode(nums[middle]);
        int[] leftArray = new int[middle];
        System.arraycopy(nums,0,leftArray,0,middle);
        int[] rightArray = new int[nums.length-middle-1];
        System.arraycopy(nums,middle+1,rightArray,0,nums.length-middle-1);
        root.left = sortedArrayToBST(leftArray);
        root.right = sortedArrayToBST(rightArray);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode root = sortedArrayToBST(nums);
        preorder(root);
    }

    public static void preorder(TreeNode node) {
        if (node == null) {
            System.out.println("null");
            return;
        }
         else{
            System.out.print(node.val + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

}
