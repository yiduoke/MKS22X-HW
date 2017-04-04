public class MyLinkedList{
	
    LNode start;
    LNode tail;
    int size;
    
    //inner city--------------------------
    class LNode{
	int first;
	LNode next=null;
	LNode prev=null;
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
    public boolean add(int value){//doubly linked
         if (start == null) {
             LNode thing = new LNode(value);
             start=thing;
             tail=thing;
         } 
         else{
             tail=new LNode(value);
             getNode(size-1).next=tail;
             tail.prev=getNode(size-1);
         }
         size++;
         return true;
    }
    
    private LNode getNode(int index){//new
    	if (start==null){
    		return null;
    	}
    	LNode current=start;
    	for (int i=0; i<index; i++){
    		current=current.next;
    	}
    	return current;
    }
    
    public int size(){return size;}
    
    public String toString(){//won't change
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
    
    public int get(int index){//won't change
    	LNode current=start;
    	if (start == null){return 0;}
    	for (int i=0; i<index; i++){
    		current = current.next;
    	}
    	return current.first;
    }
    
    public int set(int index, int newValue){//modified
    	if (start == null){start = new LNode(newValue);}
    	int x = getNode(index).first;
    	getNode(index).first = newValue;
    	return x;
    }
    
    public int indexOf(int value){//modified
    	if (start == null){return -1;}
    	for (int i=0; i<size; i++){
    		if (getNode(i).first==value){return i;}
    	}
    	return -1;
    }
    
    public void add(int index, int value){//doubly linked
	if (index>size){throw new IllegalArgumentException();}
    	LNode thing=new LNode(value);
    	if (index==0){
    		start.prev=thing;
    		thing.next=start;
    		start=thing;
    	}
    	else if(index==size){
    		tail.next=thing;
    		thing.prev=tail;
    		tail=thing;
    	}
    	else{
    		thing.prev=getNode(index-1);
    		thing.next=getNode(index);
    		getNode(index).prev=thing;
    		getNode(index-1).next=thing;
    	}
    	size++;
    }
    
    public int remove(int index){//doubly linked
    	if (index<0 || index>=size){throw new IllegalArgumentException();}
    	int x=getNode(index).first;
	if (size==1 && index ==0){
	    start=null;
	    tail=null;
	}
    	else if (index==0){ 
    		start=start.next;
    		start.prev=null;
    		}
    	else if (index==size-1){
    		tail=tail.prev;
    		tail.next=null;
    		}
    	else{
    		LNode y=getNode(index);
    		y.prev.next=y.next;
    		y.next.prev=y.prev;
    	}
    	size--;
    	return x;
    }
    
    public static void main(String[] args){
    	MyLinkedList margaret = new MyLinkedList();
    	margaret.add(10);
    	margaret.add(5);
    	//margaret.add(9);
    	margaret.add(7);
    	margaret.add(11);
    	margaret.add(2,9);//[10, 5, 9, 7, 11]
    	margaret.remove(0);
	MyLinkedList penn = new MyLinkedList();
	penn.add(10);
	penn.remove(0);
	System.out.println(penn);
    	System.out.println(margaret.toString());
    	System.out.println(margaret.indexOf(11));
    }
    
}
