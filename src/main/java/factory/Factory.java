package factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class Factory {

    public static Object getObject(Class<?> klass) throws InstantiationException, IllegalAccessException {
        Object newObject = klass.newInstance();

        for (Field field : klass.getDeclaredFields()) {
            Annotation[] annotations = field.getAnnotations();

            Injected injected = field.getAnnotation(Injected.class);
            Class<?> injectedClass = injected.implementation();
            Object injectObj = injectedClass.newInstance();

            field.setAccessible(true);
            field.set(newObject, injectObj);
            field.setAccessible(false);
        }
        return newObject;
    }
}
