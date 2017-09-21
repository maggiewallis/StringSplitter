import java.util.Scanner;

public class StringSplitterRunner
{

	public static void main(String[] args)
	{
		StringSplitter theSplitter = new StringSplitter(" ");
		Scanner keyboardInput = new Scanner(System.in);
		System.out.print("Enter a string to split by spaces: ");
		String sentence = keyboardInput.nextLine();
		System.out.println("Splitting string.");
		System.out.println(theSplitter.breakStringIntoLines(sentence));
		
	}

}
