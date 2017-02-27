import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Maze{
    private char[][] maze;
    private boolean animate;

    public Maze (String filename, boolean ani){
	temp oneD[] String=new String[0];
	File infile=new File(filename);
	Scanner inf = new Scanner(text);
	int lineNumber=0;
	while (inf.hasNextLine()){
	    String line=inf.nextLine();
	    oneD=String[lineNumber+1];
	    oneD[lineNumber]=line;
	    lineNumber++;
	}
	
	temp twoD[lineNumber+1][] char = new char[lineNumber+1][0]; 
    }
  public static void main(String args[]) throws FileNotFoundException {
        //instead of a try/catch, you can throw the FileNotFoundException.
        File infile = new File("input.txt");// can be a path"/full/path/to/file.txt" 
        Scanner inf = new Scanner(text);
        int lineNumber = 1;
        while(inf.hasNextLine()){
            String line = inf.nextLine();
            System.out.println(line);
        }       
    }   
}
