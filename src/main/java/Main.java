import java.util.*;
public class Main {
	public static Scanner reader = new Scanner (System.in);
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4,5, 6, 7};
        Node<Integer> head = buildList(arr);
        int[] arr1 = {1, 2,  3,5, 6, 7};
        Node<Integer> head2 = buildList(arr1);

        //System.out.println("Original List: " + head);
       // printListRec(head);
       // printList(head);
        //System.out.println(ifinList(head,8));
        //System.out.println(head1);
        //System.out.println(head);
        //head = delNodeindex(head, 3);
        
        //System.out.println("List after deletion: " + head);
        //printheadinhead2(head,head2);
        head= ex11(head,head2);
        System.out.println(head);
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
    public static boolean ifinListB(Node <Integer> head, int x) {
		Node <Integer> p = head;
		if (p==null) {
			return false;
			}
		if (p.getValue() == x) {
			return true;
			}
	    return ifinListB(p.getNext() , x);
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
    public static boolean ifAllHeadInHead2(Node<Integer> head, Node<Integer> head2) {//8
    		if (head == null) {
    			return true;
    		}
    		if  (ifinList(head2,head.getValue()) == false) {
    			return false;
    		}
    		return ifAllHeadInHead2(head.getNext(),head2);
    	
    }
    public static void printheadinhead2(Node<Integer> head, Node<Integer> head2) {//9
    	Node <Integer> p = head;
		Node <Integer> h = head2;
		while(h != null) {
			h = head2;
			while (p!= null) {
				if (ifinListB(h,p.getValue())) {
					System.out.println(p.getValue());
				}
				p=p.getNext();
			}
			h=h.getNext();
		}
    }
    public static Node<Integer> ex10(Node <Integer> head1, Node <Integer> head2){
    	Node <Integer> htemp =  new Node <Integer> (null);
		Node <Integer> current3 = htemp;
		Node <Integer> p = head1;
		while (p!=null) {
			Node <Integer> h = head2;
			while (h!= null) {
				if (p.getValue().equals(h.getValue())) {
					Node <Integer> c = new Node <Integer> (p.getValue());
					current3.setNext(c);
					current3 = c;
				}
				h = h.getNext();
			}
			p = p.getNext();
		}
		return htemp.getNext();
	}

    public static Node<Integer> ex11(Node<Integer> head1, Node<Integer> head2) {
	    Node<Integer> htemp = new Node<>(null); 
	    Node<Integer> current = htemp;     
	    Node<Integer> p = head1;                  

	    while (p != null) {
	        Node<Integer> h = head2;
	        boolean check = false;
	        while (h != null) {
	            if (p.getValue().equals(h.getValue())) {
	                check = true; 
	                }
	            h = h.getNext(); 
	        }

	        if (check == false) {
	            current.setNext(new Node<>(p.getValue()));
	            current = current.getNext();
	        }

	        p = p.getNext(); 
	    }

	    return htemp.getNext(); 
	}
}