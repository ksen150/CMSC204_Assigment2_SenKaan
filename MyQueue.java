import java.util.ArrayList;

public class MyQueue<T> implements QueueInterface<T> {
	
	private ArrayList<T> queue;
	private int size;
	
	MyQueue(int size)
	{
		queue = new ArrayList<>(size);
		this.size = size;
	}
	
	MyQueue()
	{
		queue = new ArrayList<>();
		size = 10;
	}
	
	@Override 
	public boolean isEmpty() 
	{
		if(queue.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isFull()
	{
		if(queue.size() == size)
		{
			return true;
		}
		return false;
	}
	
	@Override
	public T dequeue() throws QueueUnderflowException
	{
		if(isEmpty())
		{
			throw new QueueUnderflowException();
		}
		
		T front = queue.get(0);
		queue.remove(0);
		queue.trimToSize();
		queue.ensureCapacity(size);
		
		return front;
	}
	
	@Override
	public int size()
	{
		return queue.size();
	}
	
	@Override
	public boolean enqueue(T e) throws QueueOverflowException
	{
		if(queue.size() == size)
		{
			throw new QueueOverflowException();
		}
		
		queue.add(e);
		return true;
	}
	
	@Override 
	public String toString()
	{
		String x = "";
		for(T e: queue)
		{
			x = x + e.toString();
		}
		return x;
	}
	
	@Override
	public String toString(String delimiter)
	{
		String x = "";
		for(T e: queue)
		{
			x = x + e.toString();
			x = x + delimiter;
		}
		x = x.substring(0, x.length()-1);
		return x;
	}
	
	@Override
	public void fill(ArrayList<T> list)
	{
		for(T e: list)
		{
			queue.add(e);
		}
		if(queue.size() == size)
		{
			throw new QueueOverflowException();
		}
	}
}
