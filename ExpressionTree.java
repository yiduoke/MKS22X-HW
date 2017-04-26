
public class ExpressionTree {

	private double getValue(){}
	
	private char getOp(){}
	
	private ExpressionTree getLeft(){}
	
	private ExpressionTree getRight(){}
	
	private boolean isOp(){}
	
	private boolean isValue(){}
	
	public String toString(){
		if (isOp()){
			return "("+getLeft().toString()+getOp()+getRight().toString()+")";
		}
		else{
			return ""+getValue();
		}
	}
	
	public String toStringPostFix(){
		if (isOp()){
			return "("+getLeft().toString()+" "+getRight().toString()+getOp()+")";
		}
		else{
			return ""+getValue();
		}
	}
	
	public String toStringPrefix(){
		if (isOp()){
			return "("+getOp()+getLeft().toString()+" "+getRight().toString()+")";
		}
		else{
			return ""+getValue();
		}
	}
	
	public double evaluate(){
		if (isOp()){
			if (getOp()=='+'){
				return getLeft().evaluate()+getRight().evaluate();
			}
			else if (getOp()=='-'){
				return getLeft().evaluate()-getRight().evaluate();
			}
			else if(getOp()=='*'){
				return getLeft().evaluate()*getRight().evaluate();
			}
			else{
				return getLeft().evaluate()/getRight().evaluate();
			}
		}
		else{
			return getValue();
		}
	}
}
