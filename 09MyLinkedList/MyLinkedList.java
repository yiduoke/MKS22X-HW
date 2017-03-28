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
	
	return true;
    }
    public int size(){return size;}
    public String toString(){}
    public int get (int index){}
    public int set(int index, int newValue){}
    public int indexOf(int value){}
    public boolean add(int index, int value){}
    public int remove(int index){}
}
