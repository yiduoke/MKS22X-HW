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
    public int get (int index){}
    public int set(int index, int newValue){}
    public int indexOf(int value){}
    public boolean add(int index, int value){}
    public int remove(int index){}
    
    public static void main(String[] args){
    	MyLinkedList margaret = new MyLinkedList();
    	margaret.add(10);
    	margaret.add(5);
    	System.out.println(margaret.toString());
    	System.out.println(margaret.size);
    }
}