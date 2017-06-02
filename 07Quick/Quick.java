public class Quick {
    
    //wrapper for quicksort
    public static void quicksort(int data[]){quicksort(data,0,data.length-1);}
	
    //helper for quickselect
	public static int quickselect(int[] data, int start, int end, int k){
		if (k<=end && k>=start){return data[k];}
		else{
		    int pivotIndex=(int)(Math.random() * (end - start + 1) + start);	
		    int pivot=data[pivotIndex];
		    swap(data,pivotIndex,start);
		
		    int lt=start+1;
		    int gt=end;
		    int i=start+1;
		    while (i<=gt){
		    	if (data[i]==pivot){
		    		i++;
	    	}
		    	else if (data[i]<pivot){
		    		swap(data, i, lt);
		    		lt++;
		    		i++;
		    	}
		    	else{
		    		swap(data, i, gt);
		    		gt--;
		    	}
		    }
			pivotIndex=lt-1;
			swap(data,start,pivotIndex);
			if (k>gt){
				return quickselect(data,k,gt,end);
			}
			else{
				return quickselect(data,k,start,lt);
			}
		}
		
	}
	
	//wrapper for quickselect
    public static int quickselect(int[] data, int k){return quickselect(data,0,data.length-1,k);}
	
    public static void quicksort(int[] data, int start, int end){
	    if (end-start<2){
	    	return;
	    }
	    
	    int pivotIndex=(int)(Math.random() * (end - start + 1) + start);	
	    int pivot=data[pivotIndex];
		swap(data,pivotIndex,start);
		
	    int lt=start+1;
	    int gt=end;
	    int i=start+1;
	    while (i<=gt){
	    	if (data[i]==pivot){
	    		i++;
	    	}
	    	else if (data[i]<pivot){
	    		swap(data, i, lt);
	    		lt++;
	    		i++;
	    	}
	    	else{
	    		swap(data, i, gt);
	    		gt--;
	    	}
	    }
	    
	    swap(data,start,lt-1);
	    quicksort(data,start,lt-1);
	    quicksort(data, i-1,end);
    }

    //a helper method for partition
    public static void swap(int[] data, int x, int y){
    	int temp = data[y];
    	data[y] = data[x];
    	data[x] = temp;
    }
    
    //for testing
	private static String toString(int[] data){
		String x="";
		for (int i=0; i<data.length; i++){
			x+=data[i]+" ";
		}
		return x;
	}
}