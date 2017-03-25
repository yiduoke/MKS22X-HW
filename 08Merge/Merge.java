public class Merge{
    public static void merge(int[] a, int[] b, int[] destination){
	int i=0;
	int j=0;
	int k=0;
	while (i<a.length && j<b.length){
	    if (a[i]<b[j]){destination[k]=a[i]; i++;}
	    else{destination[k]=b[j]; j++;}
	    k++;
	}
	for (int x=i; x<a.length; x++){
		destination[k]=a[x];
		k++;
	}
	for (int y=j; y<b.length; y++){
		destination[k]=b[y];
		k++;
	}
	 
    }
    public static void mergesort(int[] ary){
    	if (ary.length>1){
    		int[] left=new int[ary.length/2];
    		int[] right=new int[ary.length-left.length];
    		for (int i=0; i<ary.length/2; i++){
    			left[i]=ary[i];
    		}
    		for (int i=left.length; i<ary.length; i++){
    			right[i-left.length]=ary[i];
    		}
    			mergesort(left);
    			mergesort(right);
    		merge(left,right,ary);
    	}
    }
    
    private static void toString(int[] data){
		String x="";
		for (int i=0; i<data.length; i++){
			x+=data[i]+" ";
		}
		System.out.println(x);
	}
    
    public static void main(String[] args){
	int[] margaret= new int[50];
	for (int i=0; i<50; i++){
		margaret[i]=(int)(Math.random()*60);
	}
	mergesort(margaret);
	toString(margaret);
    }
}