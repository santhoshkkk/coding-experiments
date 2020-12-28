package leetcode.list;

public class MergeSortedList {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(25);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(20);
        l2.next.next = new ListNode(100);


        System.out.println(mergeTwoLists(null, null));
        System.out.println(mergeTwoLists(l1, null));
        System.out.println(mergeTwoLists(null, l2));
        System.out.println(mergeTwoLists(l1, l2));

    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode current = head;
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (null == l1) {
            current.next = l2;
        } else {
            current.next = l1;
        }

        return head.next;

    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(val);
        if (null != next) {
            builder.append(",").append(next.toString());
        }
        return builder.toString();
    }
}
