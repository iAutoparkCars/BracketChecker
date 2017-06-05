package myHeap;


public class Pair<T1, T2> 
{
	Integer a;
	Integer b;
	
	public Pair(Integer a, Integer b) 
	{
		this.a =  a;
		this.b =  b;
	}

	public Integer getKey() {
		return a;
	}
	
	public Integer getValue() {
		return b;
	}

}
