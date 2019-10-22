package simple;

/**
 * Description:
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * @author: chengrongkai
 * Date: 2019-10-18
 * Time: 9:43
 */
public class Code_83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
