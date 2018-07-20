
public class p21 {
	static ListNode head;
	
	public static class ListNode {
		    int val;
		    ListNode next;
		    ListNode(int x) { val = x; }
	}
	
	public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode l3=head;
		if(l1==null) return l2;
		if(l2==null) return l1;
		while(l1!=null && l2!=null){
			if(l1.val>l2.val){
				l3.next=l2;
				l2=l2.next;
			}else if(l1.val==l2.val){
				l3.next=l2;
				l3=l3.next;
				l2=l2.next;
				l3.next=l1;
				l1=l1.next;
			}else{
				l3.next=l1;
				l1=l1.next;
			}
			l3=l3.next;
		}
		while (l1 != null) {
            l3.next = l1;
            l1 = l1.next;
            l3 = l3.next;
        }
        
        while (l2 != null) {
            l3.next = l2;
            l2 = l2.next;
            l3 = l3.next;
        }
		
			return head.next;
    }
	
	public static void display(ListNode l1,ListNode l2){
		System.out.print("L1: ");
		while(l1!=null){
			System.out.print(l1.val+" ");
			l1=l1.next;
		}
		System.out.print("L2: ");
		while(l2!=null){
			System.out.print(l2.val+" ");
			l2=l2.next;
		}
	}
	
	public static void main(String[] args) {
		ListNode l1=new ListNode(1);
		l1.next=new ListNode(2);
		l1.next.next=new ListNode(4);
		
		ListNode l2=new ListNode(1);
		l2.next=new ListNode(3);
		l2.next.next=new ListNode(4);
		
		display(l1,l2);
		p21 o=new p21();
		
		o.mergeTwoLists(l1,l2);
	}

}
