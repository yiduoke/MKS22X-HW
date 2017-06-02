import java.util.NoSuchElementException;

public class MyDeque{
    private int start;
    private int end;
    private int size;
    private String[] deck;
    
    public MyDeque(){
    	deck=new String[10];
    	}

   public void addFirst(String x) throws NullPointerException{
	   if (x==null){
		   throw new NullPointerException();
	   }
	   else{
		   if (size==deck.length){
			   expand();
		   }
		   start=floorMod(start-1,deck.length);
		   deck[start]=x;
		   size++;
	   }
   }
   
   public void addLast(String x) throws NullPointerException{
	   if (x==null){
		   throw new NullPointerException();
	   }
	   else{
		   if (size==deck.length){
			   expand();
		   } 
		   deck[end]=x;
		   end=floorMod(end+1,deck.length);
		   size++;
	   }
   }
   
   public int floorMod(int x, int y){
	   if (x>=0){
		   return x%y;
	   }
	   else{
		   return x+y;
	   }
   }
   
   private void expand(){
	   String[] temp=new String[deck.length*2];
	   for (int i=0; i<=size; i++){
		   temp[i]=deck[start];
		   start=floorMod(start+1,deck.length);
	   }
	   start=0;
	   end=size;
	   deck=temp;
   }
   
   public String removeFirst() throws NoSuchElementException{
	   if (size==0){
		   throw new NoSuchElementException( "Empty deque! Cannot remove");
	   }
	   String x=deck[start];
	   start=floorMod(start+1, deck.length);
	   size--;
	   return x;

   }
   
   public String removeLast() throws NoSuchElementException{
	   if (size==0){
		   throw new NoSuchElementException( "Empty deque! Cannot remove");
	   }
	   else{
		   end=floorMod(end-1, deck.length);
		   size--;
		   String x=deck[end];
		   return x;   
	   }
   }
   
   public String getFirst() throws NoSuchElementException{
	   if (size==0){
		   throw new NoSuchElementException( "Empty Deque");
	   }
	   else{
		   return deck[start];
	   }
   }
   
   public String getLast() throws NoSuchElementException{
	   if (size==0){
		   throw new NoSuchElementException( "Empty Deque");
	   }
	   else{
		   return deck[end];
	   }
   }
   
   public String toString(){
	   String x="";
	   for (int i=0; i<size; i++){
		   x+=deck[floorMod(start+i, deck.length)]+" ";
	   }
	   return x;
   }
   
   public static void main(String[] args){
	   MyDeque Margaret=new MyDeque();
	   System.out.println(Margaret.floorMod(-2,5));
	   System.out.println(Margaret.floorMod(0,5));
	   System.out.println(Margaret.floorMod(7,5));
   }
   
   
}

