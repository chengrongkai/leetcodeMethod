package simple;

import util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Description:
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @author: chengrongkai
 * Date: 2019-10-23
 * Time: 16:10
 */
public class Code_107 {


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        DFS(root, 0, ans);
        return ans;
    }

    private static void DFS(TreeNode root, int level, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        // 当前层数还没有元素，先 new 一个空的列表
        if (ans.size() <= level) {
            ans.add(0, new ArrayList<>());
        }
        // 当前值加入
        ans.get(ans.size() - 1 - level).add(root.val);

        DFS(root.left, level + 1, ans);
        DFS(root.right, level + 1, ans);
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
        List<List<Integer>> list = levelOrderBottom(one);

        for (int i = 0; i < list.size(); i++) {
            List<Integer> temp = list.get(i);
            System.out.println("*******");
            for (int j = 0; j < temp.size(); j++) {
                Integer s = temp.get(j);
                System.out.println(s);
            }
        }
    }



}
