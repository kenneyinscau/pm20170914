package util;

import net.sf.json.JSONSerializer;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

public class MyJson {
	public static String toJsonStr(Object obj,final String...propertyNames){
		JsonConfig config=new JsonConfig();
		config.setJsonPropertyFilter(new PropertyFilter(){public boolean apply(Object arg0, String arg1, Object arg2) {
			for (String str : propertyNames) {
				if (arg1.equals(str)) {
					return true;
				}
			}
			return false;
		}});
		String msg=JSONSerializer.toJSON(obj,config).toString();
		return msg;
	}
}
