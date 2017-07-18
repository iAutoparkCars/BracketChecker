package zen_challenge;

import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {
	public static void main(String[] args)
	{
		System.out.println("Input is: \n" + buildTest());
		Scanner cin = new Scanner(buildTest());
		
		//ArrayList<Integer> list = new ArrayList<Integer>();
		int N = cin.nextInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++)
		{
			arr[i] = cin.nextInt();
		}
		
		int window = cin.nextInt();
		
		System.out.println("Output is: ");
		compute(arr, window);
		
		/*for (int i = 0; i < arr.length; i++)
		{
			System.out.println( arr[i] + " " );
		}*/
		
	}

	public static String buildTest()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(" 3 \n")
			.append(" 49 \n 42 \n 9 \n")
			.append(" 2 ");
			
		return sb.toString();
	}
	
	public static void compute(int[] list, int w)
	{
		System.out.println(list[0]);
		for (int i = 0; i < list.length-1; i++)
		{
			Integer sum = 0;
			for (int j = 0; j < w; j++)
			{
				if (i+j < list.length)
					sum = sum + list[i+j];
			}
			if (!sum.equals(0))
			{
				System.out.println(sum);
			}
		}
	}

	
}


