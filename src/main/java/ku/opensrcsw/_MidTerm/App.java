package ku.opensrcsw._MidTerm;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.Scanner;
import java.io.FileReader;
import java.io.Reader;
import midterm.problem2.RegularExpression;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        JSONParser parser = new JSONParser();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the pattern you are looking for: ");
        String pattern = in.next();
        Reader reader = new FileReader("midterm.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        JSONArray poems = (JSONArray) jsonObject.get("poem");
 	   RegularExpression re = new RegularExpression();

        for (int i = 0; i < poems.size(); i++) {    	   
        	JSONObject poem = (JSONObject) poems.get(i);
        	String item = (String) poem.get("item");
        	if (re.check(item, pattern)) {
            	System.out.println("item " + i + ": " + item);
        	}
        }
        in.close();
    }
}