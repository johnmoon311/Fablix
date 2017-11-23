package AppService;

import java.io.Reader;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonService{
	
	public static String ToJson(Object o) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(o);
	}
	
	public static Object GetObjectFromJson(String o, Type t) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.fromJson(o, t);
	}
	
	public static Object GetObjectFromJson(JsonElement o, Type t) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.fromJson(o, t);
	}
	
	public static JsonObject GetJsonFromRequest(Reader requestData) {
		JsonParser parser = new JsonParser();
		return (JsonObject) parser.parse(requestData);
	}
}
