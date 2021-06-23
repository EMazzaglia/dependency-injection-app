package factory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Factory {

    // Comentarios realizados para el caso: Factory.getObject(FordFiesta.class);
    public static Object getObject(Class<?> klass) throws InstantiationException, IllegalAccessException {
        // Generamos una nueva instancia de FordFiesta.class
        Object newObject = klass.newInstance();

        // Iteramos sobre todos los campos de la clase FordFiesta
        for (Field field : klass.getDeclaredFields()) {
            //agarramos solo los campos que tengasn la notacion de Injected
            if (field.isAnnotationPresent(Injected.class)) {

                // Field = motor
                // Obtenemos la anotación Injected del campo motor
                Injected injected = field.getAnnotation(Injected.class);

                // Obtenemos la clase a inyectar desde la anotación. (ToyotaMotor.class)
                Class<?> classToInject = injected.implementation();

                // Ponemos el campo en publico para poder modificarlo. field = motor
                field.setAccessible(true);

                //Verificamos si existe un campo q implemente una interface tipo Collection o una classe que implemente la misma
                if (Collection.class.isAssignableFrom(field.getType())){
                    ArrayList myArray = new ArrayList();

                    //verifico se el campo es una interface
                    if(field.getType().isInterface()) {
                        // en caso de que sea interface
                        for (int j = 0; j < injected.count(); j++) {
                            myArray.add(getObject(classToInject));
                        }
                    }else{
                        // en caso de que implemente Collection(POR AHORA SOLO FUNCIONA CON ARRAYLIST)
                        // aca deberia agregar una logica para que se pueda instanciar cualquier tipo de lista que implemente Collection
                        for (int j = 0; j < injected.count(); j++) {
                            myArray.add(getObject(classToInject));
                        }
                    }
                    field.set(newObject, myArray);
                }else{
                    // Ahora seteamos el campo motor de nuestra instancia de FordFiesta
                    // Con la instancia de Motor que creamos
                    // Es decir: Simulamos un newObject.motor = objToInject (new ToyotaMotor)
                    field.set(newObject, getObject(classToInject));
                }
                // Ponemos el campo en privado para no dejarlo publico.
                field.setAccessible(false);
            }
        }
        // Retornamos el objeto FordFiesta con un motor Toyota
        return newObject;
    }
}
