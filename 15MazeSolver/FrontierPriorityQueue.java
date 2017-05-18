public class FrontierPriorityQueue{
    private PriorityQueue<Location> PQ;

    public void add(Location x){
	PQ.add(x);
    }
    public Location next(){
	return PQ.next();
    }
}
