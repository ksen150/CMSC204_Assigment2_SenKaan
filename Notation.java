
public class Notation extends java.lang.Object {
	
	/* 
	 * Convert an infix expression into a postfix expression
	 * @param infix - the infix expression in string format
	 * @returns the postfix expression in string format
	 * @throws InvalidNotationFormatException - if the infix expression format is invalid
	 */
	public static java.lang.String convertInfixToPostfix(java.lang.String infix) throws InvalidNotationFormatException {
		
		MyQueue<Character> queue = new MyQueue<>(infix.length());
		MyStack<Character> stack = new MyStack<>(infix.length());
		
		char[] string = infix.toCharArray();
		
		try {
		for(char i: string)
		{
			if(i == ' ')
			{
				continue;
			}
			
			if(Character.isDigit(i))
			{
				queue.enqueue(i);
				continue;
			}
			
			if(i == '(')
			{
				stack.push(i);
			}
			
			if(i == '+' || i == '-' || i == '*' || i == '/')
			{
				if(!queue.isEmpty())
				{
					char top = stack.top();
					if(i == '+' && top == '-' || i == '+' && top == '+' || top == '*' || top == '/' || i == '-' && top == '-' || i == '-' && top == '+')
					{
						queue.enqueue(stack.pop());
					}
				}
				stack.push(i);
				continue;
			}
			
			if(i == ')')
			{
				while(stack.top() != '(')
				{
					queue.enqueue(stack.pop());
						
					if(stack.top() == null)
					{
						throw new InvalidNotationFormatException();
					}
				}
				stack.pop();
			}
		}
	}
	catch(QueueOverflowException | StackOverflowException | StackUnderflowException ignore)
	{
		throw new InvalidNotationFormatException();
	}
		return queue.toString();
	}
	
	/*
	 * Converts the Postfix ex pression to the Infix expression
	 * @param postfix - the postfix expression in string format
	 * @return the infix expression in string format
	 * @throws InvalidNotationFormatException - if the postfix expression format is invalid
	 */
	public static java.lang.String convertPostfixToInfix(java.lang.String postfix) throws InvalidNotationFormatException
	{
		MyStack<String> stack = new MyStack<>(postfix.length());
		
		try 
		{
			for(int i=0; i<postfix.length(); i++)
			{
				char position = postfix.charAt(i);
				if(position == ' ')
				{
					continue;
				}
				
				if(Character.isDigit(position))
				{
					stack.push(Character.toString(position));
					continue;
				}
				
				if(position == '+' || position == '-' || position == '*' || position == '/')
				{
					if(stack.size() < 2)
					{
						throw new InvalidNotationFormatException();
					}
					
					String first = stack.pop();
					String second = stack.pop();
					String encapsulate = "(" + second + position + first + ")";
					stack.push(encapsulate);
				}
			}
		}
		catch (StackUnderflowException | StackOverflowException ignore)
		{
			throw new InvalidNotationFormatException();
		}
		
		if(stack.size() > 1 )
		{
			throw new InvalidNotationFormatException();
		}
		return stack.toString();
	}
	
	/*
	 * Evaluate a postfix expression from a string to a double
	 * @param postfixExpr - the postfix expression in String format
	 * @return the evaluation of the postfix expression as a double
	 * @throws InvalidNotationFormatException - if the postfix expression format is invalid
	 */
	public static double evaluatePostfixExpression(java.lang.String postfixExpr) throws InvalidNotationFormatException
	{
		MyStack<Double> stack = new MyStack<>(postfixExpr.length());
		char[] string = postfixExpr.toCharArray();
		
		try 
		{
			for(char i: string)
			{
				if(i == ' ')
				{
					continue;
				}
				
				if(Character.isDigit(i) || i == '(')
				{
					stack.push(Double.parseDouble(Character.toString(i)));
					continue;
				}
				
				if(i == '+' || i == '-' || i == '*' || i == '/')
				{
					if(stack.size() < 2)
					{
						throw new InvalidNotationFormatException();
					}
					double right2 = stack.pop();
					double left1 = stack.pop();
					
					switch(i) {
					
					case '*':
						stack.push(left1 * right2);
						break;
					
					case '/':
						stack.push(left1 / right2);
						break;
	
					case '+':
						stack.push(left1 + right2);
						break;
					
					case '-':
						stack.push(left1 - right2);
					}
				}
			}
		}
		catch (StackOverflowException | StackUnderflowException ignore)
		{
			throw new InvalidNotationFormatException();
		}
		
		if(stack.size() > 1)
		{
			throw new InvalidNotationFormatException();
		}
		
		return Double.parseDouble(stack.toString());
	}	
}
