package factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class Factory {

    public static Object getObject(Class<?> klass) throws InstantiationException, IllegalAccessException {
        // Generamos una nueva instancia requerida (Ej. FordFiesta.class)
        Object newObject = klass.newInstance();

        // Iteramos sobre todos los campos de la clase. (Ej. FordFiesta.class)
        for (Field field : klass.getDeclaredFields()) {
            // (Primera iteración Field = motor)
            // Obtenemos la anotación Injected del campo. (Ej. Motor)
            Injected injected = field.getAnnotation(Injected.class);

            // Obtenemos la clase a inyectar de la anotación. (Ej. ToyotaMotor.class)
            Class<?> injectedClass = injected.implementation();

            // Generamos una instancia de la clase del campo.  (Ej. ToyotaMotor.class)
            Object injectObj = injectedClass.newInstance();

            // Ponemos el campo en publico para poder modificarlo
            field.setAccessible(true);
            
            // Inyectamos la nueva instancia del campo en la clase padre.
            // Es decir: FordFiesta -> motor = new ToyotaMotor()
            field.set(newObject, injectObj);
            // Ponemos el campo en privado para no dejarlo publico.
            field.setAccessible(false);
        }
        return newObject;
    }
}
