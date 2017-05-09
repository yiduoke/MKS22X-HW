public class RunningMedian{

    private MyHeap min;
    private MyHeap max;

    public RunningMedian(){
	min=new MyHeap(false);
	max=new MyHeap(true);
    }

    public void add(int x){
	if (x<getMedian()){
	    max.add(x);
	}
	else{
	    min.add(x);
	}

	if (Math.abs(min.size()-max.size())>1){
	    if (min.size()>max.size()){
		max.add(min.remove());
	    }
	    else{
		min.add(max.remove());
	    }
 	}
    }

    public double getMedian(){
	if (min.size()==0 && max.size()==0){
	    return 0;
	}
	else if (min.size()==0){
	    return max.peek();
	}
	else if (max.size()==0){
	    return min.peek();
	}
	else{
	    if ((min.size()+max.size())%2==1){
		if (min.size()>max.size()){
		    return min.peek();
		}
		else{
		    return max.peek();
		}
	    }
	    else{
		return (min.peek()+max.peek())/2.0;
	    }
	}
    }

	public static void main(String[] args){
	    RunningMedian margaret=new RunningMedian();
	    margaret.add(5);
	    margaret.add(2);
	    margaret.add(3);
	    margaret.add(1);
	    System.out.println(margaret.min);
	    System.out.println(margaret.max);
	}

    }
