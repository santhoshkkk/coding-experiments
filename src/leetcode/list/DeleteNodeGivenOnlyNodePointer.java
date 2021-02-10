package leetcode.list;

public class DeleteNodeGivenOnlyNodePointer {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        System.out.println(node);
        deleteNode(node);
        System.out.println(node);
        deleteNode(node.next);
        System.out.println(node);

    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next=node.next.next;
    }
}
