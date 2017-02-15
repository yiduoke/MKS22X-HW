public class KnightBoard{
    private int[][]board;
    pubic KnightBoard(int startingRows, int startingCols){
	board=new[startingRows][startingCols];
}

    public String toString(){
    	String x="";
    	for (int r=0;r<board.length;r++){
    		for (int c=0;c<board.length;c++){
    			if (c==board.length-1){
			    x+=board[r][c]+"\n";
    			}
    			else{    				
    		            x+=board[r][c]+" ";
    				}
    		}
    	}
    	return x;
    }

    public void solve()solveH(int r, int c, 1);}
    public boolean solveH(int r, int c, int num){
	if (num>board.length*board[0].length){return true;}
	for (int r=0;r<board.length;r++){
	    for (int c=0;c<board[0].length;c++){
		if (board[r][c]==0){
		    addKnight(r,c,num);

		    if (solveH(r+2,c+1,num+1)){
			solveH(r+2,c+1,num+1);
			return true;
		    }
		    if (solveH(r+1,c+2,num+1)){
			solveH(r+1,c+2,num+1);
			return true;
		    }
		    if (solveH(r-2,c-1,num+1)){
			solveH(r-2,c-1,num+1);
			return true;
		    }
		    if (solveH(r-1,c-2,num+1)){
			solveH(r-1,c-2,num+1);
			return true;
		    }
		    if (solveH(r-1,c+2,num+1)){
			solveH(r-1,c+2,num+1);
			return true;
		    }
		    if (solveH(r+2,c-1,num+1)){
			solveH(r+2,c-1,num+1);
			return true;
		    }
		    if (solveH(r+1,c-2,num+1)){
			solveH(r+1,c-2,num+1);
			return true;
		    }
		    if (solveH(r-2,c+1,num+1)){
			solveH(r-2,c+1,num+1);
			return true;
		    }

			else{removeKnight(r,c);}
		}
	    }
	}
    }
}
