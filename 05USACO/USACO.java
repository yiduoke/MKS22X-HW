public class USACO {
    private makelake bronze;
	private Silver silver;
	public USACO(){}
	
	public int bronze(String filename){
		bronze = new makelake(filename);
		return bronze.stomp();
	}
	
	public int silver(String filename){
		silver = new Silver(filename);
		return silver.solve();
	}
	
	public static void main(String[] args){
		USACO x = new USACO(); //does not have to do anything. 

		System.out.println (x.bronze("lake1.txt"));

		System.out.println (x.silver("silver.txt"));

	}
}