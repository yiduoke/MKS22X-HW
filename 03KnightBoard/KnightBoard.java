public class KnightBoard{
    private int[][]board;
    int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
    
    public KnightBoard(int startingRows, int startingCols){
	board=new int[startingRows][startingCols];
}

    public String toString(){
    	int a=board.length;
    	int b=board[0].length;
    	try{if (board[0][1]==0){board=new int[a][b];}}
    	catch(ArrayIndexOutOfBoundsException e){}
    	String x="";
    	for (int r=0;r<board.length;r++){
    		for (int c=0;c<board[0].length;c++){ 
    			if (board[r][c]<10){x+=" "+board[r][c]+" ";}
    			else{x+=board[r][c]+" ";}
    		}
    		x+="\n";
    	}
    	return x;
    }

    public void addKnight(int r, int c, int num){
	board[r][c]=num;
    }
    public void removeKnight(int r, int c){
	board[r][c]=0;
    }

    public void solve(){
    	addKnight(0,0,1);
    	solveH (0,0,2);
    }
    
    public boolean solveH(int r, int c, int num){
	if (num>board.length*board[0].length){return true;}
	for (int i=0; i<8; i++){
		int nextX=r+xMove[i];
		int nextY=c+yMove[i];
		if (canPut(nextX,nextY)){
			addKnight(nextX,nextY,num);
			if (solveH(nextX,nextY,num+1)){
				return true;
			}
			else{removeKnight(nextX,nextY);}
		}
	}
	return false;
    }

    private boolean canPut(int r, int c){
        if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 0){
        	return true;}
        return false;
    }
    
    public static void main(String[] args){
	int r=Integer.parseInt(args[0]);
	int c=Integer.parseInt(args[1]);
    	KnightBoard marg=new KnightBoard(r,c);	
    	marg.solve();
    	System.out.println(marg);
    }
}
