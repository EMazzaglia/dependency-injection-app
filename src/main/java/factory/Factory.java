package factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class Factory {

    // Comentarios realizados para el caso: Factory.getObject(FordFiesta.class);
    public static Object getObject(Class<?> klass) throws InstantiationException, IllegalAccessException {
        // Generamos una nueva instancia de FordFiesta.class
        Object newObject = klass.newInstance();

        // Iteramos sobre todos los campos de la clase FordFiesta
        for (Field field : klass.getDeclaredFields()) {
            // Field = motor
            // Obtenemos la anotación Injected del campo motor
            Injected injected = field.getAnnotation(Injected.class);

            // Obtenemos la clase a inyectar desde la anotación. (ToyotaMotor.class)
            Class<?> classToInject = injected.implementation();

            // Generamos una instancia de ToyotaMotor
            Object objToInject = classToInject.newInstance();

            // Ponemos el campo en publico para poder modificarlo. field = motor
            field.setAccessible(true);

            // Ahora seteamos el campo motor de nuestra instancia de FordFiesta con la instancia de Motor
            // Es decir: FordFiesta -> motor = new ToyotaMotor()
            field.set(newObject, objToInject);
            // Ponemos el campo en privado para no dejarlo publico.
            field.setAccessible(false);
        }
        // Retornamos el objeto FordFiesta con un motor Toyota
        return newObject;
    }
}
