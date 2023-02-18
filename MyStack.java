import java.util.ArrayList;

public class MyStack<T> implements StackInterface<T> {
	
	private ArrayList<T> stack;
	private int size;
	
	
	MyStack(int size)
	{
		stack = new ArrayList<>(size);
		this.size = size;
	}
	
	MyStack()
	{
		stack = new ArrayList<>();
		size = 10;
	}
	
	@Override 
	public boolean isEmpty()
	{
		if(stack.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isFull()
	{
		if(stack.size() == size)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public T pop() throws StackUnderflowException
	{
		if(stack.size() == 0)
		{
			throw new StackUnderflowException();
		}
		
		T stackTop = stack.get(stack.size() -1);
		stack.remove(stack.size() - 1);
		
		return stackTop;
	}
	
	@Override
	public T top() throws StackUnderflowException
	{
		if(stack.size() == 0)
		{
			throw new StackUnderflowException();
		}
		
		return stack.get(stack.size() -1);
	}
	
	@Override
	public int size()
	{
		return stack.size();
	}
	
	@Override
	public boolean push(T e) throws StackOverflowException
	{
		if(stack.size() == size)
		{
			throw new StackOverflowException();
		}
		stack.add(e);
		
		return true;
	}
	
	@Override
	public String toString()
	{
		String x = "";
		
		for(T e: stack)
		{
			x = x + e.toString();
		}
		return x;
	} 
	
	@Override
	public String toString(String delimiter)
	{
		String x = "";
		
		for(T e: stack)
		{
			x = x + e.toString();
			x = x + delimiter;
		}
		
		x = x.substring(0, x.length() -1);
		return x;
	}
	
	@Override 
	public void fill(ArrayList<T> list) 
	{

		for(T e: list)
		{
			stack.add(e);
		}
		if(stack.size() == size)
		{
			throw new StackOverflowException();
		}
	}
}
