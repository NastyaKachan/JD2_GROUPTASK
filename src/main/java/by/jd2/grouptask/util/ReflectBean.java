package by.jd2.grouptask.util;

import by.jd2.grouptask.annotation.MyColumn;

import java.lang.reflect.Field;

public class ReflectBean {

    public static <T> T getFieldValue(String s, Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            String d = f.getDeclaredAnnotation(MyColumn.class).value();
            if (d.equals(s)) {
                try {
                    f.setAccessible(true);
                    return (T) f.get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
