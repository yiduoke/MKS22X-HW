
public class KnightBoard {
    private int[][]board;
    private int[][]numMoves;
    private int[] xMove = {-2,-1, 1, -1, 2, 1, 2, -2};
    private int[] yMove = { 1, 2, 2, -2,-1,-2, 1, -1};
    
    public KnightBoard(int startingRows, int startingCols){
	board=new int[startingRows][startingCols];
	numMoves=new int[startingRows][startingCols];
	for (int r=0;r<startingRows;r++){
		for (int c=0;c<startingCols;c++){
			initializeMoves(r,c);
		}
	}
}

    private void initializeMoves(int r, int c){
    	for (int i=0; i<8; i++){
    		int nextX=r+xMove[i];
    		int nextY=c+yMove[i];
    		if (canPut(nextX,nextY)){
    			numMoves[r][c]++;
    		}
    	}
    }
    public String toString(){
    	String x="";
    	for (int r=0;r<board.length;r++){
    		for (int c=0;c<board[0].length;c++){ 
    			if (board[r][c]<10){x+="   "+board[r][c]+" ";}
    			else if (board[r][c]<100){x+="  "+board[r][c]+" ";}
    			else if (board[r][c]<1000){x+=" "+board[r][c]+" ";}
    			else{x+=board[r][c]+" ";}
    		}
    		x+="\n";
    	}
    	return x;
    }
    
    private void addKnight(int r, int c, int num){board[r][c]=num;}
    
    private void removeKnight(int r, int c){board[r][c]=0;}
    
    public void solveFast(){
    	if (board.length<5 || board[0].length<5){
    		solveH(0,0,1);
    	}
    	else{solveFastH (0,0,1);}
    }
    
    public void solve(){
    	solveH (0,0,1);
    }
    
    private boolean solveFastH(int r, int c, int num){
    	if (num==board.length*board[0].length){
    		addKnight(r,c,num);
    		subtractSurroundings(r,c);
    		return true;
    		}
    	int b=0;//number of spots the knight could move to; also the length of the array to be used later (will be updated)
    	
    	//for determining the length of the array
    	for (int i=0; i<8; i++){
    		int nextX=r+xMove[i];
    		int nextY=c+yMove[i];
    		if (canPut(nextX,nextY)){
    			b++;
    		}
    	}
    	
    	//creating and ordering the array in increasing order based on number of possible moves 
    	int a = 0;//index of orderedMoves elements
    	int[] orderedMoves = new int[b];
    	for (int i=0; i<8; i++){
    		int nextX = r + xMove[i];
    		int nextY = c + yMove[i];
    		if (canPut(nextX,nextY)){
    			orderedMoves[a] = numMoves[nextX][nextY]*10+i;
    			a++;//if I can put the knight on a given spot, i increase a so the next spot has the next index
    		}
    	}   	
    	java.util.Arrays.sort(orderedMoves);
    	
    	for (int i = 0; i < b; i++){
    		int nextX = r + xMove[orderedMoves[i]%10];
    		int nextY = c + yMove[orderedMoves[i]%10];
    			addKnight(r, c, num);
    			subtractSurroundings(r, c);
    			if (solveFastH(nextX, nextY, num + 1)){
    				return true;
    			}
    			else{
    				removeKnight(r, c);
    				}
    	}
    	
    	return false;
    }
    
    public boolean solveH(int r, int c, int num){
	if (num>board.length*board[0].length){return true;}
	for (int i=0; i<8; i++){
		int nextX=r+xMove[i];
		int nextY=c+yMove[i];
		if (canPut(r,c)){
			addKnight(r,c,num);
			if (solveH(nextX,nextY,num+1)){
				return true;
			}
			else{removeKnight(r,c);}
		}
	}
	return false;
    }
    
    private void subtractSurroundings(int r, int c){
    	for (int i=0; i<8; i++){
    		int nextX=r+xMove[i];
    		int nextY=c+yMove[i];
    		if (exist(nextX,nextY)){
    			numMoves[nextX][nextY]--;
    		}
    	}
    }

    private boolean canPut(int r, int c){
        if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 0){
        	return true;}
        return false;
    }

    private boolean exist(int r, int c){
        if (r >= 0 && r < board.length && c >= 0 && c < board[0].length){
        	return true;}
        return false;
    }
    public static void main(String[] args){
	int r=Integer.parseInt(args[0]);
	int c=Integer.parseInt(args[1]);
    	KnightBoard marg=new KnightBoard(r,c);	
    	marg.solveFast();
    	System.out.println(marg);
    }
    
}