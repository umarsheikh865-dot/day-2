public class removenthnode {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode removenthnode(ListNode head, int n) {

        // Step 1: Find length
        int length = 0;
        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Step 2: If removing first node
        if (length == n) {
            return head.next;
        }

        // Step 3: Go to node before target
        int position = length - n;

        ListNode current = head;

        for (int i = 1; i < position; i++) {
            current = current.next;
        }

        // Step 4: Remove node
        current.next = current.next.next;

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = removenthnode(head, 2);

        printList(head);
    }
}