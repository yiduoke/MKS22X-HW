import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class makelake {
	private int[][] lake;
	private int elevation;
	private int numSteps;
	
	public makelake(String filename){
    	ArrayList<Integer> stuffs=new ArrayList<Integer>();
    	File infile=new File(filename);
    	Scanner inf ;
    	try {
    		inf = new Scanner(infile);
    		while (inf.hasNext()){
    			String token=inf.next();
    			stuffs.add(Integer.parseInt(token));
    		}
    		
    		lake = new int[stuffs.remove(0)][stuffs.remove(0)];
    		elevation = stuffs.remove(0);
    		numSteps = stuffs.remove(0);
    		
    		int index=0;
    		for (int r=0; r<lake.length; r++){
    			for (int c=0; c<lake[0].length; c++){
    				lake[r][c]=stuffs.get(index);
    				index++;
    			}
    		}
	    	}
    		catch (FileNotFoundException e) {
    			System.out.println(filename+" does not exist");
			}
	}
	
	public String toString(){
		String x="";
		for (int r=0; r<lake.length; r++){
			for (int c=0; c<lake[0].length; c++){
				x+=lake[r][c]+" ";
			}
			x+="\n";
		}
		return x;
	}
	
	public static void main(String[] args){
		makelake margaret= new makelake("lake1.txt");
		System.out.println(margaret);
		System.out.println(margaret.elevation);
		System.out.println(margaret.numSteps);
	}
}
