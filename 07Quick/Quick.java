public class Quick {
	
	public static void quickSort(int data[], int start, int end) {
	    if (end > start) {
	        int pivotIndex = partition(data, start, end);
	        quickSort(data, start, pivotIndex - 1);
	        quickSort(data, pivotIndex + 1, end);
	    }
	}
	
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
	  
	public static void main(String[] args){
		int[] margaret = {10,1,-2,3,-6,4,5,6,-4,6};
		for (int i=0; i<100; i++){
			for (int j=0; j<10; j++){
				margaret[j]=(int)(Math.random()*20);
			}
			System.out.println(quickselect(margaret,5));
			quickSort(margaret);
			//System.out.println(partition(margaret,0,9));
			System.out.println(margaret[5]);
		}
	}	
}
