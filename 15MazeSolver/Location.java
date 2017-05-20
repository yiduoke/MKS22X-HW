public class Location implements Comparable<Location>{
    private int row;
    private int col;
    private Location previous;
    private int distanceToStart;
    private int distanceToGoal;
    private boolean aStar;

    public Location(int x, int y, Location prev, int toStart, int toGoal){
	row=x;
	col=y;
	previous=prev;
	distanceToStart=toStart;
	distanceToGoal=toGoal;
    }

    public Location(int x, int y, Location prev, int toStart, int toGoal, boolean star){
	row=x;
	col=y;
	previous=prev;
	distanceToStart=toStart;
	distanceToGoal=toGoal;
	aStar=star;
    }

    public int compareTo(Location other){
	if (aStar){
	    return (distanceToGoal+distanceToStart)-(other.distanceToGoal()+other.distanceToStart());
	}
	else{
	    return distanceToGoal-other.distanceToGoal();
	}
    }

    public int distanceToStart(){
    	return distanceToStart;
    }

    public int distanceToGoal(){
    	return distanceToGoal;
    }
    
    public Location previous(){
    	return previous;
    }
    
    public int getX(){
    	return row;
    }
    
    public int getY(){
    	return col;
    }
}