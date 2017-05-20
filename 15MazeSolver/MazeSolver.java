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
		
		while (pancakes.size()!=0){
			if (animate){
				System.out.println(maze.toString());
			}
			
			Location current=pancakes.next();
			maze.set(current.getX(), current.getY(), '.');
			if (maze.getEnd().getX()==current.getX()&& maze.getEnd().getY()==current.getY()){
				maze.set(current.getX(),current.getY(), '.');
				return;
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
	}
	
	private void solveBreadth(){
		QueueFrontier people=new QueueFrontier();
		people.add(maze.getStart());
		
		while (people.size()!=0){
			if (animate){
				System.out.println(maze.toString());
			}
			
			Location current=people.next();
			maze.set(current.getX(), current.getY(), '.');
			if (maze.getEnd().getX()==current.getX()&& maze.getEnd().getY()==current.getY()){
				maze.set(current.getX(),current.getY(), '.');
				return;
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
	}
	
	public void solveBest(){
		FrontierPriorityQueue richPeople=new FrontierPriorityQueue();
		richPeople.add(maze.getStart());
		
		while (richPeople.size()!=0){
			if (animate){
				System.out.println(maze.toString());
			}
			Location current=richPeople.next();
			
			maze.set(current.getX(), current.getY(), '.');
			
			if (maze.getEnd().getX()==current.getX()&& maze.getEnd().getY()==current.getY()){
				maze.set(current.getX(),current.getY(), '.');
				return;
			}
			
			int[] xMove={0,0,-1,1};
			int[] yMove={1,-1,0,0};		
			for (int i=0; i<4; i++){
				int nextX=current.getX()+xMove[i];
				int nextY=current.getY()+yMove[i];
				if (maze.get(nextX, nextY)==' '){
					Location nextLocation=new Location(nextX,nextY,current,0, distanceToGoal(current.getX(),current.getY(),maze.getEnd().getX(),maze.getEnd().getY()));
					richPeople.add(nextLocation);
				}
			}
		}
	}
	
	public void solveStar(){
		FrontierPriorityQueue tycoons=new FrontierPriorityQueue();
		tycoons.add(maze.getStart());
		
		while (tycoons.size()!=0){
			if (animate){
				System.out.println(maze.toString());
			}
			Location current=tycoons.next();
			maze.set(current.getX(), current.getY(), '.');
			if (maze.getEnd().getX()==current.getX()&& maze.getEnd().getY()==current.getY()){
				maze.set(current.getX(),current.getY(), 'E');
				return;
			}
			
			int[] xMove={0,0,-1,1};
			int[] yMove={1,-1,0,0};		
			for (int i=0; i<4; i++){
				int nextX=current.getX()+xMove[i];
				int nextY=current.getY()+yMove[i];
				if (maze.get(nextX, nextY)==' '){
					Location nextLocation=new Location(nextX,nextY,current,distanceToStart(current.getX(),current.getY(),maze.getStart().getX(),maze.getStart().getY()), distanceToGoal(current.getX(),current.getY(),maze.getEnd().getX(),maze.getEnd().getY()),true);
					tycoons.add(nextLocation);
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
	
	public static void main(String[] args){
		MazeSolver margaret=new MazeSolver("data1.txt",true);
		margaret.solve(3);
	}
}