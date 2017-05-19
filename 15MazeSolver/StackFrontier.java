import java.util.Stack;

public class StackFrontier implements Frontier{
	private Stack<Location> Locations;
	
	public StackFrontier(){
		Locations=new Stack<Location>();
	}

	public void add(Location x) {
		Locations.push(x);
	}

	public Location next() {
		return Locations.pop();
	}
	
	public Location peek(){
		return Locations.peek();
	}
	
	public int size(){
		return Locations.size();
	}
}
