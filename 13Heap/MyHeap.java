import java.util.ArrayList;

public class MyHeap {
	private ArrayList<String> list;
	private boolean max;
	private int size;
	
	public MyHeap(){
		list=new ArrayList<String>();
	}
	
	public MyHeap(boolean x){
		if (x){
			max=true;
		}
		list=new ArrayList<String>();
	}
	
	public void add(String x){
		if (size==0){
			list.add("");
			list.add(x);
			size++;
			return;
		}
		else{
			list.add(x);
			size++;
		}
		int i=size;
		if (max){
			while (list.get(i).compareTo(list.get(i/2))>0 && i>1){
				swap(i,i/2);
				i/=2;
			}
		}
		else{
			while (list.get(i).compareTo(list.get(i/2))<0 && i>1){
				swap(i,i/2);
				i/=2;
			}
		}
	}
	
	public String remove(){
		String x=list.get(1);
		list.set(1, list.get(size));
		int i=1;
		if (max){
			while (i<=size/2){
				if (list.get(i*2).compareTo(list.get(i*2+1))>=0){
					swap(i,i*2);
					i*=2;
				}
				else{
					swap(i,i*2+1);
					i=i*2+1;
				}
			}
		}
		else{
			while (i<=size/2){
				if (list.get(i*2).compareTo(list.get(i*2+1))<=0){
					swap(i,i*2);
					i*=2;
				}
				else{
					swap(i,i*2+1);
					i=i*2+1;
				}
				
			}
		}
		size--;
		return x;
	}
	
	public String peek(){
		return list.get(1);
	}
	
	public String toString(){
		String x="";
		for (int i=1; i<=size; i++){
			x+=list.get(i)+" ";
		}
		return x;
	}
	
	private void swap(int x, int y){
		String a=list.get(x);
		list.set(x, list.get(y));
		list.set(y, a);
	}
    public int size(){
	return size;
    }

    public static void main(String[] args){
	    MyHeap margaret=new MyHeap(false);
	    margaret.add("A");
	    margaret.add("B");
	    margaret.add("C");
	    System.out.println(margaret);
	    System.out.println(margaret.remove());
	    System.out.println(margaret);
	    
	}
}
