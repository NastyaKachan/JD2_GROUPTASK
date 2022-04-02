package GroupTask.util;

import GroupTask.Annotation.MyColumn;
import java.lang.reflect.Field;

public class ReflectBean {
    public static Object getFieldValue(String s, Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
        String d = f.getDeclaredAnnotation(MyColumn.class).value();
            if (d.equals(s)) {
                try {
                    f.setAccessible(true);
                    return f.get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
