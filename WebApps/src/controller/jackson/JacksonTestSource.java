package controller.jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTestSource {
	public static void main(String[] args) throws IOException {
		Map map = new LinkedHashMap();
			map.put("id", "patrick");
			map.put("pass", "oralce");
			map.put("age", 19);
			map.put("admin", true);
			map.put("role", new String[]{"connect", "resource"} );
		List li = new ArrayList();
			li.add("monday");
			li.add("friday");
			li.add("saturday");
			li.add("saturday");
			li.add("saturday");
			li.add("sunday");
			li.add("sunday");
		String[] ar = new String[]{"루피", "zoro", "nami", "sanji", "usop"};
		
		ObjectMapper om = new ObjectMapper();
			String m1 = om.writeValueAsString(ar);
		System.out.println(m1);
		
		
		Object o = om.readValue(m1, Object.class);
		// 배열형태였다면===> ArrayList
		System.out.println(o.getClass().getName());
		List oo = om.readValue(m1, List.class);
		System.out.println(oo.size());
		
		String m = om.writeValueAsString(map);
		System.out.println(m);
		
		Map ooo = om.readValue(m, Map.class);
		System.out.println(ooo.getClass().getName());
		System.out.println(ooo.get("role"));
	}
}
