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
	
	public void solve(){
		solve(1);
	}
	
	public String toString(){
		return maze.toString();
	}
	
	private void solveDepth(){
		StackFrontier pancakes=new StackFrontier();
		pancakes.add(maze.getStart());
		Location current=new Location(0,0,null,0,0);
		
		while (pancakes.size()!=0){
			if (animate){
				System.out.println(maze.toString());
			}
			
			current=pancakes.next();
			maze.set(current.getX(), current.getY(), '.');
			if (maze.getEnd().getX()==current.getX()&& maze.getEnd().getY()==current.getY()){	
				break;
			}
			
			int[] xMove={0,0,-1,1};
			int[] yMove={1,-1,0,0};
			for (int i=0; i<4; i++){
				int nextX=current.getX()+xMove[i];
				int nextY=current.getY()+yMove[i];
				if (maze.get(nextX, nextY)==' '){
					Location nextLocation=new Location(nextX,nextY,current,0,0);
					pancakes.add(nextLocation);
				}
			}
		}
		
		while (current.previous()!=null){
			current=current.previous();
			maze.set(current.getX(), current.getY(), '@');
		}
		System.out.println(maze.toString());
	}
	
	private void solveBreadth(){
		QueueFrontier people=new QueueFrontier();
		people.add(maze.getStart());
		Location current=new Location(0,0,null,0,0);
		
		while (people.size()!=0){
			if (animate){
				System.out.println(maze.toString());
			}
			
			current=people.next();
			maze.set(current.getX(), current.getY(), '.');
			if (maze.getEnd().getX()==current.getX()&& maze.getEnd().getY()==current.getY()){	
				break;
			}
			
			int[] xMove={0,0,-1,1};
			int[] yMove={1,-1,0,0};
			for (int i=0; i<4; i++){
				int nextX=current.getX()+xMove[i];
				int nextY=current.getY()+yMove[i];
				if (maze.get(nextX, nextY)==' '){
					Location nextLocation=new Location(nextX,nextY,current,0,0);
					people.add(nextLocation);
				}
			}
		}
		
		while (current.previous()!=null){
			current=current.previous();
			maze.set(current.getX(), current.getY(), '@');
		}
		System.out.println(maze.toString());
	}
	
	public void solveBest(){
		FrontierPriorityQueue richPeople=new FrontierPriorityQueue();
		richPeople.add(maze.getStart());
		Location current=new Location(0,0,null,0,0);
		
		while (richPeople.size()!=0){
			if (animate){
				System.out.println(maze.toString());
			}
			current=richPeople.next();
		
			maze.set(current.getX(), current.getY(), '.');
			
			if (maze.getEnd().getX()==current.getX()&& maze.getEnd().getY()==current.getY()){	
				break;
			}
			
			int[] xMove={0,0,-1,1};
			int[] yMove={1,-1,0,0};		
			for (int i=0; i<4; i++){
				int nextX=current.getX()+xMove[i];
				int nextY=current.getY()+yMove[i];
				if (maze.get(nextX, nextY)==' '){
					Location nextLocation=new Location(nextX,nextY,current,0, distanceToGoal(current.getX(),current.getY()));
					richPeople.add(nextLocation);
				}
			}
		}
		
		while (current.previous()!=null){
			current=current.previous();
			maze.set(current.getX(), current.getY(), '@');
		}
		System.out.println(maze.toString());
	}
	
	public void solveStar(){
		FrontierPriorityQueue tycoons=new FrontierPriorityQueue();
		tycoons.add(maze.getStart());
		Location current=maze.getStart();
		
		while (tycoons.size()!=0){
			if (animate){
				System.out.println(maze.toString());
			}
			current=tycoons.next();
			maze.set(current.getX(), current.getY(), '.');
			if (maze.getEnd().getX()==current.getX()&& maze.getEnd().getY()==current.getY()){
				break;
			}
			
			int[] xMove={0,0,-1,1};
			int[] yMove={1,-1,0,0};		
			for (int i=0; i<4; i++){
				int nextX=current.getX()+xMove[i];
				int nextY=current.getY()+yMove[i];
				if (maze.get(nextX, nextY)==' '){
					Location nextLocation=new Location(nextX,nextY,current,distanceToStart(current.getX(),current.getY()), distanceToGoal(current.getX(),current.getY()),true);
					tycoons.add(nextLocation);
				}
			}
		}
		
		while (current.previous()!=null){
			maze.set(current.getX(), current.getY(), '@');
			current=current.previous();
		}
		System.out.println(toString());
	}
	
	public int distanceToStart(int x, int y){
		int a=maze.getStart().getX();
		int b=maze.getStart().getY();
		return Math.abs(x-a)+Math.abs(y-b);
	}
	
	public int distanceToGoal(int x, int y){
		int a=maze.getEnd().getX();
		int b=maze.getEnd().getY();
		return Math.abs(x-a)+Math.abs(y-b);
	}
}