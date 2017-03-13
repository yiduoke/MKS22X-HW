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
}