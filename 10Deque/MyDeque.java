public class MyDeque{
    private int start;
    private int end;
    private int size;
    private String[] deck;

    public MyDeque(){
	deck=new String[10];
	start=0;
    }

    public void addFirst(String x){
	String[] temp;
	if (size==deck.length){
	    temp=new String[deck.length*2];
	}
        else{temp=new String[deck.length];}
	    for (int i=1; i<deck.length; i++){
		temp[i]=deck[i];
	    }	    deck=temp;
	    deck[0]=x;
	    size++;
    }

    public void addLast(String x){
	if ((end+1%)deck.length!=start){
	    deck[(end+1)%deck.length]=x;
	}
	else{
	    String[] temp=new String[deck.length*2];
	    for (int i=0; i<deck.length; i++){
		temp[i]=deck[i];
	    }
	    deck=temp;
	    deck[end+1]=x;
	}
	size++;
    }

    public String removeLast(){
	last=(last-1)%deck.length;

    }
    public String removeFirst(){
	first=(first+1)%deck.length;
    }
    

    
}
