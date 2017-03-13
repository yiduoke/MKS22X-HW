import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Silver {
	public int startRow;
	public int startCol;
	public int endRow;
	public int endCol;
	public int time;
    private int[] xMove={1,0,-1,0};
    private int[] yMove={0,1,0,-1};
	public char[][] maze;
	private int solutions;
	private int[][] cells;
	
	public Silver(String filename){
		ArrayList<String> mazeLines=new ArrayList<String>();
    	File infile=new File(filename);
    	Scanner inf ;
    	try {
    		inf = new Scanner(infile);
    		int rows=inf.nextInt();
    		int cols=inf.nextInt();
    		time=inf.nextInt();
    		maze=new char[rows][cols];
    		
    		for (int r=0; r<rows; r++){
    				mazeLines.add(inf.next());
    		}
    		startRow=inf.nextInt()-1;
    		startCol=inf.nextInt()-1;
    		endRow=inf.nextInt()-1;
    		endCol=inf.nextInt()-1;
    		
    		for (int r=0; r<rows; r++){
    			for (int c=0; c<cols; c++){
    				maze[r][c]=mazeLines.get(r).charAt(c);
    			}
    		}
    		cells=new int[maze.length][maze[0].length];
    		cells[startRow][startCol]=1;
    		}
    		
    		catch (FileNotFoundException e) {
    			System.out.println(filename+" does not exist");
			}
	}
    
    private void countSolutions(int r, int c, int step){      
    	if (!inBounds(r,c) || maze[r][c]=='*' || step>time){return;}
    	if (r==endRow && c==endCol && step==time){solutions++; return;}
    	
    	for (int i=0; i<4; i++){
    		int nextX=r+xMove[i];
    		int nextY=c+yMove[i];    		
    		countSolutions(nextX,nextY,step+1);
    	}
    	maze[r][c]='.';
    }
    
	public int solveSlow(){
		countSolutions(startRow, startCol,0);
		return solutions;
	}
	
	public int solve(){
		int[][]temp=new int[maze.length][maze[0].length];
		for (int i=0; i<time; i++){
			for (int row=0; row<maze.length; row++){
				for (int col=0; col<maze[0].length; col++){
					if (maze[row][col]!='*'){
						temp[row][col]=neighborSum(row,col);
					}
				}
			}
			copyOver(temp,cells);
		}
		return cells[endRow][endCol];
	}
	
	public void copyOver(int[][] from, int[][] to){
		for (int r=0; r<from.length; r++){
			for (int c=0; c<from[0].length; c++){
				to[r][c]=from[r][c];
			}
		}
	}
	
	public int neighborSum(int r, int c){
		int x=0;
		for (int i=0; i<4; i++){
			int nextX=r+xMove[i];
			int nextY=c+yMove[i];
			if (inBounds(nextX,nextY)){
				x+=cells[nextX][nextY];
			}
		}
		return x;
	}
    
    private boolean inBounds(int r, int c){
    	return r>=0 && r<maze.length && c>=0 && c<maze[0].length;
    }
	
	
    public String toString(){
    	String x="";
    	for (int i=0; i<maze.length; i++){
    		for (int j=0; j<maze[0].length; j++){
    			x+=maze[i][j];
    		}
    		x+="\n";
    	}
    	return x;
    }
    
    public String toStringCell(){
    	String x="";
    	for (int i=0; i<maze.length; i++){
    		for (int j=0; j<maze[0].length; j++){
    			x+=cells[i][j]+" ";
    		}
    		x+="\n";
    	}
    	return x;
    }
}
