import java.io.*;
public class MyException 
{
	static void accessFiles() throws FileNotFoundException
	{
		try 
		{
			FileReader f = new FileReader("D:\\Exceptions.doc");
			System.out.println("File found");
		}
		catch(FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			throw e; // Rethrows the exception
		}
	}
	public static void main(String[ ] args)
	{
		if()
		{
			try 
			{
			accessFiles();
				if()
				{
					rgtregreg;
				}
				else if()
				{
					sdffsfsdf;
				}
			}
			catch(FileNotFoundException e) 
			{
				System.out.println("File cannot be found!");
			}
		}
		else{
			SafeVarargs;
		}	
	}
}
