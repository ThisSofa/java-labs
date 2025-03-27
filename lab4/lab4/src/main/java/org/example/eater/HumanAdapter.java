package org.example.eater;

import com.google.gson.*;
import org.example.model.Human;
import org.example.model.Professor;
import org.example.model.Student;
import org.example.model.Gender;
import org.example.model.Department;

import java.lang.reflect.Type;

public class HumanAdapter implements JsonSerializer<Human>, JsonDeserializer<Human> {

    @Override
    public JsonElement serialize(Human src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.addProperty("type", src.getClass().getSimpleName());

        JsonObject data = new JsonObject();
        data.addProperty("lastName", src.getLastName());
        data.addProperty("firstName", src.getFirstName());
        data.addProperty("middleName", src.getMiddleName());
        data.addProperty("gender", src.getGender().toString());

        if (src instanceof Professor) {
            Professor prof = (Professor) src;
            data.addProperty("department", prof.getDepartment().getName());
        }

        result.add("data", data);
        return result;
    }

    @Override
    public Human deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonObject data = jsonObject.getAsJsonObject("data");

        String lastName = data.get("lastName").getAsString();
        String firstName = data.get("firstName").getAsString();
        String middleName = data.get("middleName").getAsString();
        Gender gender = Gender.valueOf(data.get("gender").getAsString());

        switch (type) {
            case "Professor":
                String departmentName = data.get("department").getAsString();
                Department department = new Department(departmentName, null);
                return new Professor(lastName, firstName, middleName, gender, department);
            case "Student":
                return new Student(lastName, firstName, middleName, gender);
            default:
                return new Human(firstName, lastName, middleName, gender);
        }
    }
}