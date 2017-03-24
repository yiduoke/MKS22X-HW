public class Merge{
    public static void merge(int[] a, int[] b, int[] destination){
	int i=0;
	int j=0;
	int k=0;
	while (i<a.length && j<b.length){
	    if (a[i]<=b[j]){destination[k]=a[i]; k++; i++;}
	    else{destination[k]=b[j]; k++; j++;}
	}
    }
    public static void mergesort(int[] ary){
	if (ary.length>0){
	int[] left=new int[ary.length/2];
	int[] right=new int[ary.length-left.length];
	for (int i=0; i<ary.length/2; i++){
	    left[i]=ary[i];
	}
	for (int i=ary.length/2; i<ary.length; i++){
	    right[i-ary.length/2]=ary[i];
	}
	if (left.length>0){
	mergesort(left);
	}
	if (right.length>0){
	mergesort(right);
	}
	merge(left,right,ary);
    }
    }
    public static void main(String[] args){
	int[] margaret={2,3,0,91,9,-2,5,8};
	mergesort(margaret);
    }
}
