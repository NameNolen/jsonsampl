package jsonsimpal.jackson;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JacksonDemo {
    public static String bean2Json(Object object) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();
        JsonGenerator jsonGenerator = new JsonFactory().createJsonGenerator(stringWriter);
        objectMapper.writeValue(jsonGenerator,object);
        jsonGenerator.close();
        return stringWriter.toString();
    }
    //{"1":1512803833326,"2":12345678123,"3":60603350400000}
    public static void main(String[] args) throws IOException {
        Map map = new HashMap<String, Date>();
        map.put("1",new Date());
        map.put("2",new Date(12345678123l));
        map.put("3",new Date(1990,5,12));
        System.out.println(bean2Json(map));
    }

    public static <T> T json2Bean(String jsonStr,Class<T> clazz) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonStr,clazz);
    }

}
