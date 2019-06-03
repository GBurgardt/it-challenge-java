package utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.enterprise.context.ApplicationScoped;

import javax.servlet.http.HttpServletRequest;


@ApplicationScoped
public class Utils {
    
    public static JsonObject inputStreamToJson(InputStream inputStream) throws IOException {
        try {
            
            JsonParser parser = new JsonParser();
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            br.lines().forEach(linea -> {
                sb.append(linea);
            });

            if (sb.length() > 0) {
                return parser.parse(sb.toString()).getAsJsonObject();
            }
        }
        catch(Exception ex) {
            System.out.println(ex);
        }
        
        return null;
        
    }

    public static JsonObject getJsonObjectFromRequest(HttpServletRequest request) throws Exception {
        if (request.getInputStream() == null) {
            throw new Exception("InputStream de request es null");
        }
        
        JsonObject jsonObj = inputStreamToJson(request.getInputStream());
        
        if (jsonObj == null) {
            throw new Exception("inputStreamToJson falló; no se puede pasar el InputStream a Json");
        }
        
        return jsonObj;
    }
    
    public static Serializable getKeyFromJsonObject (
        String clave, 
        JsonObject jsonObj,
        String tipoRespuesta
    ) throws Exception {
        try{
            JsonPrimitive jsonPri = jsonObj.getAsJsonPrimitive(clave);           
            if (jsonPri == null) { 
                return null;
            }
            Serializable claveBody = null;
            if (tipoRespuesta.equals("String")) {
                claveBody = jsonPri.getAsString();
            } else if (tipoRespuesta.equals("Integer")) {
                claveBody = jsonPri.getAsInt();
            } else if (tipoRespuesta.equals("boolean")) {
                claveBody = jsonPri.getAsBoolean();
            } else if (tipoRespuesta.equals("BigDecimal")) {
                claveBody = jsonPri.getAsBigDecimal();
            } else if (tipoRespuesta.equals("Long")) {
                claveBody = jsonPri.getAsLong();
            } else if (tipoRespuesta.equals("Date")) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date date = format.parse(jsonPri.getAsString());
                claveBody = date;               
            } else if (tipoRespuesta.equals("Byte")) {
                claveBody = jsonPri.getAsByte();
            }
            if (claveBody == null) {
                throw new Exception("No se puede pasar "+clave+" a "+tipoRespuesta);
            }
            return claveBody;
        } catch (Exception e) {
            return null;
        }       
    }
    
}
