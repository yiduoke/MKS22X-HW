import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze{
    private char[][] maze;
    private boolean animate;
    private int startRow;
    private int startCol;
    private int[] xMove={1,0,-1,0};
    private int[] yMove={0,1,0,-1};

    public Maze (String filename, boolean ani){
    	animate=ani;
    	ArrayList<String> lines=new ArrayList<String>();
    	File infile=new File(filename);
    	Scanner inf ;
    	try {
    		inf = new Scanner(infile);
    		int rows=0;
    		while (inf.hasNextLine()){
    			String line=inf.nextLine();
    			lines.add(line);
    			rows++;
    		}
    		int columns=0;
    		try{
    			while (lines.get(0).charAt(columns)=='#'){
    				columns++;
    			}
    		}
    		catch(StringIndexOutOfBoundsException e){}
    		maze= new char[rows][columns+1]; 
    		for (int i=0; i<rows; i++){
    			String eachRow=lines.get(i);
    			for (int j=0; j<columns; j++){
    				maze[i][j]=eachRow.charAt(j);
    				if (maze[i][j]=='S'){startRow=i; startCol=j;}
    			}
    		}
	    	}
    		catch (FileNotFoundException e) {
    			System.out.println(filename+" does not exist");
			}
    }
    
    private void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }
    
    public void setAnimate(boolean b){
        animate = b;
    }
    
    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }
    
    private boolean solve(int row, int col){
    	 if(animate){
             System.out.println("\033[2J\033[1;1H"+this);
             wait(20);
         }
    	
    	if (maze[row][col]=='E'){return true;} 	
    	
    	else{           
        	if (deadEnd(row, col)){
        		maze[row][col]='.'; 	
        		return false;
        		}
            else {
            	maze[row][col]='@'; 	
            	}
        	
            int[] goRanks = new int[4];
    		for (int i=0; i<4; i++){
    			int nextX=row+xMove[i];
    			int nextY=col+yMove[i];
    			if (maze[nextX][nextY]=='E'){
    				goRanks[i]=i;
    			}
    			else if (maze[nextX][nextY]==' '){
    				goRanks[i]=10+i;
    			}
    			else if (maze[nextX][nextY]=='@'){
    				goRanks[i]=20+i;
    			}
    			else{
    				goRanks[i]=30;
    			}
    		}
    		java.util.Arrays.sort(goRanks);
    		
            
    		for (int i=0; i<4; i++){
    			int nextX=row+xMove[goRanks[i]%10];
    			int nextY=col+yMove[goRanks[i]%10];
    			if (canGo(nextX,nextY) && solve(nextX,nextY)){
    				return true;
    			}
    			else{maze[row][col]='.';}
    		}
		}
	return false;
    }
    
    private boolean canGo(int r, int c){
    	return maze[r][c]!='#' && maze[r][c]!='.';
    }
    
    private boolean inBounds(int r, int c){
    	return r>=0 && r<maze.length && c>=0 && c<maze[0].length;
    }
    
    private boolean deadEnd(int r, int c){
	int x=0;
	for (int i=0; i<4; i++){
	    int nextX=r+xMove[i];
	    int nextY=c+yMove[i];
	    if (maze[nextX][nextY]==' ' || maze[nextX][nextY]=='E'){x++;}
	}
	return !(x>0);
    }

    public void solve(){
    	solve(startRow, startCol);
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
}