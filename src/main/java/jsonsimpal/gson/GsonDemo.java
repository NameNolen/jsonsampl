package jsonsimpal.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class GsonDemo {
    public static String bean2Json(Object object){
        Gson gson = new GsonBuilder().create();
        return gson.toJson(object);
    }
//{"1":"Dec 9, 2017 3:12:13 PM","2":"May 24, 1970 5:21:18 AM","3":"Jun 12, 3890 12:00:00 AM"}
    public static void  main(String[] args){
        Map map = new HashMap<String, Date>();
        map.put("1",new Date());
        map.put("2",new Date(12345678123l));
        map.put("3",new Date(1990,5,12));
        System.out.println(bean2Json(map));
    }

    public static <T> T json2Bean(String jsonStr, Class<T> clazz){
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(jsonStr, clazz);
    }


}
