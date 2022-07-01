package org.example.model;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BaseModel<ID> {
    public ID getId() {
        List<Field> classFields = this.getAllClassFields();
        try {
            for (Field field :
                    classFields) {
                if (field.isAnnotationPresent(PrimaryKey.class)){
                    field.setAccessible(true);
                    return (ID) field.get(this);
                }
            }
        } catch (IllegalAccessException | IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    private List<Field> getAllClassFields(){
        Class clazz = this.getClass();
        List<Field> fields = new ArrayList<>();

        while(clazz.getSuperclass() != null) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }

        return fields;
    }
}
