package simple;

/**
 * Description:将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * User: chengrongkai
 * Date: 2019-10-09
 * Time: 9:51
 */
public class Code_21 {
    static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode v2 = new ListNode(2);
        ListNode v3 = new ListNode(3);
        ListNode v4 = new ListNode(4);
        l1.next = v2;
        v2.next = v4;
        ListNode l2 = new ListNode(2);
        ListNode s3 = new ListNode(3);
        ListNode s4 = new ListNode(4);
        l2.next = s3;
        s3.next = s4;

        ListNode listNode = mergeTwoLists(l1, l2);
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
