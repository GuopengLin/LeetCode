public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null && l2 == null)
            return null;
        int temp = 0;
        ListNode node = new ListNode(0);
        int val;
        if (l1 != null && l2 != null){
            val = (l1.val + l2.val + temp) % 10;
            temp = (l1.val + l2.val + temp) / 10;
            node.val = val;
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode ans = node;
        while (l1 != null && l2 != null){
            val = (l1.val + l2.val + temp) % 10;
            temp = (l1.val + l2.val + temp) / 10;
            ListNode node1 = new ListNode(val);
            l1 = l1.next;
            l2 = l2.next;
            node.next = node1;
            node = node1;
        }
        ListNode left;
        if (l1 != null)
            left = l1;
        else  left = l2;
        while (left != null){
            val = (left.val + temp) % 10;
            temp = (left.val + temp)/10;
            ListNode node1 = new ListNode(val);
            node.next = node1;
            node = node1;
            left = left.next;
        }
        if (temp != 0){
            ListNode node1 = new ListNode(temp);
            node.next = node1;
        }
        return ans;

    }
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
