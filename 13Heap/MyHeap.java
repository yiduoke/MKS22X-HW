public class MyHeap{
    private String[] arr;
    private int[] counts;
    private boolean max;
    private int size;
    
    public MyHeap(){
	arr=new String[10];
    }

    public MyHeap(boolean x){
	if (x){
	    max=true;
	}
    }

    public void add(String x){
	if (max){
	    try{
		arr[size+1]=x;
		for (int i=size+1; i>0; i/=2){
		    if (x.compareTo(arr[i])>0){		
			arr[i]=arr[i/2];
		    }
		}
	    }
	    catch (ArrayIndexOutOfBoundsException e){
		grow();
		for (int i=size+1; i>0; i/=2){
		    arr[i]=arr[i/2];
		}
	    }
	}
	else {
	    try{
		arr[size+1]=x;
		for (int i=size+1; i>0; i/=2){
		    if (x.compareTo(arr[i])<0){
			arr[i]=arr[i/2];
		    }
		}
	    }
	    catch (ArrayIndexOutOfBoundsException e){
		grow();
		for (int i=size+1; i>0; i/=2){
		    arr[i]=arr[i/2];
		}
	    }
	}
    }

    public String remove(){
	String x=arr[1];
	for (int i=1; i<=size; i*=2){
	    
	}
    }
}

