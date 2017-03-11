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
    
    private boolean inBounds(int r, int c){
    	return r>=0 && r<maze.length && c>=0 && c<maze[0].length;
    }
	
	public int solve(){
		countSolutions(startRow, startCol,0);
		return solutions;
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
	
	public static void main(String[] args){
		Silver margaret = new Silver(args[0]);
		System.out.println(margaret.solve());
	}
}
