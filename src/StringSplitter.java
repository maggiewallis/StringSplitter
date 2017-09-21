
public class StringSplitter
{
	private String myDelimiter;

	public StringSplitter()
	{
		setDelimiter(" ");
	}
	
	public StringSplitter(String d)
	{
		setDelimiter(d);
	}

	public void setDelimiter(String delimiter)
	{
		myDelimiter = delimiter;
	}
	
	
	public int findFirstLocationOfDelimiterInString(String source)
	{
		int location = -1;
		//-----------------------
		
		location = source.indexOf(myDelimiter);
		//------------------------
		return location;
	}
	
	public String getPortionOfStringBefore(String source, int endLoc)
	{
		String result = "";
		//-----------------------
		if (endLoc > source.length())
			result = source;
		else
			result = source.substring(0, endLoc);
		
		//------------------------
		return result;
	}
	
	
	public String getRemainderOfString(String source, int startLoc)
	{
		String result = "";
		//-----------------------
		if (startLoc >= source.length())
			result = "";
		else
			result = source.substring(startLoc);
		//------------------------
		return result;
	}
	
	
	public String breakStringIntoLines(String source)
	{
		String result = "";
		String leftToSplit = source; 
		//-----------------------
		while(findFirstLocationOfDelimiterInString(leftToSplit)>-1)
		{
			int loc = findFirstLocationOfDelimiterInString(leftToSplit);
			String firstPart = getPortionOfStringBefore(leftToSplit,loc);
			leftToSplit = getRemainderOfString(leftToSplit,loc+1);
			if (firstPart.length()>0)
				result += firstPart+"\n";
		}
		result +=leftToSplit;
		//------------------------
		return result;
	}
}
