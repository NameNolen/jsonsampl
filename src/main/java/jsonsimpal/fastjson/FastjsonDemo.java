package jsonsimpal.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FastjsonDemo {
    public static String bean2Json(Object object){
        return JSON.toJSONString(object);
    }
    //{"1":1512803963307,"2":12345678123,"3":60603350400000}
    public static void main(String[] args){
        Map map = new HashMap<String, Date>();
        map.put("1",new Date());
        map.put("2",new Date(12345678123l));
        map.put("3",new Date(1990,5,12));
        System.out.println(bean2Json(map));
    }
    public static <T> T json2Bean (String jsonStr, Class<T> clazz){
        return JSON.parseObject(jsonStr, clazz);
    }
}
