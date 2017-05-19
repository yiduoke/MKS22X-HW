
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
		
	}
}
