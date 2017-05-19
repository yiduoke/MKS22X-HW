import java.util.LinkedList;

public class QueueFrontier implements Frontier{
	private LinkedList<Location> Locations;
	
	public QueueFrontier(){
		Locations=new LinkedList<Location>();
	}

	public void add(Location x){
		Locations.add(x);
	}
	
	public Location next(){
		return Locations.remove();
	}
}
