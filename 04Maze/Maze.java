import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Maze{
    private char[][] maze;
    private boolean animate;
    private int startRow;
    private int startCol;
    private int[] xMove={1,1,-1,-1};
    private int[] yMove={1,-1,1,-1};

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
    
    private boolean solveH(int row, int col){
    	if (maze[row][col]=='E'){return true;}
	if (surrounded(row,col)){
	    maze[row][col]='.';
	    goBack(row,col);
	}
	else{
	    for (int i=0; i<4; i++){
		int nextX=row+xMove[i];
		int nextY=col+yMove[i];
		if (canGo(nextX,nextY)){
		    solveH(nextX,nextY);
		}
	    }
	}
	return false;
    }
    
    private void surrounded(int r, int c){
	int x=0;
	for (int i=0; i<4; i++){
	    int nextX=r+xMove[i];
	    int nextY=c+yMove[i];
	    if (maze[nextX][nextY]=='#'){x++;}
	}
	return x>2;
    }

    public void solve(){
    	solveH(startRow, startCol);
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
    	Maze marg=new Maze("maze1.txt",false);
    	System.out.println(marg);
    }
}
