package org.example.eater;

import org.example.model.Human;
import org.example.model.Professor;
import org.example.model.Student;

import java.lang.reflect.Type;

public class HumanAdapter implements JsonDeserializer<Human>, JsonSerializer<Human> {

    // Десериализация JSON в объект Human (и его подклассы)
    @Override
    public Human deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String className = jsonObject.get("className").getAsString(); // Получаем класс из JSON

        // В зависимости от значения "className" десериализуем в соответствующий класс
        if ("Professor".equals(className)) {
            return context.deserialize(json, Professor.class); // Если это профессор
        } else if ("Student".equals(className)) {
            return context.deserialize(json, Student.class); // Если это студент
        }

        // Если класс неизвестен, выбрасываем исключение
        throw new JsonParseException("Unknown class: " + className);
    }

    // Сериализация объекта Human в JSON
    @Override
    public JsonElement serialize(Human src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = context.serialize(src).getAsJsonObject(); // Сериализуем объект
        jsonObject.addProperty("className", src.getClass().getSimpleName()); // Добавляем поле className в JSON
        return jsonObject;
    }
}
