class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroup = dummy;

        while (count >= k) {
            ListNode curr = prevGroup.next;
            ListNode next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prevGroup.next;
                prevGroup.next = next;
                next = curr.next;
            }
            prevGroup = curr;
            count -= k;
        }

        return dummy.next;
    }
}