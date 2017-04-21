import java.util.Stack;
public class PostFix {

	public static double eval(String x){
		String[] tokens=x.split(" ");
		Stack numbers = new Stack();
		
		for (int i=0; i<tokens.length; i++){
			try {
				numbers.push(Double.parseDouble(tokens[i]));
			}
			catch (NumberFormatException e){
				String temp=tokens[i];
				if (temp.equals("+")){
					numbers.push((double)numbers.pop()+(double)numbers.pop());
					
				}
				else if (temp.equals("-")){
					numbers.push(-((double)numbers.pop()-(double)numbers.pop()));
					
				}
				else if (temp.equals("*")){
					numbers.push((double)numbers.pop()*(double)numbers.pop());
					
				}
				else if (temp.equals("/")){
					numbers.push(1/((double)numbers.pop()/(double)numbers.pop()));
					
				}
				else{
					double first=(double)numbers.pop();
					double second=(double)numbers.pop();
					numbers.push(second%first);
					
				}
			}
		}
		return (double) numbers.pop();
	}
	
	public static void main(String[] args){
		System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
	}
}
