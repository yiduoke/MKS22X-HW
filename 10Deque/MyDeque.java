public class MyDeque{
    private int start;
    private int end;
    private int size;
    private String[] deck;
    
    public MyDeque(){deck=new String[10];}

   public void addFirst(String x){
	   if (size==0){
		   start=0;
		   end=0;
		   deck[0]=x;
		   size++;
		   return;
	   }
	   if (size==deck.length){
		   expand();
		   start=deck.length-1;
	   }
	   else{
		   start=Math.floorMod(start-1, deck.length);
	   }
	   deck[start]=x;
	   size++;
   }
    
   public void addLast(String x){
	   if (size==0){
		   start=0;
		   end=0;
		   deck[0]=x;
		   size++;
		   return;
	   }
	   if (size==deck.length){
		   expand();
		   end=size;
	   }
	   else{
		   end=Math.floorMod(end+1, deck.length);
	   }
	   deck[end]=x;
	   size++;
   }
   
   private void expand(){
	   String[] temp=new String[deck.length*2];
	   for (int i=0; i<size; i++){
		  temp[i]=deck[Math.floorMod(start+i, deck.length)];
	   }
	   deck=temp;
   }
   
   public String removeFirst(){
	   String x=deck[start];
	   size--;
	   start=Math.floorMod(start+1, deck.length);
	   return x;
   }
   
   public String removeLast(){
	   String x=deck[end];
	   size--;
	   end=Math.floorMod(end-1, deck.length);
	   return x;
   }
   
   public String getFirst(){return deck[start];}
   
   public String getLast(){return deck[end];}
   
   public String toString(){
	   String x="";
	   for (int i=0; i<size; i++){
		   x+=deck[Math.floorMod(start+i, deck.length)]+" ";
	   }
	   return x;
   }
   
   public static void main(String[] args){
	   MyDeque margaret = new MyDeque();
	   margaret.addFirst("hola");
	   margaret.addFirst("hi");
	   margaret.addLast("hiii");
	   margaret.addLast("meee");
	   System.out.println(margaret);
   }
   
   
}