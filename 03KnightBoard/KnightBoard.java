public class KnightBoard{
    private int[][]board;
    public KnightBoard(int startingRows, int startingCols){
	board=new int[startingRows][startingCols];
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

    public void addKnight(int r, int c, int num){
	board[r][c]=num;
    }
    public void removeKnight(int r, int c){
	board[r][c]=0;
    }

    public void solve(){solveH (0,0,1);}
    public boolean solveH(int x, int y, int num){
	if (num>board.length*board[0].length){return true;}
	for (int r=0;r<board.length;r++){
	    for (int c=0;c<board[0].length;c++){
		if (board[r][c]==0){
		    addKnight(r,c,num);

		    try{
			if (solveH(r+2,c+1,num+1)){
			solveH(r+2,c+1,num+1);
			return true;
			}
	else{removeKnight(r,c);}
		    }
			catch (ArrayIndexOutOfBoundsException e){}
		    try{
		    if (solveH(r+1,c+2,num+1)){
			solveH(r+1,c+2,num+1);
			return true;
		    }
	else{removeKnight(r,c);}
		    }
			catch (ArrayIndexOutOfBoundsException e){}
		    try{
		    if (solveH(r-2,c-1,num+1)){
			solveH(r-2,c-1,num+1);
			return true;
		    }
	else{removeKnight(r,c);}
		    }
			catch (ArrayIndexOutOfBoundsException e){}
		    try{
		    if (solveH(r-1,c-2,num+1)){
			solveH(r-1,c-2,num+1);
			return true;
		    }
	else{removeKnight(r,c);}
		    }
			catch (ArrayIndexOutOfBoundsException e){}
		    try{
		    if (solveH(r-1,c+2,num+1)){
			solveH(r-1,c+2,num+1);
			return true;
		    }
	else{removeKnight(r,c);}
		    }
			catch (ArrayIndexOutOfBoundsException e){}
		    try{
		    if (solveH(r+2,c-1,num+1)){
			solveH(r+2,c-1,num+1);
			return true;
		    }
	else{removeKnight(r,c);}
		    }
			catch (ArrayIndexOutOfBoundsException e){}
		    try{
		    if (solveH(r+1,c-2,num+1)){
			solveH(r+1,c-2,num+1);
			return true;
		    }
	else{removeKnight(r,c);}
		    }
			catch (ArrayIndexOutOfBoundsException e){}
		    try{
		    if (solveH(r-2,c+1,num+1)){
			solveH(r-2,c+1,num+1);
			return true;
		    }
	else{removeKnight(r,c);}
		    }
			catch (ArrayIndexOutOfBoundsException e){}
		}
	    }
	}
	return false;
    }

    
    public static void main(String[] args){
    	KnightBoard marg=new KnightBoard(7,7);	
	marg.solve();
    	System.out.println(marg);
    }
}
