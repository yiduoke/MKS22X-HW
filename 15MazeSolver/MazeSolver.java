import java.util.Arrays;

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
		if (style==0){
			solveDepth();
		}
		else if(style==1){
			solveBreadth();
		}
		else if(style==2){
			solveBest();
		}
		else{
			solveStar();
		}
	}
	
	private void solveDepth(){
		StackFrontier pancakes=new StackFrontier();
		pancakes.add(maze.getStart());
		int currentX=maze.getStart().getX();
		int currentY=maze.getStart().getY();
		Location currentLocation=pancakes.peek();
		
		while (pancakes.peek()!=maze.getEnd() && pancakes.size()!=0){
			if (animate){
				System.out.println(maze.toString());
			}
			int[] xMove={0,0,-1,1};
			int[] yMove={1,-1,0,0};
			for (int i=0; i<4; i++){
				int nextX=currentX+xMove[i];
				int nextY=currentY+yMove[i];
				if (maze.get(nextX, nextY)==' '){
					Location nextLocation=new Location(nextX,nextY,currentLocation,distanceToStart(currentX,currentY,maze.getStart().getX(),maze.getStart().getY()), distanceToGoal(currentX,currentY,maze.getEnd().getX(),maze.getEnd().getY()));
					pancakes.add(nextLocation);
					maze.set(nextX, nextY, '.');
					pancakes.next();
				}
			}
		}
	}
	
	private void solveBreadth(){
		QueueFrontier line=new QueueFrontier();
		line.add(maze.getStart());
		int currentX=maze.getStart().getX();
		int currentY=maze.getStart().getY();
		Location currentLocation=line.peek();
		
		while (line.peek()!=maze.getEnd() && line.size()!=0){
			if (animate){
				System.out.println(maze.toString());
			}
			int[] xMove={0,0,-1,1};
			int[] yMove={1,-1,0,0};
			for (int i=0; i<4; i++){
				int nextX=currentX+xMove[i];
				int nextY=currentY+yMove[i];
				if (maze.get(nextX, nextY)==' '){
					Location nextLocation=new Location(nextX,nextY,currentLocation,distanceToStart(currentX,currentY,maze.getStart().getX(),maze.getStart().getY()), distanceToGoal(currentX,currentY,maze.getEnd().getX(),maze.getEnd().getY()));
					line.add(nextLocation);
					maze.set(nextX,nextY,'.');
					line.next();
				}
			}
		}
	}
	
	public void solveBest(){
		FrontierPriorityQueue line=new FrontierPriorityQueue();
		line.add(maze.getStart());
		int currentX=maze.getStart().getX();
		int currentY=maze.getStart().getY();
		Location currentLocation=line.peek();
		
		while (line.peek()!=maze.getEnd() && line.size()!=0){
			if (animate){
				System.out.println(maze.toString());
			}
			int[] xMove={0,0,-1,1};
			int[] yMove={1,-1,0,0};
			
			for (int i=0; i<4; i++){
				int nextX=currentX+xMove[i];
				int nextY=currentY+yMove[i];
				if (maze.get(nextX, nextY)==' '){
					Location nextLocation=new Location(nextX,nextY,currentLocation,distanceToStart(currentX,currentY,maze.getStart().getX(),maze.getStart().getY()), distanceToGoal(currentX,currentY,maze.getEnd().getX(),maze.getEnd().getY()));
					line.add(nextLocation);
					maze.set(nextX, nextY, '.');
					line.next();
				}
			}
		}
	}
	
	public void solveStar(){
		FrontierPriorityQueue line=new FrontierPriorityQueue();
		line.add(maze.getStart());
		int currentX=maze.getStart().getX();
		int currentY=maze.getStart().getY();
		Location currentLocation=line.peek();
		
		while (line.peek()!=maze.getEnd() && line.size()!=0){
			if (animate){
				System.out.println(maze.toString());
			}
			int[] xMove={0,0,-1,1};
			int[] yMove={1,-1,0,0};
			
			for (int i=0; i<4; i++){
				int nextX=currentX+xMove[i];
				int nextY=currentY+yMove[i];
				if (maze.get(nextX, nextY)==' '){
					Location nextLocation=new Location(nextX,nextY,currentLocation,distanceToStart(currentX,currentY,maze.getStart().getX(),maze.getStart().getY()), distanceToGoal(currentX,currentY,maze.getEnd().getX(),maze.getEnd().getY()),true);
					line.add(nextLocation);
					maze.set(nextX, nextY, '.');
					line.next();
				}
			}
		}
	}
	
	public int distanceToStart(int x, int y, int a, int b){
		return Math.abs(x-a)+Math.abs(y-b);
	}
	
	public int distanceToGoal(int x, int y, int a, int b){
		return Math.abs(x-a)+Math.abs(y-b);
	}
}
