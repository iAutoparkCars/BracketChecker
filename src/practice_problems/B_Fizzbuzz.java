package practice_problems;

public class B_Fizzbuzz
{
	public static void main(String[] args)
	{
		System.out.println("hi");
		fizzbuzz(15);
	}

	public static void fizzbuzz(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			String result = "";
			if (i%3==0)
				result = result+"fizz";
			if (i%5==0)
				result = result+"buzz";
			System.out.println(i+" "+result);
		}
		
	}
}


