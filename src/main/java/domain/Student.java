package domain;

import json.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {

    private HashMap<String, Json> studentData = new HashMap<String, Json>();

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        studentData.put("name", new JsonString(name));
        studentData.put("surname", new JsonString(surname));
        studentData.put("year", new JsonNumber(year));

        JsonObject examsData[] = new JsonObject[exams.length];
        int pos = 0;
        for (Tuple<String, Integer> exam: exams) {
            JsonObject examData = new JsonObject();
            examData.add(new JsonPair("course", new JsonString(exam.key)));
            examData.add(new JsonPair("mark", new JsonNumber(exam.value)));
            if (exam.value < 3) {
                examData.add(new JsonPair("passed", new JsonBoolean(false)));
            } else {
                examData.add(new JsonPair("passed", new JsonBoolean(true)));
            }
            examsData[pos] = examData;
            pos++;
        }
        studentData.put("exams", new JsonArray(examsData));
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        for (String key: studentData.keySet()) {
            jsonObject.add(new JsonPair(key, studentData.get(key)));
        }
        return jsonObject;
    }
}