public class removenthnode {

    // Node class for Linked List
    static class ListNode {

        int val;          // Stores data
        ListNode next;    // Stores address of next node

        // Constructor
        ListNode(int val) {
            this.val = val;
        }
    }

    // Function to remove nth node from end
    public static ListNode removenthnode(ListNode head, int n) {

        // --------------------------
        // STEP 1: Find total length
        // --------------------------

        int length = 0;

        ListNode temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // Example:
        // 1 → 2 → 3 → 4 → 5
        // Length = 5


        // ---------------------------------------
        // STEP 2: If first node needs removal
        // ---------------------------------------

        if (length == n) {
            return head.next;
        }

        // Example:
        // Length = 5
        // n = 5
        // Remove first node (1)
        //
        // Return:
        // 2 → 3 → 4 → 5


        // ---------------------------------------
        // STEP 3: Find node before target
        // ---------------------------------------

        int position = length - n;

        // Example:
        // Length = 5
        // n = 2
        //
        // position = 5 - 2 = 3
        //
        // We need to reach node 3
        // because node 4 will be removed


        ListNode current = head;

        for (int i = 1; i < position; i++) {
            current = current.next;
        }

        // Current is now at node 3


        // ---------------------------------------
        // STEP 4: Remove target node
        // ---------------------------------------

        current.next = current.next.next;

        // Before:
        // 1 → 2 → 3 → 4 → 5
        //
        // current = 3
        //
        // current.next = 4
        // current.next.next = 5
        //
        // After:
        // 1 → 2 → 3 → 5


        return head;
    }

    // Function to print linked list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // Create linked list:
        // 1 → 2 → 3 → 4 → 5

        ListNode head = new ListNode(1);

        head.next = new ListNode(2);

        head.next.next = new ListNode(3);

        head.next.next.next = new ListNode(4);

        head.next.next.next.next = new ListNode(5);

        // Remove 2nd node from end
        head = removenthnode(head, 2);

        // Print result
        printList(head);
    }
}