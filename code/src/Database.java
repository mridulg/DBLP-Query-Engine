/**
 * Stores the Content from the Parsed XML files to Arraylist<Data>
 * @author Mridul Gupta | Divyanshu Talwar
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Database {
	public static ArrayList<Data> allData = new ArrayList<Data>(); /**< ArrayList of Data. */ 
	public static ArrayList<Author> authors = new ArrayList<Author>(); /**< ArrayList of Authors. */
	public static int resultCount = 0; /**< Stores number of results for a particular query. */
	public static boolean yah = true;
	public static HashMap<String, Integer> map = new HashMap<>();	
}
