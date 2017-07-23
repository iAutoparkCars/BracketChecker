package a_Fibonacci;

public class Fibonacci
{
	public static void main(String[] args)
	{
		System.out.println(fib(6));
		
	}

	public static int fib(int n)
	{
		//stores all the results in this container
		int[] a = new int[n];
		
		
		//the result to return
		int sum = 0;
		
		//base case
		a[0] = 1;	a[1] = 1;
		if (n==1 || n==2){return 1;}
		else
			//n greater than 2
		{
			for (int i = 2; i < a.length; i++)
			{
				sum = a[i-1] + a[i-2];
				a[i] = sum;
			}
		}
		
		return sum;
	}

}
