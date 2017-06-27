import java.util.Stack;

//Practice to implement a Queue using two stacks

public class MyQueue<T>
{
	private Stack<T> s1 = new Stack<T>();
	private Stack<T> s2 = new Stack<T>();
	
	
	public MyQueue(){}
	
	public void enqueue(T data)
	{
		s1.push(data);
	}
	
	public void dequeue()
	{
		if (s1.isEmpty() && s2.isEmpty())
			System.out.println("Queue is empty");
		else 
		{
			while(!s1.isEmpty())
			{
				T toPush = s1.pop();
				s2.push(toPush);
			}
			System.out.println(s2.pop());
		}
	}
	
}
