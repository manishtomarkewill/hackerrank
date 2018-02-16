package BasicLinkedList;

public class Insertion {
	Node head;
	
	static class Node{
		int data;
		Node next;
		Node(int d){
			data=d;
			next=null;
		}
	}
	
	public void AddAtBeg(int newData){
		Node newNode=new Node(newData);
		newNode.next=head;
		head=newNode;
	}
	
	private void append(int newData) {
		Node newNode=new Node(newData);
		if(head==null){
			head=newNode;
		}
		newNode.next=null;
		
		Node n=head;
		while(n.next!=null)
			n=n.next;
		n.next=newNode;
		
	}
	
	private void push(Node prevNode,int newData) {
		if(head==null)
			return;
		Node newNode=new Node(newData);
		newNode.next=prevNode.next;
		prevNode.next=newNode;
	}
	
	private void printlist() {
		Node n=head;
		while(n!=null){
			System.out.print(n.data+" ");
			n=n.next;
		}
		
	}

	public static void main(String[] args) {
		Insertion list=new Insertion();
		list.AddAtBeg(6);
		list.append(7);
		list.push(list.head.next, 4);
		list.printlist();
		list.append(12);
		list.append(2);
		list.printlist();
		list.AddAtBeg(1);
		list.AddAtBeg(15);
		list.printlist();
		
	}

}
