class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = calculateLength(head);
        int partSize = length / k;
        int extra = length % k;
        
        ListNode[] parts = new ListNode[k];
        ListNode current = head;
        
        for (int i = 0; i < k; i++) {
            parts[i] = current;
            int targetSize = partSize + (i < extra ? 1 : 0);
            
            for (int j = 0; j < targetSize - 1 && current != null; j++) {
                current = current.next;
            }
            
            if (current != null) {
                ListNode next = current.next;
                current.next = null;
                current = next;
            }
        }
        
        return parts;
    }
    
    private int calculateLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        
        while (current != null) {
            length++;
            current = current.next;
        }
        
        return length;
    }
}
