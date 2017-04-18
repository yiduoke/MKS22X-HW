public class MyDeque{
    private int start;
    private int end;
    private int size;
    private String[] deck;
    
    public MyDeque(){deck=new String[10];}

   public void addFirst(String x){
	   if (size==deck.length){
		   expand();
		   start=deck.length-1;
	   }
	   else{
		   start=(start-1)%deck.length;
	   }
	   deck[start]=x;
	   size++;
   }
    
   public void addLast(String x){
	   if (size==deck.length){
		   expand();
		   end=size;
	   }
	   else{
		   end=(end+1)%deck.length;
	   }
	   deck[end]=x;
	   size++;
   }
   
   private void expand(){
	   String[] temp=new String[deck.length*2];
	   for (int i=0; i<size; i++){
		  temp[i]=deck[(start+i)%deck.length];
	   }
   }
   
   public String removeFirst(){
	   String x=deck[start];
	   size--;
	   start=(start+1)%deck.length;
	   return x;
   }
   
   public String removeLast(){
	   String x=deck[end];
	   size--;
	   end=(end-1)%deck.length;
	   return x;
   }
   
   public String getFirst(){return deck[start];}
   
   public String getLast(){return deck[end];}
}