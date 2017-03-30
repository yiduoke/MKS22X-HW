public class MyLinkedList{
	
    LNode start;
    int size;
    
    //inner city--------------------------
    class LNode{
	int first;
	LNode next=null;
	public LNode(int x, LNode y){
	    first=x;
	    next=y;
	}
	public LNode(int x){
	    first=x;
	}
    }
    //inner city--------------------------
    
    public MyLinkedList(){
    	start=null;
    	size=0;
    }
    public boolean add(int value){
    	 LNode last = lastNode();
         if (last == null) {
             start = new LNode(value);
         } 
         else{
             last.next = new LNode(value);
         }
         size++;
         return true;
    }
    
    public LNode lastNode() {
        if (start == null) {
            return null;
        }
        LNode current = start;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }
    
    public int size(){return size;}
    
    public String toString(){
    	String x="[";
    	LNode current = start;
    	for (int i=0; i<size; i++){
    		if (i==size-1){x+=current.first;}
    		else{
    			x+=current.first+", ";
    			current=current.next;
    		}
    	}
    	x+="]";
    	return x;
    }
    
    public int get (int index){
    	LNode current=start;
    	if (start == null){return 0;}
    	for (int i=0; i<index; i++){
    		current = current.next;
    	}
    	return current.first;
    }
    
    public int set(int index, int newValue){
    	LNode current=start;
    	if (start == null){start = new LNode(newValue);}
    	for (int i=0; i<index; i++){
    		current = current.next;
    	}
    	int x = current.first;
    	current.first = newValue;
    	return x;
    }
    
    public int indexOf(int value){
    	LNode current=start;
    	if (start == null){return -1;}
    	for (int i=0; i<size; i++){
    		if (current.first == value) {return i;}
    		current = current.next;
    	}
    	return -1;
    }
    
    public void add(int index, int value){
    	size++;
    	if (index == 0){
    		LNode temp = start;
    		start=new LNode(value,temp);
    	}
    	else{
    	LNode current=start;
    	for (int i=0; i<index; i++){
    		current = current.next;
    	}
    	LNode temp = current;
    	
    	LNode current2 = start;
    	for (int i=0; i<index-1; i++){
    		current2 = current2.next;
    	}
    	current2.next = new LNode(value, temp);
    	}
    }
    
    public int remove(int index){}
    
    public static void main(String[] args){
    	MyLinkedList margaret = new MyLinkedList();
    	margaret.add(10);
    	margaret.add(5);
    	margaret.add(7);
    	margaret.add(11);
    	margaret.add(4,9);
    	//margaret.set(1, 12);
    	System.out.println(margaret.toString());
    	System.out.println(margaret.indexOf(2));
    }
}