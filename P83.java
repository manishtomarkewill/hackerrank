
class P83 {
	static ListNode head;
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int d){
			val=d;
			next=null;
		}
	}
	
    public static void deleteDuplicates(ListNode head) {
        ListNode node=head;
        while(node!=null && node.next!=null){
            if(node.val==node.next.val){
            	node.next=node.next.next;
            }else
            	node=node.next;
        }
        node=head;
       while(node!=null){
           System.out.print(node.val+" ");
           node=node.next;
       }
    }
    private static void AddAtBeg(int newData){
    	ListNode newNode=new ListNode(newData);
		newNode.next=head;
		head=newNode;
	}
    
    private static void append(int newData) {
    	ListNode newNode=new ListNode(newData);
		if(head==null){
			head=newNode;
		}
		newNode.next=null;
		ListNode n=head;
		while(n.next!=null)
			n=n.next;
		n.next=newNode;
		
	}
    private static void display(){
    	ListNode node=head;
    	while(node!=null){
    		System.out.print(node.val+" ");
    		node=node.next;
    	}
    }
    public static void main(String[] args){
    	AddAtBeg(1);
    	append(1);
    	append(1);
    	display();
    	deleteDuplicates(head);
    	
    }
}
