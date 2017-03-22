public class Quick {

	//helper for quicksort
    public static void quicksort(int data[], int start, int end){
	if (start<end){
	    int lt=partition(data,start,end)[0];
	    int gt=partition(data,start,end)[1];
	    quicksort(data,start,lt-1);
	    quicksort(data,gt+1,end);
	}
    }
    
    //wrapper for quicksort
    public static void quicksort(int data[]){quicksort(data,0,data.length-1);}
	
    //helper for quickselect
	public static int quickselect(int[] data, int start, int end, int k){
			int lt=partition(data,start,end)[0];
			int gt=partition(data,start,end)[1];
			if (k<=gt && k>=lt){return data[k];}
			else if (gt<k){return quickselect(data,gt+1,end,k);}
			return quickselect(data,start,lt-1,k);
			
	}
	
	//wrapper for quickselect
    public static int quickselect(int[] data, int k){return quickselect(data,0,data.length-1,k);}
	
    //for testing
	private static String toString(int[] data){
		String x="";
		for (int i=0; i<data.length; i++){
			x+=data[i]+" ";
		}
		return x;
	}
	
	//used in quicksort and quickselect; a helper method
    public static int[] partition(int[] data, int start, int end){
	int pivotIndex=(int)(Math.random() * (end - start + 1) + start);	        int pivotTemp = data[pivotIndex];		    
	data[pivotIndex]=data[start];
	data[start]=pivotTemp;


	int i=start;
	int lt=start;
	int gt=end;
	while (i<=gt){
	    if (data[i]==data[start]){
	    	i++;
	    }
	    else if (data[i]<data[start]){
	    	swap(data, i, lt);
	    	lt++;
	    	i++;
	    }
	    else{
	    	swap(data, i, gt);
	    	gt--;
	    }
	    }
	int[] returnee={lt,gt};
	return returnee;
    }

    //a helper method for partition
    public static void swap(int[] data, int x, int y){
	int temp = data[y];
	data[y] = data[x];
	data[x] = temp;
}
    public static void main(String[] args){
	int[] margaret={0,0,0,0,0,0,0,0,0,0};
	for (int i=0; i<10; i++){
	    margaret[i]=(int)(Math.random())*90;
	}
	quicksort(margaret);
	System.out.println(toString(margaret));
    }
}
