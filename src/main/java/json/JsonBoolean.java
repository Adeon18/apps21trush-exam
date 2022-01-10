package json;

/**
 * Created by Andrii_Rodionov on 1/4/2017.
 */
public class JsonBoolean extends Json {

    boolean value;

    public JsonBoolean(Boolean bool) {
        value = bool;
    }

    @Override
    public String toJson() {
        if (value) {
            return "true";
        } else {
            return "false";
        }
    }
}
