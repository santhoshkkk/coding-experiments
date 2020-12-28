package leetcode.list;

public class MergeSortedList {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(25);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(20);
        l2.next.next = new ListNode(100);

        System.out.println(mergeTwoLists(l1, l2));


    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }

        ListNode head;
        ListNode first;
        ListNode second;
        if (l1.val < l2.val) {
            head = l1;
            first = l1;
            second = l2;
        } else {
            head = l2;
            first = l2;
            second = l1;
        }

        ListNode temp;
        do {
            while (null != first.next && first.next.val <= second.val) {
                first = first.next;
            }
            if (null == first.next) {
                first.next = second;
                second = null;
            } else {
                temp = first.next;
                first.next = second;
                second = temp;
            }
        } while (null != second);

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

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
