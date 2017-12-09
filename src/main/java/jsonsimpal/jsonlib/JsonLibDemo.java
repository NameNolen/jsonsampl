package jsonsimpal.jsonlib;

import net.sf.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JsonLibDemo {
    public static String bean2Json(Object object){
        JSONObject jsonObject = JSONObject.fromObject(object);
        return jsonObject.toString();
    }
    //{"1":{"date":9,"day":6,"hours":15,"minutes":12,"month":11,"seconds":37,"time":1512803557837,"timezoneOffset":-480,"year":117},"2":{"date":24,"day":0,"hours":5,"minutes":21,"month":4,"seconds":18,"time":12345678123,"timezoneOffset":-480,"year":70},"3":{"date":12,"day":4,"hours":0,"minutes":0,"month":5,"seconds":0,"time":60603350400000,"timezoneOffset":-480,"year":1990}}
    public static void  main(String[] args){
        Map map = new HashMap<String, Date>();
        map.put("1",new Date());
        map.put("2",new Date(12345678123l));
        map.put("3",new Date(1990,5,12));
        System.out.println(bean2Json(map));
    }

    public static  <T> T json2Bean(String jsonStr, Class<T> clazz){
        return (T)JSONObject.toBean(JSONObject.fromObject(jsonStr),clazz);
    }
}
