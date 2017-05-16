public class PriorityQueue{
	private ArrayList<Location> list;
	private boolean max;
	private int size;
	
	public MyHeap(){
		list=new ArrayList<Location>();
	}
	
	public MyHeap(boolean x){
		if (x){
			max=true;
		}
		list=new ArrayList<Location>();
	}
	
	public void add(Location x){
		if (size==0){
			list.add(5);
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
	
	public int remove(){
		int x=list.get(1);
		int i=1;
		if (max){
			while (i<=size/2){
				if (i==size/2 && size%2==0){
					list.set(i,list.get(i*2));
					size--;
					return x;
				}
				if (list.get(i*2).compareTo(list.get(i*2+1))>=0){
					list.set(i, list.get(i*2));
					i*=2;
				}
				else{
					list.set(i, list.get(i*2+1));
					i=i*2+1;
				}
				//list.set(i, list.get(i*2));	
			}
		}
		else{
			while (i<=size/2){
				if (i==size/2 && size%2==0){
					list.set(i,list.get(i*2));
					size--;
			    	return x;
				}
				if (list.get(i*2).compareTo(list.get(i*2+1))<=0){
					list.set(i, list.get(i*2));
					i*=2;
				}
				else{
					list.set(i, list.get(i*2+1));
					i=i*2+1;
				}
				//list.set(i, list.get(i*2));
				
			}
		}
		size--;
		return x;
	}
	
	public Integer peek(){
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
		int a=list.get(x);
		list.set(x, list.get(y));
		list.set(y, a);
	}
    public int size(){
	return size;
    }
}
