package json;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    HashMap<String, Json> objectData = new HashMap<String, Json>();

    public JsonObject(JsonPair... jsonPairs) {
        for (JsonPair jsonPair: jsonPairs) {
            objectData.put(jsonPair.key, jsonPair.value);
        }
    }

    @Override
    public String toJson() {
        String toJson = "{";
        for (String key: objectData.keySet()) {
            toJson += key + ": " + objectData.get(key).toJson() + ", ";
        }
        if (toJson.equals("{")) {
            return "{}";
        }
        return toJson.substring(0, toJson.length() - 2) + "}";
    }

    public void add(JsonPair jsonPair) {
        objectData.put(jsonPair.key, jsonPair.value);
    }

    public Json find(String name) {
        return objectData.get(name);
    }

    public JsonObject projection(String... names) {
        JsonObject projection = new JsonObject();

        for (String name: names) {
            Json result = objectData.get(name);
            if (result != null) {
                projection.add(new JsonPair(name, result));
            }
        }
        return projection;
    }
}
