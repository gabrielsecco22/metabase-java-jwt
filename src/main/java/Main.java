import java.io.UnsupportedEncodingException;

import org.json.JSONObject;

public class Main {
	
	final static String REQUEST = "{\r\n" + 
			"  \"resource\": {\r\n" + 
			"    \"dashboard\": 4\r\n" + 
			"  },\r\n" + 
			"  \"params\": {\r\n" + 
			"    \"startdate\": \"2018-05-01\",\r\n" + 
			"    \"enddate\": \"2019-05-17\",\r\n" + 
			"    \"hospital\": \"120243\"\r\n" + 
			"  }\r\n" + 
			"}";
	public static void main(String[] args) throws UnsupportedEncodingException {
		JSONObject jsonObject = new JSONObject(REQUEST);
		System.out.println(jsonObject);
		System.out.println(Metabase.getEmbeddedRequestUrl(jsonObject));
	}
}
