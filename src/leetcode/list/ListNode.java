package leetcode.list;

public class ListNode {
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
