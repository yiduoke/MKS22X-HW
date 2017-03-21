
public class Recursion {
	public static String name(){return "Ke,Yiduo";};
	 public static double sqrt(double n){
		 return sqrtHalp(n,1);
	 }; 
	 public static double sqrtHalp(double n, double guess){
		if(n < 0){
			    throw new IllegalArgumentException();}
		if (n==0){return 0;}
		 if (Math.abs(n-guess*guess)/n<0.000000001){return guess;}
		 return sqrtHalp(n,(n/guess+guess)/2);
	 }
}
