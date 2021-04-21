package com.pet.ft.common;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class test {

	public static void main(String[] args) {
		
		String smsresponse = "{\r\n"
				+ "    \"groupId\": \"G4V20210123194110GWBC43DH4JPGSL2\",\r\n"
				+ "    \"to\": \"01000000001\",\r\n"
				+ "    \"from\": \"029302266\",\r\n"
				+ "    \"type\": \"SMS\",\r\n"
				+ "    \"statusMessage\": \"정상 접수(이통사로 접수 예정) \",\r\n"
				+ "    \"country\": \"82\",\r\n"
				+ "    \"messageId\": \"M4V20210123194110MJGRRENWJIH0MXA\",\r\n"
				+ "    \"statusCode\": \"2000\",\r\n"
				+ "    \"accountId\": \"12925149\"\r\n"
				+ "}";
		
	    JsonObject resjson = (JsonObject) JsonParser.parseString(smsresponse.toString());
	    String  v = resjson.get("from").getAsString();
	    System.out.println(v);
		
	}
	
}
