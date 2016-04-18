import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class DateTime {
	private Map<String, String> map;

	public DateTime(){
		map = new HashMap<String, String>();
		map.put("MM/dd/yyyy", "yyyy-MM-dd"); //  3/20/2016
		map.put("hh/mm/ss a", "'T'HH:mm:ss"); // 4:05:07 PM
		map.put("EEEE, MMMM dd, yyyy", "yyyy-MM-dd"); // Sunday, March 20, 2016 
		map.put("EEEE, MMMM dd, yyyy hh:mm a", "yyyy-MM-dd'T'HH:mm'Z'"); // Sunday, March 20, 2016 4:05 PM
		map.put("EEEE, MMMM dd, yyyy hh:mm:ss a", "yyyy-MM-dd'T'HH:mm:ss'Z'"); // Sunday, March 20, 2016 4:05:07 PM
		map.put("EEEE dd'th of' MMMM yyyy hh:mm:ss a", "yyyy-MM-dd'T'HH:mm:ss'Z'"); // Sunday 20th of March 2016 04:05:07 PM
		map.put("EEEE, MMM dd, yyyy", "yyyy-MM-dd"); // Sunday, MAR 20, 2016
		map.put("MM/dd/yyyy hh:mm a", "yyyy-MM-dd'T'HH:mm'Z'"); // 3/20/2016 4:05 PM
		map.put("MM/dd/yyyy hh:mm:ss a", "yyyy-MM-dd'T'HH:mm:ss'Z'"); // 3/20/2016 4:05:07 PM
		map.put("MMMM dd, yyyy", "yyyy-MM-dd"); // March 20, 2016
		map.put("MMMM dd", "MM-dd"); // March 20
		map.put("MMMM, yyyy", "yyyy-MM"); // March, 2016
		map.put("EEE, dd MMM yyyy HH:mm:ss z", "yyyy-MM-dd'T'HH:mm:ss'Z'"); // Sun, 20 Mar 2016 16:05:07 GMT
		map.put("EEE, dd MMM yyyy HH:mm:ss Z", "yyyy-MM-dd'T'HH:mm:ss'Z'"); // Sun, 20 Mar 2016 16:05:07 -0800
		map.put("yyyyMMdd HH:mm:ss", "yyyy-MM-dd'T'HH:mm'Z'"); // 20160320 16:05:07 
		map.put("yyyyMMdd", "yyyy-MM-dd"); // 20160320 
		map.put("yyyy.MM.dd", "yyyy-MM-dd"); // 2016.03.20
		map.put("dd MMMM yyyy", "yyyy-MM-dd"); // 20 March 2016 
		map.put("yyyy-dd-MM'T'hh:mm:ss-HH:mm", "yyyy-MM-dd'T'HH:mm:ss'Z'"); // 2016-20-03T16:05:07-08:00
	}
	
	public String formatDate(String input){
		for (String s : map.keySet()){
			try{
				DateFormat inputDateFormatter = new SimpleDateFormat(s, Locale.ENGLISH);
				Date inputDate = inputDateFormatter.parse(input);
				DateFormat iso8601 = new SimpleDateFormat(map.get(s), Locale.ENGLISH);
				iso8601.setTimeZone(TimeZone.getTimeZone("UTC"));
				return iso8601.format(inputDate);
				
			} catch (ParseException e) {
				continue;
			}
		}
		return "Wrong Format Provided";
	}
	
	public static void main(String args[]){
		DateTime dt = new DateTime();
		Scanner rdr = new Scanner(System.in);
		String input = rdr.nextLine();
		rdr.close();
		String result = dt.formatDate(input);
		System.out.println(result);
	}
}
