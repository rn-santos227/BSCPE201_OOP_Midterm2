import java.util.ArrayList;
import java.util.Scanner;
import java.util.Base64;
  
import java.io.IOException;
import java.io.FileWriter;
public class Encrypt
{
    public static void main(String[] args) throws IOException
    {
    	ArrayList<String> word = new ArrayList<String>();
    	Scanner sc = new Scanner(System.in);
    	Boolean isDone = false;
    	
    	while(!isDone)
    	{
    		String wordIN = sc.next();
    		if(!wordIN.equals(":q"))
    		{
    			byte[] encodedBytes = Base64.getEncoder().encode((wordIN + "\n").getBytes());
    			word.add(new String(encodedBytes));
    		}
    		else
    		{
    			isDone = true;
    		}
    	}
    	
    	FileWriter fw = new FileWriter("database.txt"); 
    	for(String a: word)
    	{
    		fw.write(a);    
    	}
    	
      	fw.close();   
       	sc.close();
    }
}
