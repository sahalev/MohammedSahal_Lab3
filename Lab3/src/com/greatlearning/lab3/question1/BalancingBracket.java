package com.greatlearning.lab3.question1;

import java.util.Stack;

public class BalancingBracket {
	
	
	static boolean checkBracketBalancing(String bracketExpression)
	{
		Stack<Character> stack = new Stack();
		
		for (int i=0;i<bracketExpression.length();i++)
		{
			char x = bracketExpression.charAt(i);
			
			if(x=='(' || x=='['  || x=='{' )
			{
				stack.push(x);
				continue;
			}
			
			if(stack.isEmpty())
				return false;
			
			char check;
			
			switch(x)
			{
			case ')' :
				check=stack.pop();
				if(check=='{' || check=='[')
					return false;
				break;
				
			case '}' :
				check=stack.pop();
				if(check=='(' || check=='[')
					return false;
				break;
				
			case ']' :
				check=stack.pop();
				if(check=='(' || check=='{')
					return false;
				break;
			
			}	
			
		}
		
		return stack.isEmpty();
		
		
	}
	

	public static void main(String[] args) {
		
		String bracketExpression = "([{}])";
		
		boolean result;
		
		result = checkBracketBalancing (bracketExpression);
		
		if(result)
			System.out.println("The entered string has balanced barckets");
		else
			System.out.println("The entered string do not contain balanced brackets");

	}

}
