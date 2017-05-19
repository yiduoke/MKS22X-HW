public class FrontierPriorityQueue implements Frontier{
    private PriorityQueue Locations;
    
    public FrontierPriorityQueue(){
    	Locations=new PriorityQueue();
    }

    public void add(Location x){
    	Locations.add(x);
    }
    
    public Location next(){
    	return Locations.remove();
    }
    
    public Location peek(){
    	return Locations.peek();
    }
    
    public int size(){
    	return Locations.size();
    }
}