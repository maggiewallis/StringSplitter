import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringSplitterTest
{
	private StringSplitter spaceSplitter;
	private StringSplitter commaSplitter;
	@Before
	public void setup()
	{
		spaceSplitter = new StringSplitter(" ");
		commaSplitter = new StringSplitter(",");
	}
	
	
	@Test
	public void testFindFirstLocationOfDelimiterInString()
	{
		assertEquals(2,spaceSplitter.findFirstLocationOfDelimiterInString("To be or not to be."));
		assertEquals(4,spaceSplitter.findFirstLocationOfDelimiterInString("That is the question."));
		assertEquals(-1,spaceSplitter.findFirstLocationOfDelimiterInString("Horatio"));
		assertEquals(7,commaSplitter.findFirstLocationOfDelimiterInString("Parsley, sage, rosemary and thyme")); 
	}

	@Test
	public void testGetPortionOfStringBefore()
	{
		assertEquals("If at first",    spaceSplitter.getPortionOfStringBefore("If at first you don't succeed", 11));
		assertEquals("",               spaceSplitter.getPortionOfStringBefore("Then", 0));
		assertEquals("try, try again.",commaSplitter.getPortionOfStringBefore("try, try again.", 100));
	}

	@Test
	public void testGetRemainderOfString()
	{
		assertEquals("again.",         spaceSplitter.getRemainderOfString("Never say Never again.", 16));
		assertEquals("raker",          spaceSplitter.getRemainderOfString("Moonraker", 4));
		assertEquals("Skyfall",        commaSplitter.getRemainderOfString("Skyfall", 0));
		assertEquals("",               commaSplitter.getRemainderOfString("Spectre", 7));
	}

	@Test
	public void testBreakStringIntoLines()
	{
		assertEquals("Green\nEggs\nand\nHam", 					spaceSplitter.breakStringIntoLines("Green Eggs and Ham"));
		assertEquals("One Fish\nTwo Fish\nRed Fish\nBlue Fish",	commaSplitter.breakStringIntoLines("One Fish,Two Fish,Red Fish,Blue Fish"));
		assertEquals("TheLorax",				    					spaceSplitter.breakStringIntoLines("TheLorax   "));
		assertEquals("Seuss\nGeisel",							commaSplitter.breakStringIntoLines(",Seuss,Geisel"));		
	}

}
