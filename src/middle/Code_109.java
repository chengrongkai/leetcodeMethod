package middle;

import util.TreeNode;

/**
 * Description:
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * @author: chengrongkai
 * Date: 2019-10-24
 * Time: 11:19
 */
public class Code_109 {
    public TreeNode sortedListToBST(ListNode head) {
        return null;
    }

    public static TreeNode sortedListToBST(ListNode head,TreeNode root,int left,int right){
        if (null == head){
            return null;
        }
        TreeNode node = new TreeNode(head.val);
        //添加在右边
        if (left>right){
            right++;
            root.right = node;
            sortedListToBST(head.next,node,left,right);
        }
        //添加在左边
        else{
            left++;
            root.left = node;
            sortedListToBST(head,node,left,right);
        }
        return root;
    }
}
