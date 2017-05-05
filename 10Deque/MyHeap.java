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
			swap(i,i/2);
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
			swap(i,i/2);
		    }
		}
	    }
	    catch (ArrayIndexOutOfBoundsException e){
		grow();
		for (int i=size+1; i>0; i/=2){
		    swap(i,i/2);
		}
	    }
	}
    }

    public String remove(){
	String x=arr[1];
	int i=1;
	if (max){
	    while (arr[i].compareTo(arr[2*i])<0 || arr[i].compareTo(arr[2*i+1])<0){
		if (arr[i].compareTo(arr[2*i])<0)){
		swap(i,2*i);
	    }
	    else{
		swap(i,2*i+1);
	    }
	}
	}
    }   


    public void swap(int x, int y){
	String a=arr[x];
	arr[x]=arr[y];
	arr[y]=a;
    }

    private void grow(){
	String[] temp=new String[arr.length*2];
	for (int i=0; i<size; i++){
	    temp[i]=arr[i];
	}
	arr=temp;
    }
}

