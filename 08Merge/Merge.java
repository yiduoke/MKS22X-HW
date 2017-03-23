public class Merge{
    public void merge(int[] a, int[] b, int[] destination){
	
    }
    public void mergesort(int[] ary){
	int[] left=new int[ary.length/2];
	int[] right=new int[ary.length-left.length];
	for (int i=0; i<ary.length/2; i++){
	    left[i]=ary[i];
	}
	for (int i=ary.length/2; i<ary.length; i++){
	    right[i-ary.length/2]=ary[i];
	}
    }
}
