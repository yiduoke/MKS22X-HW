import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList implements Iterable<Integer>{
	
    LNode start;
    LNode tail;
    int size;
    
    //inner city--------------------------
    class LNode{
	int value;
	LNode next=null;
	LNode prev=null;
	public LNode(int x, LNode y){
	    value=x;
	    next=y;
	}
	public LNode(int x){
	    value=x;
	}
    }
    //inner city--------------------------
    public Iterator<Integer> iterator(){
    	return new MyLinkedListIterator(this);
    }
    
    //inner city------------------------------------
    public class MyLinkedListIterator implements Iterator<Integer>{
    	
    	public LNode state;
    	public MyLinkedList listy;
    	
    	public MyLinkedListIterator(MyLinkedList x){
    		state=null;
    		listy=x;
    	}
    	
    	public boolean hasNext(){
    		return state!=tail;
    	}
    	
    	public Integer next(){
    		if (state==null){state=start; return state.value;}
    		else {
    			state=state.next;
    			return state.value;
    		}
    			//throw new NoSuchElementException("No more elements!");
    	}
    	
    	public void remove(){
    		throw new UnsupportedOperationException();
    	}
    }
    //inner city------------------------------------
    
    public MyLinkedList(){
    	start=null;
    	size=0;
    }
    public boolean add(int value){//doubly linked
         if (size==0) {
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
    	for (int i=0; i<size; i++){
    		if (i==size-1){x+=getNode(i).value;}
    		else{
    			x+=getNode(i).value+", ";
    		}
    	}
    	x+="]";
    	return x;
    }
    
    public int get(int index){//won't change
    	if (index>=size || index<0){throw new IllegalArgumentException();}
    	LNode current=start;
    	if (start == null){return 0;}
    	for (int i=0; i<index; i++){
    		current = current.next;
    	}
    	return current.value;
    }
    
    public int set(int index, int newValue){//modified
    	if (index>=size || index<0){throw new IllegalArgumentException();}
    	if (start == null){start = new LNode(newValue);}
    	int x = getNode(index).value;
    	getNode(index).value = newValue;
    	return x;
    }
    
    public int indexOf(int value){//modified
    	if (start == null){return -1;}
    	for (int i=0; i<size; i++){
    		if (getNode(i).value==value){return i;}
    	}
    	return -1;
    }
    
    public void add(int index, int value){//doubly linked
    	if (index>size || index<0){throw new IllegalArgumentException();}
        	LNode thing=new LNode(value);
        	if (index==0){
        		if (size==0){
                    start=thing;
                    tail=thing;
        		}
        		else{
        			start.prev=thing;
        			thing.next=start;
        			start=thing;
        		}
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
    	int x=getNode(index).value;
    	if (index==0){ 
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
    	margaret.add(0,10);
    	margaret.add(1,5);
    	margaret.add(0,0);
    	margaret.add(0,6);
    	margaret.add(1,9);
    	MyLinkedList penn=new MyLinkedList();
    	penn.add(0);
    	penn.add(-1);
    	System.out.println(margaret.toString());
    	Iterator x=penn.iterator();
    	while (x.hasNext()){
    		System.out.println(""+x.next());
    	}
    }
}