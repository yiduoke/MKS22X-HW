
public class QueenBoard {
	private int[][]board;
    	private int solutionCount;
    	private int[][]oneSolution;
    
	public QueenBoard(int size){
			board = new int[size][size];
			oneSolution=new int[size][size];
			solutionCount=-1;
		    }
	public void addQueen(int r, int c){
		board[r][c]--;//-1 = a queen
		for (int x=0; x<board.length;x++){
			for (int y=0; y<board.length; y++){
				if (!(x==r && y== c)){
					if (x==r || y==c || Math.abs(r-x)==Math.abs(c-y)){board[x][y]++;}//+1 to the squares it threatens					
				}
			}
		}
	}
	public void removeQueen(int r, int c){//basically anti-addQueen
		board[r][c]++;
		for (int x=0; x<board.length;x++){
			for (int y=0; y<board.length; y++){
				if (!(x==r && y== c)){//+1 to the squares it threatens
					if (x==r || y==c || Math.abs(r-x)==Math.abs(c-y)){board[x][y]--;}					
				}
			}
		}
	}
    public void solve(){
    	solveH(0);
	solutionCount=0;
    }
    public void countSolutions(){
	solutionCount=0;
	countSolutionsH(0);
    }
    private void countSolutionsH(int c){
    	if (c>=board.length){
    		solutionCount++;
		return;	
    	}
    	for (int r=0; r<board.length; r++){
    			if (board[r][c]==0){
    				addQueen(r,c);
    				countSolutionsH(c+1);
    				removeQueen(r,c);
    			}
    		}
    }

	private boolean solveH(int c){
	    	if (c>=board.length){
    		for (int r=0; r<board.length; r++){
    			for (int cee=0; cee<board.length; cee++){
    				oneSolution[r][cee]=board[r][cee];
    			}
    		}
    		return true;
    	}
    	for (int r=0; r<board.length; r++){
    			if (board[r][c]==0){
    				addQueen(r,c);
				if (solveH(c+1)){
    				solveH(c+1); return true;}
    				else{removeQueen(r,c);}
    			}
    		}
	return false;
    }
    
    public int getSolutionCount(){return solutionCount;}
    public String toString(){
    	String x="";
    	for (int r=0;r<board.length;r++){
    		for (int c=0;c<board.length;c++){
    			if (c==board.length-1){
    				if (oneSolution[r][c]==-1){x+="Q"+"\n";}
    				else{x+="_"+"\n";}
    			}
    			else{    				
    				if (oneSolution[r][c]==-1){x+="Q ";}
    				else{x+="_ ";}
    				}
    		}
    	}
    	return x;
    }
    
    public static void main(String[] args){
    	QueenBoard marg=new QueenBoard(4);	
	marg.countSolutions();
    	System.out.println(marg.solutionCount);
    }
    
}
