class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> l = new ArrayList<>();
        for(int i=0;i<lists.length;i++){
            ListNode  n = lists[i];
            while(n!=null){
                l.add(n.val);
                n=n.next;
            }
        }
        Collections.sort(l);
        ListNode n = new ListNode(0);
        ListNode t=n;
        for(int i=0;i<l.size();i++){
            ListNode nw = new ListNode(l.get(i));
            t.next=nw;
            t=t.next;
        }
        return n.next;
        
    }
}
