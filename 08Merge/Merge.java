public class Merge{
    public void merge(int[] a, int[] b, int[] destination){
	int i=0;
	int j=0;
	int k=0;
	while (i<a.length && j<b.length){
	    if (left[i]<=b[j]){destination[k]=left[i]; k++;}
	}
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
	mergesort(left);
	mergesort(right);
	merge(left,right,ary);
    }
    public static void main(String[] args){
	System.out.println(5/2);
    }
}
