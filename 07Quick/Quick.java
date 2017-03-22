public class Quick {

    public static void quickSortDutch(int data[], int start, int end){
	if (start<end){
	    int lt=partitionDutch(data,start,end)[0];
	    int gt=partitionDutch(data,start,end)[1];
	    quickSortDutch(data,start,lt-1);
	    quickSortDutch(data,gt+1,end);
	}
    }

    public static void quickSortDutch(int data[]){quickSortDutch(data,0,data.length-1);}
	
	public static int quickselect(int[] data, int start, int end, int k){
			/*int pivotIndex=partition(data,start,end);
			if (pivotIndex==k){return data[k];}
			if (pivotIndex<k){return quickselect(data,pivotIndex+1,end,k);}
			return quickselect(data,start,pivotIndex-1,k);*/
			int lt=partitionDutch(data,start,end)[0];
			int gt=partitionDutch(data,start,end)[1];
			if (k<=gt && k>=lt){return data[k];}
			else if (gt<k){return quickselect(data,gt+1,end,k);}
			return quickselect(data,start,lt-1,k);
			
	}
    public static int quickselect(int[] data, int k){return quickselect(data,0,data.length-1,k);}
	
	public static String toString(int[] data){
		String x="";
		for (int i=0; i<data.length; i++){
			x+=data[i]+" ";
		}
		return x;
	}

	public static int[] partitionDutch(int[] data){return partitionDutch(data,0,data.length-1);}
    public static int[] partitionDutch(int[] data, int start, int end){
	int i=start;
	int lt=start;
	int gt=end;
	while (i<=gt){
	    if (data[i]==data[start]){
		i++;}
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

    public static void swap(int[] data, int x, int y){
	int temp = data[y];
	data[y] = data[x];
	data[x] = temp;
}
	  
	public static void main(String[] args){
	    int[] margaret = {10,1,-2,3,-6,4,5,6,-4,6,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		for (int i=0; i<100; i++){
			for (int j=0; j<30; j++){
				margaret[j]=(int)(Math.random()*400);
			}
			System.out.println(quickselect(margaret,5));
			//quickSortDutch(margaret);
			System.out.println(margaret[5]);
			//System.out.println(toString(margaret));
		}
	}	
}