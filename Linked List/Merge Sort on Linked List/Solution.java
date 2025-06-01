class Solution {
    // Function to sort the given linked list using Merge Sort.
    public static Node sort(Node head){
        Node slow=head;
        Node fast=head;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            if(fast!=null && fast.next!=null){
                slow=slow.next;
            }
        }
        Node temp=slow.next;
        slow.next=null;
        return temp;
        
    }
    public static Node merge(Node f,Node s){
        if(f==null) return s;
        if(s==null) return f;
        
        if(f.data<s.data){
            f.next=merge(f.next,s);
            return f;
        }
        else{
            s.next=merge(f,s.next);
            return s;
        }
    }
    
    static Node mergeSort(Node head) {
        // add your code here
        if(head==null ||head.next==null){
            return head;
        }
        Node second=sort(head);
        Node firstNode=mergeSort(head);
        Node secondNode=mergeSort(second);
        
        Node newhead=merge(firstNode,secondNode);
        return newhead;
        
    }
}