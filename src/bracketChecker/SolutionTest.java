package bracketChecker;
import java.awt.List;
import java.util.ArrayList;

public class SolutionTest
{
	public ArrayList<String> test = new ArrayList<String>();
	public String testString = "";
	
	public SolutionTest()
	{
		StringBuilder str = new StringBuilder();
		str.append("6" + '\n');
		str.append("}][}}(}][))]" + '\n');
		str.append("[](){()}" + '\n');
		str.append("()" + '\n');
		str.append("({}([][]))[]()" + '\n');
		str.append("{)[](}]}]}))}(())(" + '\n');
		str.append("([[)");
		
		
		testString = str.toString();
	}
}
