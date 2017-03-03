package controller.jackson;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTestSource2 {
	public static void main(String[] args) throws IOException, JsonMappingException, IOException {
		String mr = String.format("{\"name\":\"À±ÇüÈ£\",\"age\": 21,\"admin\":true  }");
		System.out.println(mr);
		ObjectMapper mapper = new ObjectMapper();
		Map map = mapper.readValue(mr, Map.class);
		System.out.println(map.get("name"));
			String s = (String)map.get("name");
		System.out.println(map.get("age"));
			int nn =(Integer)map.get("age");
		System.out.println(map.get("admin"));
			boolean bb =(Boolean)map.get("admin");
	}
}
