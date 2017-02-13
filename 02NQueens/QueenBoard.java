
public class QueenBoard {
	private int[][]board;
    private int solutionCount;
    private int[][]oneSolution;
    
	public QueenBoard(int size){
			board = new int[size][size];
			oneSolution=new int[size][size];
		    }
	public void addQueen(int r, int c){
		board[r][c]--;//-1 = a queen
		for (int x=0; x<board.length;x++){
			for (int y=0; y<board.length; y++){
				if (!(x==r && y== c)){//+1 to the squares it threatens
					if (x==r || y==c || Math.abs(r-x)==Math.abs(c-y)){board[x][y]++;}					
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
    	solutionCount=0;
	countSolutions(0);
    	solveH(0);
    }
    public void countSolutions(int c){
    	if (c>=board.length){
    		solutionCount++;
    		for (int r=0; r<board.length; r++){
    			for (int cee=0; cee<board.length; cee++){
    				oneSolution[r][cee]=board[r][cee];
    			}
    		}
    		//return true;
		return;	
    	}
    	for (int r=0; r<board.length; r++){
    			if (board[r][c]==0){
    				addQueen(r,c);
    				countSolutions(c+1);
    				removeQueen(r,c);
    			}
    		}
    	//return solutionCount>0;
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
    	QueenBoard marg=new QueenBoard(13);	
    	marg.solve();
    	System.out.println(marg);
    }
    
}
