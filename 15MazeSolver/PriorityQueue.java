import java.util.ArrayList;

public class PriorityQueue{
	private ArrayList<Location> list;
	private boolean max;
	private int size;
	
	public PriorityQueue(){
		list=new ArrayList<Location>();
		list.add(null);
		max=false;
	}
	
	public void add(Location x){
		list.add(x);
		size++;
		int i=size;	
		while (i>1 && list.get(i).compareTo(list.get(i/2))<0){
			//swap(i,i/2);
			list.set(i, list.get(i/2));
			i/=2;
		}
		list.set(i,x);
	}
	
	public Location remove(){
		Location x=list.get(1);
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
					//swap(i,i*2);
					i*=2;
				}
				else{
					//swap(i,i*2+1);
					i=i*2+1;
				}			
			}
		}
		size--;
		return x;
	}
	
	public Location peek(){
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
		Location a=list.get(x);
		list.set(x, list.get(y));
		list.set(y, a);
	}
    public int size(){
	return size;
    }
}