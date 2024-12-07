import java.util.*;
public class Main {
	public static Scanner reader = new Scanner (System.in);
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,5, 6, 7};
        Node<Integer> head = buildList(arr);
        int[] arr1 = {1, 2, 4, 4,5, 6, 7};
        Node<Integer> head2 = buildList(arr1);

        //System.out.println("Original List: " + head);
       // printListRec(head);
       // printList(head);
        //System.out.println(ifinList(head,8));
        //System.out.println(head1);
        //System.out.println(head);
        //head = delNodeindex(head, 3);
        
        //System.out.println("List after deletion: " + head);
        System.out.println(ifAllHeadInHead2(head,head2));
        
    }    
    
    public static Node<Integer> buildList(int[] a) { // ex1
        Node<Integer> head = new Node<>(a[0]);
        Node<Integer> curr = head;
        for (int i = 1; i < a.length; i++) {
            Node<Integer> next = new Node<>(a[i]);
            curr.setNext(next);
            curr = next;
        }
        return head;
    }
    public static void printList (Node <Integer> head ) {//ex2
    	while(head!=null){
    		System.out.println(head.getValue());
    		head= head.getNext();
    	} 
    	return;
    
    }
    public static void printListRec (Node <Integer> head ) {//ex2b
    	System.out.println(head.getValue());
    	if (head.getNext()==null)
    		return;
    	printList(head.getNext());
    }
    public static Node<Integer> buildListuntil() { // ex3
    	Node <Integer> list = null;
    	Node <Integer> curr = null;
    	int x= reader.nextInt();
    	while (x!=-1) {
    		Node <Integer> newNode= new Node<>(x);
    		if (list == null) {
                list = newNode; 
                curr = list;    
            } else {
                curr.setNext(newNode); 
                curr = newNode;        
            }
    		x =  reader.nextInt();
    	}
    	return list;
    	
    }
    public static void printListeven (Node <Integer> head ) {//ex4
    	while(head!=null){
    		if (head.getValue()%2==0)
    			System.out.println(head.getValue());
    		head= head.getNext();
    	} 
    	return;
    
    }
    public static boolean ifinList (Node <Integer> head , int x) {//ex5
    	while(head!=null){
    		if (head.getValue()==x)
    			return true;
    		head= head.getNext();
    	} 
    	return false;
    
    }
    public static Node<Integer> delNode(Node<Integer> h, int x) { // ex6
        if (h != null && h.getValue() == x) {
            return h.getNext();
        }

        Node<Integer> current = h;
        while (current.getNext() != null) {
            if (current.getNext().getValue() == x) {
                current.setNext(current.getNext().getNext());
                return h;
            }
            current = current.getNext();
        }
        
        return h;
    }
    public static Node<Integer> delNodeindex(Node<Integer> h, int index) { // ex7
        if (h == null) {
            return null;
        }
        if (index == 0) {
            return h.getNext();
        }
        int count=1;
        Node<Integer> current = h;
        while (current != null && current.getNext() != null) {
            if (count == index) {
                current.setNext(current.getNext().getNext());
                return h;
            }
            current = current.getNext();
            count++;
        }
        
        return h;
    }
    public static boolean ifAllHeadInHead2(Node<Integer> head, Node<Integer> head2) {
        if (head == null && head2 == null) 
            return true;
        if (head == null || head2 == null || head.getValue() != head2.getValue()) 
            return false;
        return ifAllHeadInHead2(head.getNext(), head2.getNext());
    }
    
}