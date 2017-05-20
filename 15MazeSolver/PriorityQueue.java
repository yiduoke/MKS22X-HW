import java.util.ArrayList;

public class PriorityQueue{
	private ArrayList<Location> list;
	private int size;
	
	public PriorityQueue(){
		list=new ArrayList<Location>();
		list.add(new Location(200, 200, null, 200, 200));
	}
	
	public void add(Location x){
		list.add(x);
		size++;
		int i=size;	
		while (i>1 && x.compareTo(list.get(i/2))<0){
			list.set(i, list.get(i/2));
			i/=2;
		}
		list.set(i,x);
	}
	
	public Location remove(){
		Location x=list.get(1);
		list.set(1, list.get(size));
		size--;
		Location temp=list.get(1);
		int child;
		for (int i=1; 2*i<=size; i=child){
			child=2*i;
			if (child!=size && list.get(child).compareTo(list.get(child+1))>0){
				child++;
			}
			if (temp.compareTo(list.get(child))>0){
				list.set(i,list.get(child));
			}
		}
		list.set(1,temp);
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
	
    public int size(){
	return size;
    }
}