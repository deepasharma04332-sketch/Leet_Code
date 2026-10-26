class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        int n = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }
        
        tail.next = head;
        
        k = k % n;
        if (k == 0) {
            tail.next = null; 
            return head;
        }
        
        ListNode newTail = head;
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        
        newTail.next = null;
        
        return newHead;
    }
}