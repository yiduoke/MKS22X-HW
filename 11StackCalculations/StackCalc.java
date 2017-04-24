import java.util.Stack;
public class StackCalc {

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
	
	public static void main(String[] args)
{
    System.out.println(eval("10 2 +"));//12.0
    System.out.println(eval("10 2 -"));//8.0
    System.out.println(eval("10 2.0 +"));//12.0
    System.out.println(eval("11 3 - 4 + 2.5 *"));//30.0
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));//839.0
    System.out.println(eval("10 2 + 10 * 1 + 1 1 1 + + + 10 10 + -"));//104.0
}
}
