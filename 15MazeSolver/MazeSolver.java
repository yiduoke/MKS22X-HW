
public class MazeSolver {
	private Maze maze;
	private boolean animate;
	
	MazeSolver(String filename){  
		this(filename,false); 
	} 
	
	MazeSolver(String filename, boolean animate){
		maze=new Maze(filename);
		this.animate=animate;
	}
	
	public void solve(int style){
		
	}
	
	private void solveDepth(){
		StackFrontier pancakes=new StackFrontier();
		pancakes.add(maze.getStart());
		int currentX=maze.getStart().getX();
		int currentY=maze.getStart().getY();
		Location currentLocation=pancakes.peek();
		
		while (pancakes.peek()!=maze.getEnd() && pancakes.size()!=0){
			int[] xMove={0,0,-1,1};
			int[] yMove={1,-1,0,0};
			for (int i=0; i<4; i++){
				int nextX=currentX+xMove[i];
				int nextY=currentY+yMove[i];
				if (maze.get(nextX, nextY)==' '){
					Location nextLocation=new Location(nextX,nextY,currentLocation,currentLocation.distanceToStart(), currentLocation.distanceToGoal());
					pancakes.add(nextLocation);
					maze.set(nextX, nextY, '.');
					pancakes.next();
				}
			}
		}
	}
}
