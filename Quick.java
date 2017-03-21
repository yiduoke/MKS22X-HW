public class Quick {
	
	public static void quickSort(int data[], int start, int end) {
	    if (end > start) {
	        int pivotIndex = partition(data, start, end);
	        quickSort(data, start, pivotIndex - 1);
	        quickSort(data, pivotIndex + 1, end);
	    }
	}

    public static void quickSortDutch(int data[], int start, int end){
	if (start<end){
	    int lt=partitionDutch(data,start,end)[0];
	    int gt=partitionDutch(data,start,end)[1];
	    quickSort(data,start,lt-1);
	    quickSort(data,gt+1,end);
	}
    }

    public static void quickSortDutch(int data[]){quickSortDutch(data,0,data.length-1);}
	
	public static void quickSort(int[] data){quickSort(data,0,data.length-1);}
	
	public static int quickselect(int[] data, int start, int end, int k){
			int pivotIndex=partition(data,start,end);
			if (pivotIndex==k){return data[k];}
			if (pivotIndex<k){return quickselect(data,pivotIndex+1,end,k);}
			return quickselect(data,start,pivotIndex-1,k);
	}
    public static int quickselect(int[] data, int k){return quickselect(data,0,data.length-1,k);}
	
	public static String toString(int[] data){
		String x="";
		for (int i=0; i<data.length; i++){
			x+=data[i]+" ";
		}
		return x;
	}
	
	  private static int partition(int[] data, int start, int end) {		    
		    int pivotIndex=(int)(Math.random() * (end - start + 1) + start);		    
		    int pivotTemp = data[pivotIndex];		    
		    data[pivotIndex]=data[start];
		    data[start]=pivotTemp;
		    
		    int pivot = data[start]; // 1st element as pivot and swap it with the random because I just
		    int startFake = start + 1; //cannot
		    int endFake = end; //do it around a middle element ):

		    while (endFake > startFake) {
		      while (startFake <= endFake && data[startFake] <= pivot){startFake++;}
		      while (startFake <= endFake && data[endFake] > pivot){endFake--;}		      
		      if (endFake > startFake) {
		        int temp = data[endFake];
		        data[endFake] = data[startFake];
		        data[startFake] = temp;
		      }
		    }
		    while (endFake > start && data[endFake] >= pivot){endFake--;}
		    //switch rightmost element of the left subarray with the pivot element all the way on the left
		    if (pivot > data[endFake]) {
		      data[start] = data[endFake];
		      data[endFake] = pivot;
		      return endFake;
		    }
		    else {
		      return start;
		    }
		  }

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
				margaret[j]=(int)(Math.random()*220);
			}
			//System.out.println(quickselect(margaret,5));
			quickSortDutch(margaret);
			//System.out.println(partition(margaret,0,9));
			System.out.println(toString(margaret));
		}
	}	
}
